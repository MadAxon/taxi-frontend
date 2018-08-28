package taxi.flashka.me.view.model;

import android.databinding.ObservableField;

import taxi.flashka.me.repository.model.HistoryModel;

public class HistoryItemViewModel extends ItemViewModel<HistoryModel> {

    public ObservableField<HistoryModel> historyModel = new ObservableField<>();

    @Override
    public void setItem(HistoryModel item) {
        historyModel.set(item);
    }

}
