package taxi.flashka.me.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;

import taxi.flashka.me.BR;
import taxi.flashka.me.R;
import taxi.flashka.me.databinding.ActivityRegisterBinding;
import taxi.flashka.me.interfaces.IDateSetListener;
import taxi.flashka.me.view.DatePickerDialog;
import taxi.flashka.me.view.model.RegisterViewModel;

public class RegisterActivity extends BaseActivity<RegisterViewModel, ActivityRegisterBinding>
        implements IDateSetListener {

    @Override
    public RegisterViewModel onCreateViewModel() {
        return ViewModelProviders.of(this).get(RegisterViewModel.class);
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

        viewModel.getBirthDateEvent().observe(this, new Observer<Void>() {
            @Override
            public void onChanged(@Nullable Void aVoid) {
                new DatePickerDialog(RegisterActivity.this, RegisterActivity.this);
            }
        });
        viewModel.getContinueEvent().observe(this, new Observer<Void>() {
            @Override
            public void onChanged(@Nullable Void aVoid) {

            }
        });
        viewModel.getOfferEvent().observe(this, new Observer<Void>() {
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
