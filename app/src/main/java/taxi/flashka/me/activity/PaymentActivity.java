package taxi.flashka.me.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.android.databinding.library.baseAdapters.BR;

import taxi.flashka.me.R;
import taxi.flashka.me.databinding.ActivityPaymentBinding;
import taxi.flashka.me.repository.response.StatusResponse;
import taxi.flashka.me.view.model.PaymentViewModel;

public class PaymentActivity extends BaseActivity<PaymentViewModel, ActivityPaymentBinding> {

    public static final String OFFER_ID = "OFFER_ID";

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
        viewModel.setOfferId(getIntent().getLongExtra(OFFER_ID, 0));

        viewModel.getUrl().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String url) {
                if (url != null) {
                    Intent intent = new Intent(PaymentActivity.this, WebActivity.class);
                    intent.putExtra(WebActivity.TITLE, getString(R.string.payment));
                    intent.putExtra(WebActivity.URL, url);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void onChanged(@Nullable StatusResponse statusResponse) {
        super.onChanged(statusResponse);
        if (statusResponse != null && !statusResponse.getMessage().isEmpty())
            showSuccessSnackbar(statusResponse.getMessage());
    }
}
