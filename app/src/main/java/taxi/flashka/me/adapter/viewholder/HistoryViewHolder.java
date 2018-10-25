package taxi.flashka.me.adapter.viewholder;

import taxi.flashka.me.BR;
import taxi.flashka.me.databinding.ItemHistoryBinding;
import taxi.flashka.me.repository.model.HistoryModel;
import taxi.flashka.me.view.model.HistoryItemViewModel;

public class HistoryViewHolder extends BaseViewHolder<HistoryItemViewModel, HistoryModel> {

    @Override
    public int getVariable() {
        return BR.viewModel;
    }

    @Override
    public HistoryItemViewModel onCreateViewModel() {
        return new HistoryItemViewModel();
    }

    public HistoryViewHolder(ItemHistoryBinding viewDataBinding) {
        super(viewDataBinding);
        viewDataBinding.setViewHolder(this);
    }
}
