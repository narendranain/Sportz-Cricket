package com.example.sportz.fragments;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sportz.R;
import com.example.sportz.SecondActivity;
import com.example.sportz.Utiles.Util;
import com.example.sportz.adapter.RankingViewAdapter;
import com.example.sportz.datamodel.MatchDetails.JsonModel;
import com.example.sportz.datamodel.MatchDetails.Teams.Players;
import com.example.sportz.datamodel.MatchDetails.Teams.Team;
import com.example.sportz.datamodel.MatchDetails.network.Response;
import com.example.sportz.livedata.ApiResponseLiveData;
import com.example.sportz.viewmodel.MatchViewModel;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import de.hdodenhof.circleimageview.CircleImageView;

public class TeamDetailsFragment extends Fragment implements  View.OnClickListener{

    TextView name, name1, name2, score, score1, score2;
    RecyclerView recyclerView;
    String temp;
    MatchViewModel matchViewModel;
    JsonModel jsonModelResponse;
    Players players;
    Team team1;
    Team team2;
    HashMap<Integer,String> players_id_sorted;
    Gson gson= new Gson();
    CircleImageView image, image1, image2;
    RelativeLayout relative_rank1, relative_rank2, relative_rank3;

    public TeamDetailsFragment() {
    }


    public static TeamDetailsFragment newInstance(String param1, String param2) {
        TeamDetailsFragment fragment = new TeamDetailsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            temp = bundle.getString("ucat","global" );
        }

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_team_details, container, false);
        relative_rank1 = (RelativeLayout) v.findViewById(R.id.relative_rank1);
        relative_rank2 = (RelativeLayout) v.findViewById(R.id.relative_rank2);
        relative_rank3 = (RelativeLayout) v.findViewById(R.id.relative_rank3);
        image = (CircleImageView) v.findViewById(R.id.image_view);
        image1 = (CircleImageView) v.findViewById(R.id.image_view1);
        image2 = (CircleImageView) v.findViewById(R.id.image_view2);
        name = (TextView) v.findViewById(R.id.name);
        name1 = (TextView) v.findViewById(R.id.name1);
        name2 = (TextView) v.findViewById(R.id.name2);
        score = (TextView) v.findViewById(R.id.score);
        score1 = (TextView) v.findViewById(R.id.score1);
        score2 = (TextView) v.findViewById(R.id.score2);
        recyclerView = v.findViewById(R.id.ranking);
        relative_rank1.setOnClickListener(this);
        relative_rank2.setOnClickListener(this);
        relative_rank3.setOnClickListener(this);

        matchViewModel = ViewModelProviders.of(this).get(MatchViewModel.class);
        matchViewModel.callGroupListApiApi();
        matchViewModel.getMatchJsonResponseLivedata().observe(this, jsonModelApiResponseApiObserver);

        return v;
    }
    public void FirstThree()
    {
        team1=new Team();
        team2=new Team();
        players_id_sorted=new HashMap<>();
        if(temp.equalsIgnoreCase(jsonModelResponse.getMatchdetail().getTeam_Home())) {
            team1 = gson.fromJson(jsonModelResponse.getTeams().get(jsonModelResponse.getMatchdetail().getTeam_Home()).toString(), Team.class);
        }
        else {
            team1 = gson.fromJson(jsonModelResponse.getTeams().get(jsonModelResponse.getMatchdetail().getTeam_Away()).toString(), Team.class);
        }
        players=new Players();
        Iterator<String> keys=team1.getPlayers().keySet().iterator();
        ArrayList<String> players_id=new ArrayList<>();
        while(keys.hasNext())
        {
            String key=keys.next();
            try {
                players_id.add(key);
                Players temp_players =gson.fromJson(team1.getPlayers().get(key).toString(),Players.class);
                players_id_sorted.put(Integer.valueOf(temp_players.getPosition()),key);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            String s = temp + "templead";
            int n = players_id_sorted.size();
            if (n >= 3) {
                for (int i = 1; i < 4; i++) {
                    players =gson.fromJson(team1.getPlayers().get(players_id_sorted.get(i)).toString(),Players.class);

                    if (i == 1) {
                        if(players.getIskeeper()!=null && players.getIskeeper().equalsIgnoreCase("true")){
                            name.setText(players.getName_Full()+" (WC)");}
                        else if(players.getIscaptain()!=null && players.getIscaptain().equalsIgnoreCase("true")){
                            name.setText(players.getName_Full()+" (C)");}
                        else{
                            name.setText(players.getName_Full());
                        }
                            score.setText(players.getBatting().getRuns());
                    }
                    if (i == 2) {
                        if(players.getIskeeper()!=null && players.getIskeeper().equalsIgnoreCase("true")){
                            name1.setText(players.getName_Full()+" (WC)");}
                        else if(players.getIscaptain()!=null && players.getIscaptain().equalsIgnoreCase("true")){
                            name1.setText(players.getName_Full()+" (C)");}
                        else{
                            name1.setText(players.getName_Full());
                        }
                            score1.setText(players.getBatting().getRuns());
                    }
                    if (i == 3) {
                        if(players.getIskeeper()!=null && players.getIskeeper().equalsIgnoreCase("true")){
                            name2.setText(players.getName_Full()+" (WC)");}
                        else if(players.getIscaptain()!=null && players.getIscaptain().equalsIgnoreCase("true")){
                            name2.setText(players.getName_Full()+" (C)");}
                        else{
                            name2.setText(players.getName_Full());
                        }
                            score2.setText(players.getBatting().getRuns());
                    }

                }

            }
            else {
                relative_rank1.setVisibility(View.GONE);
                relative_rank2.setVisibility(View.GONE);
                relative_rank3.setVisibility(View.GONE);
            }
        }catch (Exception E){

        }

    }



    @Override
    public void onClick(View v) {
        try {
            if (v.getId()==R.id.relative_rank1) {
                if (getActivity() instanceof SecondActivity) {
                    players =gson.fromJson(team1.getPlayers().get(players_id_sorted.get(1)).toString(),Players.class);

                    ((SecondActivity)getActivity()).showCustomDialog(players);
                }
            }
            if (v.getId()==R.id.relative_rank2) {
                if (getActivity() instanceof SecondActivity) {
                    players =gson.fromJson(team1.getPlayers().get(players_id_sorted.get(2)).toString(),Players.class);

                    ((SecondActivity)getActivity()).showCustomDialog(players);
                }
            }
            if (v.getId()==R.id.relative_rank3) {
                if (getActivity() instanceof SecondActivity) {
                    players =gson.fromJson(team1.getPlayers().get(players_id_sorted.get(3)).toString(),Players.class);

                    ((SecondActivity)getActivity()).showCustomDialog(players);
                }
            }

        }catch (Exception e){

        }
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
            FirstThree();
            RankingViewAdapter cadapter = new RankingViewAdapter(jsonModelResponse, getContext(),temp);
            recyclerView.setAdapter(cadapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        }

        @Override
        public void showFailureResponse(Response response) {
            Util.dismissProgressDialog();
            Util.showMessage(getActivity(), response.errorBody);

        }

        @Override
        public void showConnectionError(String message) {
            Util.dismissProgressDialog();
            Util.showMessage(getActivity(), message);

        }
    };
}

