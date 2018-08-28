package taxi.flashka.me.adapter;

import taxi.flashka.me.BR;
import taxi.flashka.me.R;
import taxi.flashka.me.repository.model.HistoryModel;
import taxi.flashka.me.view.model.HistoryItemViewModel;

public class HistoryAdapter extends BaseAdapter<HistoryItemViewModel, HistoryModel> {

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
