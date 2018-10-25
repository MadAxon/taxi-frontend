package taxi.flashka.me.view.model;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.bluelinelabs.logansquare.ParameterizedType;

import java.util.List;

import taxi.flashka.me.repository.model.WinnerModel;
import taxi.flashka.me.repository.request.BaseRequest;
import taxi.flashka.me.repository.response.ItemsResponse;
import taxi.flashka.me.repository.service.OkhttpService;

public class WinnerViewModel extends ViewModel {

    private MutableLiveData<List<WinnerModel>> items = new MutableLiveData<>();

    public MutableLiveData<Boolean> isRefreshing = new MutableLiveData<>();

    public WinnerViewModel(@NonNull Application application) {
        super(application);
        isRefreshing.setValue(false);
        getData();
    }

    private void getData() {
        okhttpService = new OkhttpService<List<WinnerModel>>(token
                , new BaseRequest( "participant/winner/get_list")) {
            @Override
            protected ParameterizedType<ItemsResponse<WinnerModel>> getParameterizedType() {
                return new ParameterizedType<ItemsResponse<WinnerModel>>() {};
            }
        };
        if (isRefreshing.getValue()) okhttpService.sendRequest(statusLiveEvent, items, isLoading, isRefreshing);
        else okhttpService.sendRequest(statusLiveEvent, items, isLoading);
    }

    public LiveData<List<WinnerModel>> getItems() {
        return items;
    }

    public void onRefresh() {
        isRefreshing.setValue(true);
        if (items.getValue() != null) items.getValue().clear();
        getData();
    }
}
