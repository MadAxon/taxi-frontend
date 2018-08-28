package taxi.flashka.me.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;

import java.util.List;

import taxi.flashka.me.BR;
import taxi.flashka.me.R;
import taxi.flashka.me.adapter.HistoryAdapter;
import taxi.flashka.me.databinding.ActivityHistoryBinding;
import taxi.flashka.me.repository.model.HistoryModel;
import taxi.flashka.me.view.ItemDecoration;
import taxi.flashka.me.view.model.HistoryViewModel;

public class HistoryActivity extends BaseActivity<HistoryViewModel, ActivityHistoryBinding> {

    private HistoryAdapter adapter;

    @Override
    public HistoryViewModel onCreateViewModel() {
        return ViewModelProviders.of(this).get(HistoryViewModel.class);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_history;
    }

    @Override
    public int getVariable() {
        return BR.viewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupToolbar();

        adapter = new HistoryAdapter();
        dataBinding.recyclerView.setAdapter(adapter);
        dataBinding.recyclerView.addItemDecoration(new ItemDecoration(this));
        viewModel.getItems().observe(this, new Observer<List<HistoryModel>>() {
            @Override
            public void onChanged(@Nullable List<HistoryModel> items) {
                if (items != null) {
                    adapter.updateAdapter(items);
                }
            }
        });
    }
}
