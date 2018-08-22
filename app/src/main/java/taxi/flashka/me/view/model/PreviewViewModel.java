package taxi.flashka.me.view.model;

import android.content.Context;
import android.content.Intent;

import taxi.flashka.me.activity.LoginActivity;
import taxi.flashka.me.activity.RegisterActivity;

public class PreviewViewModel extends ViewModel {

    public void onClickedLogin(Context context) {
        context.startActivity(new Intent(context, LoginActivity.class));
    }

    public void onClickedRegister(Context context) {
        context.startActivity(new Intent(context, RegisterActivity.class));
    }

    public void onClickedInfo(Context context) {

    }

}
