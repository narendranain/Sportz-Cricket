package com.example.sportz.datamodel.MatchDetails.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.example.sportz.datamodel.MatchDetails.JsonModel;
import com.example.sportz.livedata.ApiResponseLiveData;

import org.json.JSONObject;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkManager {
    private static final String BASE_URL ="https://demo.sportz.io/";


    public static final int CONNECTION_PROBLEM = -1;
    public static final String NO_INTERNET_CONNECTION = "No internet connection";
    private static final String SERVER_NOT_REACHABLE = "Server not reachable, please try again later.";
    private static NetworkManager mManager;
    private RetrofitAPI mApiInterface;

    private NetworkManager() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).
                addConverterFactory(new NullOnEmptyConverterFactory()).
                addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient).build();
        mApiInterface = retrofit.create(RetrofitAPI.class);
    }

    public static NetworkManager getInstance() {
        if (mManager == null) {
            mManager = new NetworkManager();
        }
        return mManager;
    }

    private Map<String, String> formHeader(String token) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        if (token != null)
            headers.put("Authorization", "Bearer " + token);
        return headers;
    }

    private Map<String, String> formMultiPartHeader(String token) {
        Map<String, String> headers = new HashMap<>();
        //headers.put("Content-Type", "multipart/form-data");
        if (token != null)
            headers.put("Authorization", "Bearer " + token);
        return headers;
    }

    public ApiResponseLiveData<JsonModel> callMatchdetails(final Context context) {
        final ApiResponseLiveData<JsonModel> responseLiveData = new ApiResponseLiveData<>();
        final Call<JsonModel> responseCall = mApiInterface.callmatchdetails();
        responseCall.enqueue(new Callback<JsonModel>() {
            @Override
            public void onResponse(Call<JsonModel> call, retrofit2.Response<JsonModel> response) {
                SuccessResponse(responseLiveData, response, context);
            }

            @Override
            public void onFailure(Call<JsonModel> call, Throwable t) {
                failureResponse(context, responseLiveData, t);
            }
        });
        return responseLiveData;
    }
    private <T> void SuccessResponse(ApiResponseLiveData<T> responseLiveData, retrofit2.Response<T> response, Context context) {

        Response<T> res = new Response<>();
        res.body = response.body();
        res.status = response.code();
        res.success = res.body != null;
        JSONObject obj = null;
        if (!res.success) {
            try {
                obj = new JSONObject(response.errorBody().string());
                res.errorBody = obj.getJSONObject("OutPutParameters").getString("ErrorMessage");
            } catch (Exception e) {
                res.errorBody = "";
                e.printStackTrace();
            }
            try {
                if (res.errorBody.equals("")) {
                    res.errorBody = obj.getString("msg");
                }
            } catch (Exception e) {
                e.printStackTrace();
                res.errorBody = "";
            }
            if (res.errorBody.equals(""))
                res.errorBody = "Something went wrong";

        }
        responseLiveData.postValue(res);
    }

    private <T> void failureResponse(Context context, ApiResponseLiveData<T> responseLiveData, Throwable t) {
        Response<T> res = new Response<>();
        res.body = null;
        res.success = false;
        if (!checkInternetConnectivity(context)) {
            res.errorBody = NO_INTERNET_CONNECTION;
            res.status = CONNECTION_PROBLEM;
        } else if (t instanceof SocketTimeoutException || t instanceof UnknownHostException || t instanceof ConnectException) {
            res.errorBody = SERVER_NOT_REACHABLE;
            res.status = CONNECTION_PROBLEM;
        } else {
            res.status = 0;
            res.errorBody = t.toString();
        }
        responseLiveData.postValue(res);
    }

    private boolean checkInternetConnectivity(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm != null) {
            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            return activeNetwork != null && activeNetwork.isConnected();
        }
        return false;
    }

}
