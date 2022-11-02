package com.example.sportz.livedata;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.sportz.datamodel.MatchDetails.network.Response;

public class AtcoLiveData<T> extends MutableLiveData<Response<T>> {

    @MainThread
    public void observe(@NonNull LifecycleOwner owner, final Observer<? super Response<T>> observer) {
        super.observe(owner, new Observer<Response<T>>() {
            @Override
            public void onChanged(@Nullable Response<T> response) {
                observer.onChanged(response);
            }
        });
    }

    @MainThread
    public void setValue(@Nullable Response<T> t) {
        super.setValue(t);
    }


    public void postValue(@NonNull Response<T> t) {
        super.postValue(t);
    }

}
