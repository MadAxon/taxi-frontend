package taxi.flashka.me.adapter;

import taxi.flashka.me.R;
import taxi.flashka.me.adapter.viewholder.HistoryViewHolder;
import taxi.flashka.me.databinding.ItemHistoryBinding;
import taxi.flashka.me.repository.model.HistoryModel;

public class HistoryAdapter extends BaseAdapter<HistoryModel, HistoryViewHolder, ItemHistoryBinding> {

    @Override
    public int getLayoutId() {
        return R.layout.item_history;
    }

    @Override
    public HistoryViewHolder onCreateViewHolderBinding(ItemHistoryBinding viewDataBinding) {
        HistoryViewHolder historyViewHolder = new HistoryViewHolder(viewDataBinding);
        return historyViewHolder;
    }

}
