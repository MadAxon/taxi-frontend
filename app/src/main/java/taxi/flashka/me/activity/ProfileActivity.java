package taxi.flashka.me.activity;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.bluelinelabs.logansquare.LoganSquare;

import java.io.IOException;

import taxi.flashka.me.BR;
import taxi.flashka.me.R;
import taxi.flashka.me.databinding.ActivityProfileBinding;
import taxi.flashka.me.interfaces.IDateSetListener;
import taxi.flashka.me.repository.model.UserModel;
import taxi.flashka.me.repository.response.StatusResponse;
import taxi.flashka.me.view.DatePickerDialog;
import taxi.flashka.me.view.model.ProfileViewModel;

public class ProfileActivity extends BaseActivity<ProfileViewModel, ActivityProfileBinding>
        implements IDateSetListener {

    public static final String PROFILE = "PROFILE";

    @Override
    public ProfileViewModel onCreateViewModel() {
        return ViewModelProviders.of(this).get(ProfileViewModel.class);
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

        try {
            viewModel.initUserModel(LoganSquare.parse(getIntent().getStringExtra(PROFILE), UserModel.class));
        } catch (IOException e) {
            e.printStackTrace();
        }

        viewModel.getBirthDateEvent().observe(this, new Observer<Void>() {
            @Override
            public void onChanged(@Nullable Void aVoid) {
                new DatePickerDialog(ProfileActivity.this, ProfileActivity.this);
            }
        });
        viewModel.getPasswordEvent().observe(this, new Observer<Void>() {
            @Override
            public void onChanged(@Nullable Void aVoid) {
                startActivity(new Intent(ProfileActivity.this, ProfilePasswordActivity.class));
            }
        });
        viewModel.getCityEvent().observe(this, new Observer<Void>() {
            @Override
            public void onChanged(@Nullable Void aVoid) {
                startActivityForResult(new Intent(ProfileActivity.this, CityActivity.class)
                        , CityActivity.REQUEST_CITY);
            }
        });
        viewModel.getFinishEvent().observe(this, new Observer<Void>() {
            @Override
            public void onChanged(@Nullable Void aVoid) {
                finish();
            }
        });
    }

    @Override
    public void onDateSet(String date) {
        viewModel.onDateSet(date);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        viewModel.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onChanged(@Nullable StatusResponse statusResponse) {
        super.onChanged(statusResponse);
        if (statusResponse != null && statusResponse.getStatus() == 200)
            showSuccessSnackbar(statusResponse.getMessage());
    }
}
