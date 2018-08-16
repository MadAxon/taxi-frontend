package taxi.flashka.me.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.IntDef;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import taxi.flashka.me.view.model.ViewModel;

public abstract class BaseActivity<VM extends ViewModel, B extends ViewDataBinding>
        extends AppCompatActivity {

    private VM viewModel;

    private B dataBinding;

    public abstract VM onCreateViewModel();

    public abstract @LayoutRes int getLayoutId();

    public abstract @IdRes int getVariable();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        viewModel = onCreateViewModel();
        viewModel.onCreate();
        dataBinding.setVariable(getVariable(), viewModel);
        dataBinding.executePendingBindings();
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
}