package com.example.sportz.viewmodel;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.example.sportz.FirstActivity;
import com.example.sportz.datamodel.MatchDetails.InningModel.Inning;
import com.example.sportz.datamodel.MatchDetails.JsonModel;
import com.example.sportz.datamodel.MatchDetails.Matchdetail;
import com.example.sportz.datamodel.MatchDetails.network.NetworkManager;
import com.example.sportz.datamodel.MatchDetails.network.RetrofitAPI;
import com.example.sportz.livedata.ApiResponseLiveData;
import com.example.sportz.livedata.ObjectLiveData;
import com.example.sportz.livedata.RecyclerViewUpdateLiveData;
import com.google.gson.JsonObject;

import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MatchViewModel extends AndroidViewModel {
    private Matchdetail matchdetails;

    private ApiResponseLiveData<JsonModel> jsonModelApiResponseLiveData;
    private RecyclerViewUpdateLiveData<JsonModel> recyclerViewUpdateLiveData;

    private ArrayList<Inning> innings;
    private JsonObject team_details;
    private  JsonModel jsonModel;

    public MatchViewModel(@NonNull @NotNull Application application) {
        super(application);
        matchdetails=new Matchdetail();
        innings=new ArrayList<>();
        team_details=new JsonObject();
        recyclerViewUpdateLiveData = new RecyclerViewUpdateLiveData<>();
        jsonModel=new JsonModel();
    }


    public ApiResponseLiveData<JsonModel> getMatchJsonResponseLivedata() {
        return jsonModelApiResponseLiveData;
    }

    public RecyclerViewUpdateLiveData<JsonModel> getRecyclerViewUpdateLiveData() {
        return recyclerViewUpdateLiveData;
    }

    public void callGroupListApiApi() {

        NetworkManager manager = NetworkManager.getInstance();
        jsonModelApiResponseLiveData= manager.callMatchdetails(this.getApplication());
    }
    public void exploreData(JsonModel response) {
        matchdetails=new Matchdetail();
        innings=new ArrayList<>();
        team_details=new JsonObject();



        if (response.getMatchdetail() != null) {
            matchdetails=(response.getMatchdetail());
            recyclerViewUpdateLiveData.setValue();
        }
        if (response.getInnings() != null) {
            innings=response.getInnings();
            recyclerViewUpdateLiveData.setValue();
        }
        if (response.getTeams() != null) {
            team_details=response.getTeams();
            recyclerViewUpdateLiveData.setValue();
        }
        if(response!=null){
            jsonModel=response;
            recyclerViewUpdateLiveData.setValue();
        }


    }

    public Matchdetail getMatchdetails() {
        return matchdetails;
    }

    public ArrayList<Inning> getInnings() {
        return innings;
    }

    public JsonObject getTeam_details() {
        return team_details;
    }

    public JsonModel getJsonModel() {
        return jsonModel;
    }
}
