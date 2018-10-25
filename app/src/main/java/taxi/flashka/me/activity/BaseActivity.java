package taxi.flashka.me.activity;

import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.inputmethod.InputMethodManager;

import taxi.flashka.me.R;
import taxi.flashka.me.repository.response.StatusResponse;
import taxi.flashka.me.view.model.ViewModel;

public abstract class BaseActivity<VM extends ViewModel, B extends ViewDataBinding>
        extends AppCompatActivity implements Observer<StatusResponse> {

    private InputMethodManager inputMethodManager;

    protected VM viewModel;

    protected B dataBinding;

    public abstract VM onCreateViewModel();

    public abstract @LayoutRes int getLayoutId();

    public abstract @IdRes int getVariable();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);

        dataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        dataBinding.setLifecycleOwner(this);
        viewModel = onCreateViewModel();
        viewModel.onCreate();
        dataBinding.setVariable(getVariable(), viewModel);
        dataBinding.executePendingBindings();

        findViewById(android.R.id.content).setBackgroundResource(R.drawable.bg);

        viewModel.getStatusLiveEvent().observe(this, this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.onResume();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        viewModel.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewModel.onDestroy();
    }

    protected void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    protected void setupToolbar(int titleResId) {
        setTitle(titleResId);
        setupToolbar();
    }

    @Override
    public void onChanged(@Nullable StatusResponse statusResponse) {
        inputMethodManager.hideSoftInputFromWindow(dataBinding.getRoot().getWindowToken(), 0);
        if (statusResponse != null && statusResponse.getStatus() != 200)
            showErrorSnackbar(statusResponse.getMessage());
    }

    protected void showErrorSnackbar(String message) {
        Snackbar snackbar = Snackbar.make(dataBinding.getRoot(), message, Snackbar.LENGTH_LONG);
        snackbar.getView().setBackgroundColor(ContextCompat.getColor(this, R.color.snackbarErrorBackgroundColor));
        snackbar.show();
    }

    protected void showSuccessSnackbar(String message) {
        Snackbar snackbar = Snackbar.make(dataBinding.getRoot(), message, Snackbar.LENGTH_LONG);
        snackbar.getView().setBackgroundColor(ContextCompat.getColor(this, R.color.snackbarSuccessBackgroundColor));
        snackbar.show();
    }
}
