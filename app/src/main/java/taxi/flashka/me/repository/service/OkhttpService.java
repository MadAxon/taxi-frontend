package taxi.flashka.me.repository.service;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.bluelinelabs.logansquare.LoganSquare;
import com.bluelinelabs.logansquare.ParameterizedType;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import taxi.flashka.me.repository.request.BaseRequest;

public abstract class OkhttpService<T> extends BaseService<T> {

    private OkHttpClient client = new OkHttpClient();

    private BaseRequest baseRequest;

    public OkhttpService(BaseRequest baseRequest) {
        this.baseRequest = baseRequest;
    }

    @Override
    public LiveData<T> getData() {
        final MutableLiveData<T> liveData = new MutableLiveData<>();

        client.newCall(getRequest()).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                liveData.setValue(LoganSquare.parse(response.body().string(), getParameterizedType()));
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
