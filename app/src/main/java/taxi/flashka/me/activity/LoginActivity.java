package taxi.flashka.me.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import taxi.flashka.me.BR;
import taxi.flashka.me.R;
import taxi.flashka.me.databinding.ActivityLoginBinding;
import taxi.flashka.me.view.model.LoginViewModel;

public class LoginActivity extends BaseActivity<LoginViewModel, ActivityLoginBinding> {

    @Override
    public LoginViewModel onCreateViewModel() {
        return new LoginViewModel();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public int getVariable() {
        return BR.viewModel;
    }

}
