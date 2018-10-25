package taxi.flashka.me.view.model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.content.Intent;
import android.support.annotation.NonNull;

import taxi.flashka.me.interfaces.IViewModel;
import taxi.flashka.me.repository.preference.SharedPrefs;
import taxi.flashka.me.repository.response.StatusResponse;
import taxi.flashka.me.repository.service.OkhttpService;
import taxi.flashka.me.view.SingleLiveEvent;

public abstract class ViewModel extends AndroidViewModel implements IViewModel {

    protected final String token;

    protected SingleLiveEvent<StatusResponse> statusLiveEvent = new SingleLiveEvent<>();

    protected OkhttpService okhttpService;

    public MutableLiveData<Boolean> isLoading = new MutableLiveData<>();

    public ViewModel(@NonNull Application application) {
        super(application);
        token = SharedPrefs.getInstance().getToken(application.getApplicationContext());
    }

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
        if (okhttpService != null) okhttpService.cancel();
    }

    public SingleLiveEvent<StatusResponse> getStatusLiveEvent() {
        return statusLiveEvent;
    }

}
