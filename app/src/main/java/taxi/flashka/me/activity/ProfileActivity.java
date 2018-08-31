package taxi.flashka.me.activity;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;

import java.util.Calendar;

import taxi.flashka.me.BR;
import taxi.flashka.me.R;
import taxi.flashka.me.databinding.ActivityProfileBinding;
import taxi.flashka.me.databinding.DialogPasswordChangingBinding;
import taxi.flashka.me.interfaces.IDateSetListener;
import taxi.flashka.me.view.DatePickerDialog;
import taxi.flashka.me.view.model.ProfileViewModel;

public class ProfileActivity extends BaseActivity<ProfileViewModel, ActivityProfileBinding>
        implements IDateSetListener {

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
                final DialogPasswordChangingBinding dialogBinding = DialogPasswordChangingBinding
                        .inflate(LayoutInflater.from(ProfileActivity.this));
                dialogBinding.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                new AlertDialog.Builder(ProfileActivity.this, R.style.AppTheme_Dialog)
                        .setTitle(R.string.register_password_title)
                        .setView(dialogBinding.getRoot())
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Log.i("my_logs", dialogBinding.getNewPassword()
                                        + dialogBinding.getNewPasswordAgain()
                                        + dialogBinding.getOldPassword());
                                viewModel.changePassword();
                            }
                        })
                        .setNegativeButton(android.R.string.cancel, null)
                        .show();
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
