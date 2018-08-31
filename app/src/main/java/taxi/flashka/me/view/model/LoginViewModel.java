package taxi.flashka.me.view.model;

import android.databinding.ObservableField;
import android.text.InputType;

import taxi.flashka.me.view.SingleLiveEvent;

public class LoginViewModel extends ViewModel {

    public ObservableField<String>
            telephone = new ObservableField<>(""), password = new ObservableField<>("");

    public ObservableField<Integer> inputTypeLogin = new ObservableField<>(InputType.TYPE_CLASS_NUMBER
                | InputType.TYPE_NUMBER_FLAG_SIGNED)
            , inputTypePassword = new ObservableField<>(InputType.TYPE_CLASS_TEXT
                | InputType.TYPE_TEXT_VARIATION_PASSWORD);

    public ObservableField<Boolean> isPasswordShowed = new ObservableField<>(false)
            , isPreviewShowed = new ObservableField<>(true);

    private SingleLiveEvent<Void> registerEvent = new SingleLiveEvent<>()
            , infoEvent = new SingleLiveEvent<>()
            , signInEvent = new SingleLiveEvent<>();

    public LoginViewModel() {
        isLoading.setValue(false);
    }

    public void onClickedSignIn() {
        if (isPreviewShowed.get()) isPreviewShowed.set(!isPreviewShowed.get());
        else signInEvent.call();
    }

    public void onClickedRegister() {
        registerEvent.call();
    }

    public void onClickedEye() {
        isPasswordShowed.set(!isPasswordShowed.get());
    }

    public void onClickedInfo() {
        isLoading.setValue(!isLoading.getValue());
        infoEvent.call();
    }

    public SingleLiveEvent<Void> getRegisterEvent() {
        return registerEvent;
    }

    public SingleLiveEvent<Void> getInfoEvent() {
        return infoEvent;
    }

    public SingleLiveEvent<Void> getSignInEvent() {
        return signInEvent;
    }
}
