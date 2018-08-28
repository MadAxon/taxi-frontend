package taxi.flashka.me.view.model;

import android.arch.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import taxi.flashka.me.repository.model.WinnerModel;

public class WinnerViewModel extends ViewModel {

    private final MutableLiveData<List<WinnerModel>> items;

    public WinnerViewModel() {
        items = new MutableLiveData<>();
        List<WinnerModel> list = new ArrayList<>();
        list.add(new WinnerModel("x337eo 116 RUS", 10, "1000 P"));
        list.add(new WinnerModel("y436ko 116 RUS", 9, "1000 P"));
        items.setValue(list);
    }

    public MutableLiveData<List<WinnerModel>> getItems() {
        return items;
    }
}
