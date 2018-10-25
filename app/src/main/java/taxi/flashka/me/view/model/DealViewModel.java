package taxi.flashka.me.view.model;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.bluelinelabs.logansquare.ParameterizedType;

import java.util.List;

import taxi.flashka.me.interfaces.ITimerListener;
import taxi.flashka.me.repository.model.OfferModel;
import taxi.flashka.me.repository.model.UserModel;
import taxi.flashka.me.repository.preference.SharedPrefs;
import taxi.flashka.me.repository.request.BaseRequest;
import taxi.flashka.me.repository.request.OfferRequest;
import taxi.flashka.me.repository.request.PaymentRequest;
import taxi.flashka.me.repository.response.BaseResponse;
import taxi.flashka.me.repository.response.ItemResponse;
import taxi.flashka.me.repository.response.ItemsResponse;
import taxi.flashka.me.repository.service.OkhttpService;
import taxi.flashka.me.repository.service.TimerService;
import taxi.flashka.me.view.SingleLiveEvent;

public class DealViewModel extends ViewModel implements ITimerListener {

    public MutableLiveData<List<OfferModel>> offers = new MutableLiveData<>();

    public MutableLiveData<Boolean> isRefreshing = new MutableLiveData<>()
            , isUserLoading = new MutableLiveData<>()
            , isDealButtonAnimating = new MutableLiveData<>();

    public MutableLiveData<UserModel> userModel = new MutableLiveData<>();

    public MutableLiveData<String> timer = new MutableLiveData<>();

    private final SingleLiveEvent<Void> applyEvent = new SingleLiveEvent<>();

    private OkhttpService<List<OfferModel>> okhttpServiceOffer;

    private OkhttpService okhttpServicePayment;

    private TimerService timerService;

    public DealViewModel(@NonNull Application application) {
        super(application);
        isRefreshing.setValue(false);
        isLoading.setValue(true);
        requestUser();
    }

    public void requestUser() {
        okhttpService = new OkhttpService<UserModel>(token
                , new BaseRequest("user/get")) {
            @Override
            protected ParameterizedType<ItemResponse<UserModel>> getParameterizedType() {
                return new ParameterizedType<ItemResponse<UserModel>>() {};
            }
        };
        okhttpService.sendRequest(statusLiveEvent, userModel, isUserLoading);
    }

    public void requestOffers(long cityId) {
        okhttpServiceOffer = new OkhttpService<List<OfferModel>>(token
                , new BaseRequest<>("offer/get_list", new OfferRequest(cityId))) {
            @Override
            protected ParameterizedType<ItemsResponse<OfferModel>> getParameterizedType() {
                return new ParameterizedType<ItemsResponse<OfferModel>>() {};
            }
        };
        if (isRefreshing.getValue())
            okhttpServiceOffer.sendRequest(statusLiveEvent, offers, isLoading, isRefreshing);
        else okhttpServiceOffer.sendRequest(statusLiveEvent, offers, isLoading);
    }

    public void toNullToken() {
        SharedPrefs.getInstance().setToken(getApplication().getApplicationContext(), null);
    }

    public void onClickedApply() {
        if (offers.getValue() != null && offers.getValue().size() > 0) {
            if (offers.getValue().get(0).getPayment() == 0) requestPayment(offers.getValue().get(0).getId());
            else applyEvent.call();
        }
    }

    public void onRefresh() {
        isRefreshing.setValue(true);
        requestUser();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (okhttpServiceOffer != null) okhttpServiceOffer.cancel();
        if (okhttpServicePayment != null) okhttpServicePayment.cancel();
        if (timerService != null) timerService.removeCallbacks();
    }

    public SingleLiveEvent<Void> getApplyEvent() {
        return applyEvent;
    }


    public void runTimer() {
        if (offers.getValue() != null && offers.getValue().size() > 0) {
            if (timerService != null) timerService.removeCallbacks();
            timerService = new TimerService(this, offers.getValue().get(0).getEndDate().getTime());
            timerService.postDelayed();
        }
    }

    @Override
    public void updateTimer(String time) {
        timer.setValue(time);
    }

    @Override
    public void createNextTimer() {
        if (userModel.getValue() != null)
            requestOffers(userModel.getValue().getCity().getId());
    }

    private void requestPayment(long offerId) {
        okhttpServicePayment = new OkhttpService(token, new BaseRequest<>("payment/apply",
                new PaymentRequest(offerId, PaymentRequest.PaymentType.FREE))) {
            @Override
            protected ParameterizedType<BaseResponse<String>> getParameterizedType() {
                return new ParameterizedType<BaseResponse<String>>() {};
            }
        };
        okhttpServicePayment.sendRequest(statusLiveEvent, null, isDealButtonAnimating);
    }
}
