package taxi.flashka.me.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import taxi.flashka.me.BR;
import taxi.flashka.me.R;
import taxi.flashka.me.databinding.ActivityRegisterBinding;
import taxi.flashka.me.view.model.RegisterViewModel;

public class RegisterActivity extends BaseActivity<RegisterViewModel, ActivityRegisterBinding> {

    @Override
    public RegisterViewModel onCreateViewModel() {
        return new RegisterViewModel();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    public int getVariable() {
        return BR.viewModel;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupToolbar();
    }
}
