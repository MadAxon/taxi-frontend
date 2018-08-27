package taxi.flashka.me.view.model;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.util.Log;

import taxi.flashka.me.model.DealOfferModel;
import taxi.flashka.me.view.SingleLiveEvent;

public class DealViewModel extends ViewModel {

    public ObservableArrayList<DealOfferModel> offers
            = new ObservableArrayList<>();

    public ObservableBoolean isLoading = new ObservableBoolean(true);

    private SingleLiveEvent<Void> applyEvent = new SingleLiveEvent<>();

    public void onClickedApply() {
        isLoading.set(!isLoading.get());
        applyEvent.call();
        Log.i("my_logs", "click");
        offers.add(new DealOfferModel("23.07.2018 13:00", 1));
        offers.add(new DealOfferModel("24.07.2018 13:30", 2));
    }

    public SingleLiveEvent<Void> getApplyEvent() {
        return applyEvent;
    }
}
