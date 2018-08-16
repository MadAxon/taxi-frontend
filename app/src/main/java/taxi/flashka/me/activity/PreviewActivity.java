package taxi.flashka.me.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import taxi.flashka.me.BR;
import taxi.flashka.me.R;
import taxi.flashka.me.databinding.ActivityPreviewBinding;
import taxi.flashka.me.view.model.PreviewViewModel;

public class PreviewActivity extends BaseActivity<PreviewViewModel, ActivityPreviewBinding> {

    @Override
    public PreviewViewModel onCreateViewModel() {
        return new PreviewViewModel();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_preview;
    }

    @Override
    public int getVariable() {
        return BR.viewModel;
    }

}
