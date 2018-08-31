package taxi.flashka.me.view.model;

import android.arch.lifecycle.MutableLiveData;
import android.content.Intent;

import taxi.flashka.me.interfaces.IViewModel;
import taxi.flashka.me.repository.request.BaseRequest;
import taxi.flashka.me.repository.response.ErrorResponse;
import taxi.flashka.me.repository.service.OkhttpService;
import taxi.flashka.me.view.SingleLiveEvent;

public abstract class ViewModel extends android.arch.lifecycle.ViewModel implements IViewModel {

    private SingleLiveEvent<ErrorResponse> statusLiveEvent = new SingleLiveEvent<>();

    public MutableLiveData<Boolean> isLoading = new MutableLiveData<>();

    @Override
    public void onCreate() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    @Override
    public void onDestroy() {

    }

    public SingleLiveEvent<ErrorResponse> getStatusLiveEvent() {
        return statusLiveEvent;
    }

    public void setStatusLiveEvent(SingleLiveEvent<ErrorResponse> statusLiveEvent) {
        this.statusLiveEvent = statusLiveEvent;
    }
}
