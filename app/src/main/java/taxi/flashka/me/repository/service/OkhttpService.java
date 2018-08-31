package taxi.flashka.me.repository.service;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.bluelinelabs.logansquare.LoganSquare;
import com.bluelinelabs.logansquare.ParameterizedType;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import taxi.flashka.me.repository.request.BaseRequest;
import taxi.flashka.me.repository.response.BaseResponse;
import taxi.flashka.me.repository.response.ErrorResponse;
import taxi.flashka.me.view.SingleLiveEvent;

public abstract class OkhttpService<R extends BaseResponse<M>, M> {

    private OkHttpClient client = new OkHttpClient();

    private BaseRequest baseRequest;

    protected abstract ParameterizedType<R> getParameterizedType();

    public OkhttpService(BaseRequest baseRequest) {
        this.baseRequest = baseRequest;
    }

    public LiveData<M> getData(final SingleLiveEvent<ErrorResponse> statusLiveEvent
            , final MutableLiveData<Boolean> isRunning) {
        final MutableLiveData<M> liveData = new MutableLiveData<>();

        isRunning.setValue(true);
        client.newCall(getRequest()).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                statusLiveEvent.setValue(new ErrorResponse(e.getLocalizedMessage(), 0));
                isRunning.setValue(false);
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.body() != null) {
                    R res = LoganSquare.parse(response.body().string(), getParameterizedType());
                    switch (res.getStatus()) {
                        case 200:
                            liveData.setValue(res.getData());
                            break;
                        default:
                            statusLiveEvent.setValue(new ErrorResponse(res.getStatusText(), res.getStatus()));
                    }
                } else statusLiveEvent.setValue(new ErrorResponse(response.message(), 0));
                isRunning.setValue(false);
            }
        });
        return liveData;
    }

    private Request getRequest() {
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
                .post(requestBody)
                .build();
    }
}
