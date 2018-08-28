package taxi.flashka.me.view.model;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.util.Log;

import taxi.flashka.me.repository.model.DealOfferModel;
import taxi.flashka.me.view.SingleLiveEvent;

public class DealViewModel extends ViewModel {

    public ObservableArrayList<DealOfferModel> offers
            = new ObservableArrayList<>();

    public ObservableBoolean isLoading = new ObservableBoolean(true);

    public ObservableField<String> name = new ObservableField<>()
            , carNumber = new ObservableField<>()
            , city = new ObservableField<>()
            , amount = new ObservableField<>();

    private SingleLiveEvent<Void> applyEvent = new SingleLiveEvent<>();

    public void onClickedApply() {
        name.set("Ruslan");
        carNumber.set("X 347 EO | 116 RUS");
        city.set("Kazan");
        amount.set("256 P");
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
