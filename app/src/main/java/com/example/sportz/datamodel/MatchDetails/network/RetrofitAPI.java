package com.example.sportz.datamodel.MatchDetails.network;

import com.example.sportz.datamodel.MatchDetails.JsonModel;

import org.json.JSONObject;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;

public interface RetrofitAPI {

    // as we are making get request
    // so we are displaying GET as annotation.
    // and inside we are passing
    // last parameter for our url.
    @GET("nzin01312019187360.json")

    // as we are calling data from array
    // so we are calling it with json object
    // and naming that method as getCourse();
    Call<JsonModel> getCourse();
    @GET("nzin01312019187360.json")
    Call<JsonModel> callmatchdetails();
    @GET("sapk01222019186652.json")
    Call<JsonModel> callmatchdetails1();


}

