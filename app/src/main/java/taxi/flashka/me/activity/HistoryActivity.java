package taxi.flashka.me.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import taxi.flashka.me.BR;
import taxi.flashka.me.R;
import taxi.flashka.me.databinding.ActivityHistoryBinding;
import taxi.flashka.me.view.model.HistoryViewModel;

public class HistoryActivity extends BaseActivity<HistoryViewModel, ActivityHistoryBinding> {

    @Override
    public HistoryViewModel onCreateViewModel() {
        return new HistoryViewModel();
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
        setContentView(R.layout.activity_history);
        setupToolbar();

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this
                , DividerItemDecoration.VERTICAL));
    }
}
