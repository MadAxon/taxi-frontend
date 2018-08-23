package taxi.flashka.me.view.model;

import android.arch.lifecycle.ViewModel;
import android.databinding.Bindable;
import android.support.annotation.NonNull;

import taxi.flashka.me.model.HistoryModel;

public class HistoryItemViewModel extends ItemViewModel<HistoryModel> {

    private HistoryModel historyModel;

    @Override
    public void setItem(HistoryModel item) {
        historyModel = item;
    }

    @Bindable
    public int getId() {
        return historyModel.getId();
    }

    @Bindable
    public String getDate() {
        return historyModel.getDate();
    }

    @Bindable
    public String getAmount() {
        return historyModel.getAmount();
    }
}
