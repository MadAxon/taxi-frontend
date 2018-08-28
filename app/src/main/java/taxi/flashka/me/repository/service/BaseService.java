package taxi.flashka.me.repository.service;

import android.arch.lifecycle.LiveData;

import com.bluelinelabs.logansquare.ParameterizedType;

public abstract class BaseService<T> {

    protected abstract ParameterizedType<T> getParameterizedType();

    protected abstract LiveData<T> getData();

}
