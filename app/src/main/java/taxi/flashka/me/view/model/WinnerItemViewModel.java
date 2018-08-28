package taxi.flashka.me.view.model;

import android.databinding.ObservableField;

import taxi.flashka.me.repository.model.WinnerModel;

public class WinnerItemViewModel extends ItemViewModel<WinnerModel> {

    public ObservableField<WinnerModel> winnerModel = new ObservableField<>();

    @Override
    public void setItem(WinnerModel item) {
        winnerModel.set(item);
    }
}
