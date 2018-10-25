package taxi.flashka.me.repository.service;

import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.bluelinelabs.logansquare.LoganSquare;
import com.bluelinelabs.logansquare.ParameterizedType;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import taxi.flashka.me.repository.request.BaseRequest;
import taxi.flashka.me.repository.response.BaseResponse;
import taxi.flashka.me.repository.response.StatusResponse;
import taxi.flashka.me.view.SingleLiveEvent;

public abstract class OkhttpService<M> {

    private final OkHttpClient client = new OkHttpClient();

    private final BaseRequest baseRequest;

    private final String token;

    private Call call;

    protected abstract ParameterizedType<? extends BaseResponse> getParameterizedType();

    public OkhttpService(BaseRequest baseRequest) {
        this.token = "";
        this.baseRequest = baseRequest;

    }

    public OkhttpService(String token, BaseRequest baseRequest) {
        this.token = token;
        this.baseRequest = baseRequest;

    }

    public void cancel() {
        if (call.isExecuted()) call.cancel();
    }

    @SafeVarargs
    public final void sendRequest(final SingleLiveEvent<StatusResponse> statusResponse,
                                         final MutableLiveData<M> liveData,
                                         final MutableLiveData<Boolean>... loadings) {

        setLoadings(true, loadings);

        call = client.newCall(getRequest());
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                statusResponse.postValue(new StatusResponse(e.getLocalizedMessage(), 0));
                setLoadings(false, loadings);
            }

            @Override
            @SuppressWarnings("unchecked")
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.body() != null) {
                    BaseResponse<M> res = LoganSquare.parse(response.body().string(), getParameterizedType());
                    switch (res.getStatus()) {
                        case 200:
                            if (liveData != null) liveData.postValue(res.getResult());
                        default:
                            statusResponse.postValue(new StatusResponse(res.getMessage(), res.getStatus()));
                    }
                } else statusResponse.postValue(new StatusResponse(response.message(), 0));
                setLoadings(false, loadings);
            }
        });
    }

    @SafeVarargs
    private final void setLoadings(boolean isLoading, MutableLiveData<Boolean>... loadings) {
        if (loadings != null)
            for (MutableLiveData<Boolean> loading: loadings)
                loading.postValue(isLoading);
    }

    private Request getRequest() {
        if (baseRequest.getBody() != null) {
            RequestBody requestBody;
            try {
                requestBody = RequestBody
                        .create(MediaType.parse("application/json; charset=utf-8")
                                , LoganSquare.serialize(baseRequest.getBody()));
            } catch (IOException e) {
                requestBody = RequestBody
                        .create(MediaType.parse("application/json; charset=utf-8"), "");
            }
            return new Request.Builder()
                    .url(baseRequest.getFullUrl())
                    .addHeader("Authorization", "Bearer " + token)
                    .post(requestBody)
                    .build();
        } else {
            HttpUrl.Builder httpBuilder = HttpUrl.parse(baseRequest.getFullUrl())
                    .newBuilder();
            return new Request.Builder()
                    .url(httpBuilder.build())
                    .addHeader("Authorization", "Bearer " + token)
                    .build();
        }
    }
}
