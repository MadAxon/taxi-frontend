package taxi.flashka.me.view.model;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.bluelinelabs.logansquare.ParameterizedType;

import java.util.List;

import taxi.flashka.me.repository.model.CityModel;
import taxi.flashka.me.repository.request.BaseRequest;
import taxi.flashka.me.repository.response.ItemsResponse;
import taxi.flashka.me.repository.service.OkhttpService;

public class CityViewModel extends ViewModel {

    private MutableLiveData<List<CityModel>> items = new MutableLiveData<>();

    public CityViewModel(@NonNull Application application) {
        super(application);
        okhttpService = new OkhttpService<List<CityModel>>(token
                , new BaseRequest("city/get_list")) {
            @Override
            protected ParameterizedType<ItemsResponse<CityModel>> getParameterizedType() {
                return new ParameterizedType<ItemsResponse<CityModel>>() {};
            }
        };
        okhttpService.sendRequest(statusLiveEvent, items, isLoading);
    }

    public LiveData<List<CityModel>> getItems() {
        return items;
    }
}
