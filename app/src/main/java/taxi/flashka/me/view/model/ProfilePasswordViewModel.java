package taxi.flashka.me.view.model;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.text.InputType;

import com.bluelinelabs.logansquare.ParameterizedType;

import taxi.flashka.me.repository.request.BaseRequest;
import taxi.flashka.me.repository.request.PasswordChangingRequest;
import taxi.flashka.me.repository.response.BaseResponse;
import taxi.flashka.me.repository.service.OkhttpService;

public class ProfilePasswordViewModel extends ViewModel {

    public final ObservableField<Integer> inputTypePassword = new ObservableField<>(InputType.TYPE_CLASS_TEXT
            | InputType.TYPE_TEXT_VARIATION_PASSWORD);

    public final ObservableField<String> oldPassword = new ObservableField<>(""),
            newPassword = new ObservableField<>(""),
            newPasswordAgain = new ObservableField<>("");


    public ProfilePasswordViewModel(@NonNull Application application) {
        super(application);
    }

    public void onClickedSend() {
        okhttpService = new OkhttpService(token, new BaseRequest<>("user/password/change"
                , new PasswordChangingRequest(oldPassword.get(), newPassword.get(), newPasswordAgain.get()))) {
            @Override
            protected ParameterizedType<BaseResponse<String>> getParameterizedType() {
                return new ParameterizedType<BaseResponse<String>>() {};
            }
        };
        okhttpService.sendRequest(statusLiveEvent, null, isLoading);
    }

}
