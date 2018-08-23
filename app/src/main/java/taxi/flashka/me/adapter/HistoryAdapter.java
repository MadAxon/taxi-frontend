package taxi.flashka.me.adapter;

import java.util.ArrayList;

import taxi.flashka.me.BR;
import taxi.flashka.me.R;
import taxi.flashka.me.model.HistoryModel;
import taxi.flashka.me.view.model.HistoryItemViewModel;

public class HistoryAdapter extends BaseAdapter<HistoryItemViewModel, HistoryModel> {

    public HistoryAdapter(ArrayList<HistoryModel> models) {
        super(models);
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_history;
    }

    @Override
    public int getVariable() {
        return BR.viewModel;
    }

    @Override
    public HistoryItemViewModel onCreateViewModel() {
        return new HistoryItemViewModel();
    }

}
