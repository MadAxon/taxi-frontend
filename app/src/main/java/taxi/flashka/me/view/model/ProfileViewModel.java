package taxi.flashka.me.view.model;

import android.app.Activity;
import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.content.Intent;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.text.InputType;

import com.bluelinelabs.logansquare.LoganSquare;
import com.bluelinelabs.logansquare.ParameterizedType;

import java.io.IOException;

import taxi.flashka.me.activity.CityActivity;
import taxi.flashka.me.interfaces.IDateSetListener;
import taxi.flashka.me.repository.model.CityModel;
import taxi.flashka.me.repository.model.UserModel;
import taxi.flashka.me.repository.request.BaseRequest;
import taxi.flashka.me.repository.request.UserUpdateRequest;
import taxi.flashka.me.repository.response.BaseResponse;
import taxi.flashka.me.repository.service.OkhttpService;
import taxi.flashka.me.view.SingleLiveEvent;

public class ProfileViewModel extends ViewModel implements IDateSetListener {

    public MutableLiveData<UserModel> userModel = new MutableLiveData<>();

    public ObservableField<String>
            lastName = new ObservableField<>("")
            , firstName = new ObservableField<>("")
            , patronymic = new ObservableField<>()
            , birthDate = new ObservableField<>();

    public ObservableField<CityModel> city = new ObservableField<>();

    public ObservableField<Integer>
            carNumberLength = new ObservableField<>(8)
            , regionCodeLength = new ObservableField<>(3)
            , inputType = new ObservableField<>(InputType.TYPE_CLASS_NUMBER
            | InputType.TYPE_NUMBER_FLAG_SIGNED);

    public ObservableField<Boolean> editable = new ObservableField<>(false);

    private SingleLiveEvent<Void> birthDateEvent = new SingleLiveEvent<>()
            , cityEvent = new SingleLiveEvent<>()
            , passwordEvent = new SingleLiveEvent<>()
            , finishEvent = new SingleLiveEvent<>();

    public ProfileViewModel(@NonNull Application application) {
        super(application);
    }

    public void onClickedCity() {
        cityEvent.call();
    }

    public void onClickedPassword() {
        passwordEvent.call();
    }

    public void onClickedSave() {
        if (userModel.getValue().getFirstName().equals(firstName.get())
                && userModel.getValue().getLastName().equals(lastName.get())
                && (userModel.getValue().getPatronymic() != null
                    && userModel.getValue().getPatronymic().equals(patronymic.get())
                    || userModel.getValue().getPatronymic() == null && patronymic.get() == null)
                && (userModel.getValue().getBirthDate() != null
                    && userModel.getValue().getBirthDate().equals(birthDate.get())
                    || userModel.getValue().getBirthDate() == null && birthDate.get() == null)
                && userModel.getValue().getCity().getId() == city.get().getId()) finishEvent.call();
        else {
            OkhttpService okhttpService = new OkhttpService(token, new BaseRequest<>("user/update"
                    , new UserUpdateRequest(birthDate.get(), city.get(), patronymic.get(), lastName.get(), firstName.get()))) {
                @Override
                protected ParameterizedType<BaseResponse<String>> getParameterizedType() {
                    return new ParameterizedType<BaseResponse<String>>() {};
                }
            };
            okhttpService.sendRequest(statusLiveEvent, null, isLoading);
        }
    }

    public void onClickedBirthDate() {
        birthDateEvent.call();
    }

    public SingleLiveEvent<Void> getBirthDateEvent() {
        return birthDateEvent;
    }

    public SingleLiveEvent<Void> getPasswordEvent() {
        return passwordEvent;
    }

    public SingleLiveEvent<Void> getCityEvent() {
        return cityEvent;
    }

    public SingleLiveEvent<Void> getFinishEvent() {
        return finishEvent;
    }

    public void initUserModel(UserModel model) {
        userModel.setValue(model);
        firstName.set(userModel.getValue().getFirstName());
        lastName.set(userModel.getValue().getLastName());
        patronymic.set(userModel.getValue().getPatronymic());
        birthDate.set(userModel.getValue().getBirthDate());
        city.set(userModel.getValue().getCity());
    }

    @Override
    public void onDateSet(String date) {
        userModel.getValue().setBirthDate(date);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CityActivity.REQUEST_CITY && resultCode == Activity.RESULT_OK) {
            try {
                city.set(LoganSquare.parse(data.getStringExtra(CityActivity.CITY), CityModel.class));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
