package taxi.flashka.me.view.model;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.bluelinelabs.logansquare.ParameterizedType;

import taxi.flashka.me.repository.request.BaseRequest;
import taxi.flashka.me.repository.request.PaymentRequest;
import taxi.flashka.me.repository.response.BaseResponse;
import taxi.flashka.me.repository.response.ItemResponse;
import taxi.flashka.me.repository.service.OkhttpService;
import taxi.flashka.me.view.SingleLiveEvent;

public class PaymentViewModel extends ViewModel {

    private MutableLiveData<String> url = new MutableLiveData<>();

    private long offerId;

    public PaymentViewModel(@NonNull Application application) {
        super(application);
    }

    public void setOfferId(long offerId) {
        this.offerId = offerId;
    }

    public void onClickedCard() {
        requestPayment(PaymentRequest.PaymentType.VISA);
    }

    public void onClickedWallet() {
        requestPayment(PaymentRequest.PaymentType.BALANCE);
    }

    public MutableLiveData<String> getUrl() {
        return url;
    }

    private void requestPayment(PaymentRequest.PaymentType paymentType) {
        okhttpService = new OkhttpService(token, new BaseRequest<>("payment/apply",
                new PaymentRequest(offerId, paymentType))) {
            @Override
            protected ParameterizedType<ItemResponse<String>> getParameterizedType() {
                return new ParameterizedType<ItemResponse<String>>() {};
            }
        };
        okhttpService.sendRequest(statusLiveEvent, url, isLoading);
    }
}
