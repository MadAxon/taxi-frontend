package taxi.flashka.me.view.model;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.text.InputType;

import com.bluelinelabs.logansquare.ParameterizedType;

import taxi.flashka.me.repository.preference.SharedPrefs;
import taxi.flashka.me.repository.request.BaseRequest;
import taxi.flashka.me.repository.request.SignInRequest;
import taxi.flashka.me.repository.response.ItemResponse;
import taxi.flashka.me.repository.service.OkhttpService;
import taxi.flashka.me.view.SingleLiveEvent;

public class LoginViewModel extends ViewModel {

    public ObservableField<String>
            telephone = new ObservableField<>(""), password = new ObservableField<>("");

    public ObservableField<Integer> inputTypeLogin = new ObservableField<>(InputType.TYPE_CLASS_NUMBER
            | InputType.TYPE_NUMBER_FLAG_SIGNED), inputTypePassword = new ObservableField<>(InputType.TYPE_CLASS_TEXT
            | InputType.TYPE_TEXT_VARIATION_PASSWORD);

    public ObservableField<Boolean> isPasswordShowed = new ObservableField<>(false), isPreviewShowed = new ObservableField<>(true);

    private SingleLiveEvent<Void> registerEvent = new SingleLiveEvent<>()
            , infoEvent = new SingleLiveEvent<>();

    private final MutableLiveData<String> token = new MutableLiveData<>();

    public LoginViewModel(@NonNull Application application) {
        super(application);
    }

    public void onClickedSignIn() {
        if (isPreviewShowed.get()) isPreviewShowed.set(!isPreviewShowed.get());
        else {
            okhttpService = new OkhttpService<String>(new BaseRequest<>("auth/login"
                    , new SignInRequest(telephone.get(), password.get()))) {

                @Override
                protected ParameterizedType<ItemResponse<String>> getParameterizedType() {
                    return new ParameterizedType<ItemResponse<String>>() {
                    };
                }
            };
            okhttpService.sendRequest(statusLiveEvent, token, isLoading);
        }
    }

    public void setToken(String token) {
        SharedPrefs.getInstance().setToken(getApplication().getApplicationContext(), token);
    }

    public void onClickedRegister() {
        registerEvent.call();
    }

    public void onClickedEye() {
        isPasswordShowed.set(!isPasswordShowed.get());
    }

    public void onClickedInfo() {
        infoEvent.call();
    }

    public SingleLiveEvent<Void> getRegisterEvent() {
        return registerEvent;
    }

    public SingleLiveEvent<Void> getInfoEvent() {
        return infoEvent;
    }

    public MutableLiveData<String> getToken() {
        return token;
    }
}
