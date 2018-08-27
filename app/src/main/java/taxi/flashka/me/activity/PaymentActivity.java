package taxi.flashka.me.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.android.databinding.library.baseAdapters.BR;

import taxi.flashka.me.R;
import taxi.flashka.me.databinding.ActivityPaymentBinding;
import taxi.flashka.me.view.model.PaymentViewModel;

public class PaymentActivity extends BaseActivity<PaymentViewModel, ActivityPaymentBinding> {

    @Override
    public PaymentViewModel onCreateViewModel() {
        return ViewModelProviders.of(this).get(PaymentViewModel.class);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_payment;
    }

    @Override
    public int getVariable() {
        return BR.viewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupToolbar();

        viewModel.getCardEvent().observe(this, new Observer<Void>() {
            @Override
            public void onChanged(@Nullable Void aVoid) {

            }
        });
        viewModel.getWalletEvent().observe(this, new Observer<Void>() {
            @Override
            public void onChanged(@Nullable Void aVoid) {

            }
        });
    }
}
