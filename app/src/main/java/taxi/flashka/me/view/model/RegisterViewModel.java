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
import taxi.flashka.me.repository.model.CityModel;
import taxi.flashka.me.repository.request.BaseRequest;
import taxi.flashka.me.repository.request.RegisterRequest;
import taxi.flashka.me.repository.response.ItemResponse;
import taxi.flashka.me.repository.service.OkhttpService;
import taxi.flashka.me.view.SingleLiveEvent;

public class RegisterViewModel extends ViewModel {

    public ObservableField<String>
            tel = new ObservableField<>("")
            , lastName = new ObservableField<>("")
            , firstName = new ObservableField<>("")
            , patronymic = new ObservableField<>("")
            , birthDate = new ObservableField<>("")
            , carNumber = new ObservableField<>("")
            , regionCode = new ObservableField<>("");

    public ObservableField<CityModel> city = new ObservableField<>(new CityModel(0));

    public ObservableField<Integer>
            carNumberLength = new ObservableField<>(8)
            , regionCodeLength = new ObservableField<>(3)
            , inputType = new ObservableField<>(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_CLASS_PHONE);

    public ObservableField<Boolean> editable = new ObservableField<>(false);

    private SingleLiveEvent<Void> birthDateEvent = new SingleLiveEvent<>()
            , cityEvent = new SingleLiveEvent<>()
            , offerEvent = new SingleLiveEvent<>();

    private MutableLiveData<String> password = new MutableLiveData<>();

    public RegisterViewModel(@NonNull Application application) {
        super(application);
    }

    public void onClickedOffer() {
        offerEvent.call();
    }

    public void onClickedContinue() {
        okhttpService = new OkhttpService<String>(token, new BaseRequest<>("auth/registration"
                , new RegisterRequest(birthDate.get(), carNumber.get() + regionCode.get()
                , lastName.get(), firstName.get(), patronymic.get(), tel.get(), new CityModel(city.get().getId())))) {
            @Override
            protected ParameterizedType<ItemResponse<String>> getParameterizedType() {
                return new ParameterizedType<ItemResponse<String>>() {};
            }
        };
        okhttpService.sendRequest(statusLiveEvent, password, isLoading);
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

    public void onClickedBirthDate() {
        birthDateEvent.call();
    }

    public void onClickedCity() {
        cityEvent.call();
    }

    public SingleLiveEvent<Void> getCityEvent() {
        return cityEvent;
    }

    public SingleLiveEvent<Void> getBirthDateEvent() {
        return birthDateEvent;
    }

    public SingleLiveEvent<Void> getOfferEvent() {
        return offerEvent;
    }

    public MutableLiveData<String> getPassword() {
        return password;
    }
}
