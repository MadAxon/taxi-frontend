package taxi.flashka.me.adapter;

import taxi.flashka.me.R;
import taxi.flashka.me.adapter.viewholder.WinnerViewHolder;
import taxi.flashka.me.databinding.ItemWinnerBinding;
import taxi.flashka.me.repository.model.WinnerModel;

public class WinnerAdapter extends BaseAdapter<WinnerModel, WinnerViewHolder, ItemWinnerBinding> {


    @Override
    public int getLayoutId() {
        return R.layout.item_winner;
    }

    @Override
    public WinnerViewHolder onCreateViewHolderBinding(ItemWinnerBinding viewDataBinding) {
        WinnerViewHolder winnerViewHolder = new WinnerViewHolder(viewDataBinding);
        return winnerViewHolder;
    }
}
