package taxi.flashka.me.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;

import java.util.List;

import taxi.flashka.me.BR;
import taxi.flashka.me.R;
import taxi.flashka.me.adapter.WinnerAdapter;
import taxi.flashka.me.databinding.ActivityWinnerBinding;
import taxi.flashka.me.model.WinnerModel;
import taxi.flashka.me.view.ItemDecoration;
import taxi.flashka.me.view.model.WinnerViewModel;

public class WinnerActivity extends BaseActivity<WinnerViewModel, ActivityWinnerBinding> {

    private WinnerAdapter adapter;

    @Override
    public WinnerViewModel onCreateViewModel() {
        return ViewModelProviders.of(this).get(WinnerViewModel.class);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_winner;
    }

    @Override
    public int getVariable() {
        return BR.viewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupToolbar();

        adapter = new WinnerAdapter();
        dataBinding.recyclerView.setAdapter(adapter);
        dataBinding.recyclerView.addItemDecoration(new ItemDecoration(this));

        viewModel.getItems().observe(this, new Observer<List<WinnerModel>>() {
            @Override
            public void onChanged(@Nullable List<WinnerModel> items) {
                adapter.updateAdapter(items);
            }
        });
    }
}
