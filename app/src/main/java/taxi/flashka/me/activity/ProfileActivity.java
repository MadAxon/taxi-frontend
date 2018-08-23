package taxi.flashka.me.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import taxi.flashka.me.BR;
import taxi.flashka.me.R;
import taxi.flashka.me.databinding.ActivityProfileBinding;
import taxi.flashka.me.view.model.ProfileViewModel;

public class ProfileActivity extends BaseActivity<ProfileViewModel, ActivityProfileBinding> {

    @Override
    public ProfileViewModel onCreateViewModel() {
        return new ProfileViewModel();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_profile;
    }

    @Override
    public int getVariable() {
        return BR.viewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupToolbar();
    }
}
