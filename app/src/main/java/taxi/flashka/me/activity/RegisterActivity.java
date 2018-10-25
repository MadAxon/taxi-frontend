package taxi.flashka.me.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;

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
        //Plxvas
        viewModel.getPassword().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String password) {
                if (password != null)
                    new AlertDialog.Builder(RegisterActivity.this, R.style.AppTheme_Dialog)
                            .setMessage(getString(R.string.message_registration_successful, password))
                            .setCancelable(false)
                            .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            })
                            .show();
            }
        });

        viewModel.getOfferEvent().observe(this, new Observer<Void>() {
            @Override
            public void onChanged(@Nullable Void aVoid) {
                Intent intent = new Intent(RegisterActivity.this, WebActivity.class);
                intent.putExtra(WebActivity.TITLE, "");
                intent.putExtra(WebActivity.URL, "");
                startActivity(intent);
            }
        });

        viewModel.getCityEvent().observe(this, new Observer<Void>() {
            @Override
            public void onChanged(@Nullable Void aVoid) {
                startActivityForResult(new Intent(RegisterActivity.this, CityActivity.class)
                        , CityActivity.REQUEST_CITY);
            }
        });
    }

    @Override
    public void onDateSet(String date) {
        viewModel.birthDate.set(date);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        viewModel.onActivityResult(requestCode, resultCode, data);
    }
}
