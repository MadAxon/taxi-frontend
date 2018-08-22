package taxi.flashka.me.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.databinding.library.baseAdapters.BR;

import taxi.flashka.me.R;
import taxi.flashka.me.databinding.ActivityPaymentBinding;
import taxi.flashka.me.view.model.PaymentViewModel;

public class PaymentActivity extends BaseActivity<PaymentViewModel, ActivityPaymentBinding> {

    @Override
    public PaymentViewModel onCreateViewModel() {
        return new PaymentViewModel();
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
    }
}
