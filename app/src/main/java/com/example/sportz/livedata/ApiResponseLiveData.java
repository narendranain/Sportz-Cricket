package com.example.sportz.livedata;

import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

import com.example.sportz.datamodel.MatchDetails.network.Response;

public class ApiResponseLiveData<T>  extends AtcoLiveData<T>
{

    public void observe(LifecycleOwner owner, final ApiObserver<T> observer) {
        super.observe(owner, new Observer<Response<T>>() {
            @Override
            public void onChanged(@Nullable Response<T> response) {
                if (response == null) {
                    return;
                }
                if (response.success)
                {
                    observer.showSuccessResponse(response.body);
                }
                else

                {

                }
            }
        });
    }

    public interface ApiObserver<T> {
        void showSuccessResponse(T response);
        void showFailureResponse(Response response);
        void showConnectionError(String message);
    }
}
