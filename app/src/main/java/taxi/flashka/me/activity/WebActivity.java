package taxi.flashka.me.activity;

import android.os.Bundle;

import taxi.flashka.me.BR;
import taxi.flashka.me.R;
import taxi.flashka.me.databinding.ActivityWebBinding;
import taxi.flashka.me.view.model.WebViewModel;

public class WebActivity extends BaseActivity<WebViewModel, ActivityWebBinding> {

    public final static String TITLE = "TITLE"
            , URL = "URL";

    @Override
    public WebViewModel onCreateViewModel() {
        return new WebViewModel(getApplication(), getIntent().getStringExtra(URL));
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_web;
    }

    @Override
    public int getVariable() {
        return BR.viewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupToolbar(getIntent().getIntExtra(TITLE, R.string.app_name));
    }
}
