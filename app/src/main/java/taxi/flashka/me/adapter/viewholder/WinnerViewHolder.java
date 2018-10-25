package taxi.flashka.me.adapter.viewholder;

import taxi.flashka.me.BR;
import taxi.flashka.me.databinding.ItemWinnerBinding;
import taxi.flashka.me.repository.model.WinnerModel;
import taxi.flashka.me.view.model.WinnerItemViewModel;

public class WinnerViewHolder extends BaseViewHolder<WinnerItemViewModel, WinnerModel> {

    public WinnerViewHolder(ItemWinnerBinding viewDataBinding) {
        super(viewDataBinding);
        viewDataBinding.setViewHolder(this);
    }

    @Override
    public int getVariable() {
        return BR.viewModel;
    }

    @Override
    public WinnerItemViewModel onCreateViewModel() {
        return new WinnerItemViewModel();
    }
}
