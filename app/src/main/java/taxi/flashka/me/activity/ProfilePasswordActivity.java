package taxi.flashka.me.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.android.databinding.library.baseAdapters.BR;

import taxi.flashka.me.R;
import taxi.flashka.me.databinding.ActivityProfilePasswordBinding;
import taxi.flashka.me.repository.response.StatusResponse;
import taxi.flashka.me.view.model.ProfilePasswordViewModel;

public class ProfilePasswordActivity extends BaseActivity<ProfilePasswordViewModel, ActivityProfilePasswordBinding> {

    @Override
    public ProfilePasswordViewModel onCreateViewModel() {
        return ViewModelProviders.of(this).get(ProfilePasswordViewModel.class);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_profile_password;
    }

    @Override
    public int getVariable() {
        return BR.viewModel;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupToolbar();
    }

    @Override
    public void onChanged(@Nullable StatusResponse statusResponse) {
        super.onChanged(statusResponse);
        if (statusResponse != null && statusResponse.getStatus() == 200) showSuccessSnackbar(statusResponse.getMessage());
    }
}
