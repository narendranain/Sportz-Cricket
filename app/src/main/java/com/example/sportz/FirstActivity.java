package com.example.sportz;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sportz.Utiles.Util;
import com.example.sportz.adapter.MatchListAdapter;
import com.example.sportz.datamodel.MatchDetails.JsonModel;
import com.example.sportz.datamodel.MatchDetails.Matchdetail;
import com.example.sportz.datamodel.MatchDetails.Teams.Team;
import com.example.sportz.datamodel.MatchDetails.network.Response;
import com.example.sportz.datamodel.MatchDetails.network.RetrofitAPI;
import com.example.sportz.livedata.ApiResponseLiveData;
import com.example.sportz.livedata.RecyclerViewUpdateLiveData;
import com.example.sportz.viewmodel.MatchViewModel;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FirstActivity extends AppCompatActivity implements MatchListAdapter.ItemClickListener {
       RecyclerView rv_match_list;
       private MatchViewModel matchViewModel;
       private MatchListAdapter matchListAdapter;
       JsonModel jsonModelResponse;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_home);
            matchViewModel = ViewModelProviders.of(this).get(MatchViewModel.class);
            rv_match_list = findViewById(R.id.rv_match_list);
            rv_match_list.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true));

            matchViewModel.callGroupListApiApi();
            matchViewModel.getMatchJsonResponseLivedata().observe(this, jsonModelApiResponseApiObserver);
        }
    private ApiResponseLiveData.ApiObserver<JsonModel>  jsonModelApiResponseApiObserver = new ApiResponseLiveData.ApiObserver<JsonModel>() {
        @Override
        public void showSuccessResponse(JsonModel response) {
            Util.dismissProgressDialog();
            if (response == null) {
                return;
            }
            matchViewModel.exploreData(response);
            jsonModelResponse=response;
            if(matchViewModel!=null)
            setMatchAdapter(response);
            else
            setNoDataAvailableContent();
        }

        private void setNoDataAvailableContent() {
        }

        @Override
        public void showFailureResponse(Response response) {
                Util.dismissProgressDialog();
                Util.showMessage(getApplicationContext(), response.errorBody);

        }

        @Override
        public void showConnectionError(String message) {
            Util.dismissProgressDialog();
            Util.showMessage(getApplicationContext(), message);

        }
    };

    private void setMatchAdapter(JsonModel jsonModel) {

        rv_match_list.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        matchListAdapter = new MatchListAdapter(getApplicationContext(), jsonModel, FirstActivity.this);
        rv_match_list.setAdapter(matchListAdapter);
        matchViewModel.getRecyclerViewUpdateLiveData().observe(FirstActivity.this, myClassRecyclerViewItemObserver);
        matchListAdapter.notifyDataSetChanged();
    }
    private RecyclerViewUpdateLiveData.RecyclerViewItemObserver<JsonModel> myClassRecyclerViewItemObserver = new RecyclerViewUpdateLiveData.RecyclerViewItemObserver<JsonModel>() {
        @Override
        public void allItemChanged() {
            matchListAdapter.notifyDataSetChanged();
        }



        @Override
        public void singleItemChanged(int position, JsonModel myClass) {

        }

        @Override
        public void itemInserted(int position, JsonModel myClass) {

        }

        @Override
        public void itemRemoved(int position) {

        }


        @Override
        public void allItemUpdate(List<JsonModel> items) {

        }
    };


    @Override
    public void TypeClick(int position) {
        Gson gson= new Gson();
        Team team1  = gson.fromJson(jsonModelResponse.getTeams().get(jsonModelResponse.getMatchdetail().getTeam_Home()).toString(), Team.class);
        Team team2  = gson.fromJson(jsonModelResponse.getTeams().get(jsonModelResponse.getMatchdetail().getTeam_Away()).toString(),Team.class);
        Intent second_activity=new Intent(FirstActivity.this,SecondActivity.class);
        second_activity.putExtra("Team1_Name",team1.getName_Full());
        second_activity.putExtra("Team2_Name",team2.getName_Full());
        second_activity.putExtra("Team1",jsonModelResponse.getMatchdetail().getTeam_Home());
        second_activity.putExtra("Team2",jsonModelResponse.getMatchdetail().getTeam_Away());
        startActivity(second_activity);

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
    }
}
