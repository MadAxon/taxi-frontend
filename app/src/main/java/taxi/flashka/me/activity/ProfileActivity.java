package taxi.flashka.me.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;

import java.util.Calendar;

import taxi.flashka.me.BR;
import taxi.flashka.me.R;
import taxi.flashka.me.databinding.ActivityProfileBinding;
import taxi.flashka.me.interfaces.IDateSetListener;
import taxi.flashka.me.view.DatePickerDialog;
import taxi.flashka.me.view.model.ProfileViewModel;

public class ProfileActivity extends BaseActivity<ProfileViewModel, ActivityProfileBinding>
        implements IDateSetListener {

    private final Calendar calendar = Calendar.getInstance();

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

        viewModel.getBirthDateEvent().observe(this, new Observer<Void>() {
            @Override
            public void onChanged(@Nullable Void aVoid) {
                new DatePickerDialog(ProfileActivity.this, ProfileActivity.this);
            }
        });
        viewModel.getPasswordEvent().observe(this, new Observer<Void>() {
            @Override
            public void onChanged(@Nullable Void aVoid) {

            }
        });
        viewModel.getSaveEvent().observe(this, new Observer<Void>() {
            @Override
            public void onChanged(@Nullable Void aVoid) {

            }
        });
    }

    @Override
    public void onDateSet(String date) {
        viewModel.birthDate.set(date);
    }
}
