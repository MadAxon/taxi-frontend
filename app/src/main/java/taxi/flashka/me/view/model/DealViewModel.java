package taxi.flashka.me.view.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.util.Log;

import com.bluelinelabs.logansquare.ParameterizedType;

import java.util.ArrayList;
import java.util.List;

import taxi.flashka.me.repository.model.DealOfferModel;
import taxi.flashka.me.repository.request.BaseRequest;
import taxi.flashka.me.repository.response.ItemResponse;
import taxi.flashka.me.repository.response.ItemsResponse;
import taxi.flashka.me.repository.service.OkhttpService;
import taxi.flashka.me.view.SingleLiveEvent;

public class DealViewModel extends ViewModel {

    public ObservableArrayList<DealOfferModel> offers
            = new ObservableArrayList<>();

    public ObservableBoolean isRefreshing = new ObservableBoolean(false);

    public ObservableField<String> name = new ObservableField<>()
            , carNumber = new ObservableField<>()
            , city = new ObservableField<>();

    public LiveData<String> amount;

    private SingleLiveEvent<Void> applyEvent = new SingleLiveEvent<>();

    public DealViewModel() {
        isLoading.setValue(true);
        new OkhttpService<ItemResponse<String>, String>(new BaseRequest<>(""
                , "", "")) {
            @Override
            protected ParameterizedType<ItemResponse<String>> getParameterizedType() {
                return new ParameterizedType<ItemResponse<String>>() {};
            }
        };
    }

    public void onClickedApply() {
        name.set("Ruslan");
        carNumber.set("X 347 EO | 116 RUS");
        city.set("Kazan");
        amount = new MutableLiveData<>();
        isLoading.setValue(!isLoading.getValue());
        applyEvent.call();
        Log.i("my_logs", "click");
        ItemsResponse<List<DealOfferModel>> itemsResponse = new ItemsResponse<>();
        List<DealOfferModel> list = new ArrayList<>();
        list.add(new DealOfferModel("23.07.2018 13:00", 1));
        list.add(new DealOfferModel("24.07.2018 13:30", 2));
        itemsResponse.setItems(list);
        offers.addAll(itemsResponse.getItems());
        isRefreshing.set(false);
    }

    public void onRefresh() {
        isRefreshing.set(true);
    }

    public SingleLiveEvent<Void> getApplyEvent() {
        return applyEvent;
    }
}
