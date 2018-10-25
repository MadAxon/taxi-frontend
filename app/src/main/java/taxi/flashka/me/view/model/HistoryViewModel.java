package taxi.flashka.me.view.model;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.bluelinelabs.logansquare.ParameterizedType;

import java.util.List;

import taxi.flashka.me.repository.model.HistoryModel;
import taxi.flashka.me.repository.request.BaseRequest;
import taxi.flashka.me.repository.response.ItemsResponse;
import taxi.flashka.me.repository.service.OkhttpService;

public class HistoryViewModel extends ViewModel {

    private MutableLiveData<List<HistoryModel>> items = new MutableLiveData<>();

    public MutableLiveData<Boolean> isRefreshing = new MutableLiveData<>();

    public HistoryViewModel(@NonNull Application application) {
        super(application);
        isRefreshing.setValue(false);
        getData();
    }

    private void getData() {
        okhttpService = new OkhttpService<List<HistoryModel>>(token
                , new BaseRequest("history/get_list")) {
            @Override
            protected ParameterizedType<ItemsResponse<HistoryModel>> getParameterizedType() {
                return new ParameterizedType<ItemsResponse<HistoryModel>>() {};
            }
        };
        if (isRefreshing.getValue()) okhttpService.sendRequest(statusLiveEvent, items, isLoading, isRefreshing);
        else okhttpService.sendRequest(statusLiveEvent, items, isLoading);
    }

    public void onRefresh() {
        isRefreshing.setValue(true);
        if (items.getValue() != null) items.getValue().clear();
        getData();
    }

    public MutableLiveData<List<HistoryModel>> getItems() {
        return items;
    }
}
