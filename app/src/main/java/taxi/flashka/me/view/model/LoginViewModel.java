package taxi.flashka.me.view.model;

import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableField;
import android.text.InputType;
import android.util.Log;

import taxi.flashka.me.activity.DealActivity;
import taxi.flashka.me.activity.RegisterActivity;

public class LoginViewModel extends ViewModel {

    public ObservableField<String>
            telephone = new ObservableField<>(""), password = new ObservableField<>("");

    public ObservableField<Integer> inputTypeLogin = new ObservableField<>(InputType.TYPE_CLASS_NUMBER
                | InputType.TYPE_NUMBER_FLAG_SIGNED)
            , inputTypePassword = new ObservableField<>(InputType.TYPE_CLASS_TEXT
                | InputType.TYPE_TEXT_VARIATION_PASSWORD);

    public ObservableField<Boolean> isShown = new ObservableField<>(false);

    public void onSignInClicked(Context context) {
        Log.i("my_logs", telephone.get());
        Log.i("my_logs", password.get());
        context.startActivity(new Intent(context, DealActivity.class));
    }

    public void onClickedRegister(Context context) {
        context.startActivity(new Intent(context, RegisterActivity.class));
    }

    public void onClickedEye() {
        isShown.set(!isShown.get());
    }
}
