package taxi.flashka.me.view.model;

import android.arch.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import taxi.flashka.me.repository.model.HistoryModel;

public class HistoryViewModel extends ViewModel {

    private final MutableLiveData<List<HistoryModel>> items;

    public HistoryViewModel() {
        items = new MutableLiveData<>();
        List<HistoryModel> list = new ArrayList<>();
        list.add(new HistoryModel(12, "12.12.18", "100 P"));
        list.add(new HistoryModel(15, "12.12.18", "320 P"));
        list.add(new HistoryModel(19, "13.12.18", "50 P"));
        items.setValue(list);
    }

    public MutableLiveData<List<HistoryModel>> getItems() {
        return items;
    }
}
