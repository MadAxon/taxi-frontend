package taxi.flashka.me.adapter;

import com.android.databinding.library.baseAdapters.BR;

import taxi.flashka.me.R;
import taxi.flashka.me.model.WinnerModel;
import taxi.flashka.me.view.model.WinnerItemViewModel;

public class WinnerAdapter extends BaseAdapter<WinnerItemViewModel, WinnerModel> {

    @Override
    public int getLayoutId() {
        return R.layout.item_winner;
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
