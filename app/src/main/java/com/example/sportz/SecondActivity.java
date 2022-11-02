package com.example.sportz;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.sportz.Utiles.Util;
import com.example.sportz.adapter.MatchListAdapter;
import com.example.sportz.adapter.ViewPagerAdapter;
import com.example.sportz.datamodel.MatchDetails.JsonModel;
import com.example.sportz.datamodel.MatchDetails.Teams.Players;
import com.example.sportz.datamodel.MatchDetails.network.Response;
import com.example.sportz.fragments.TeamDetailsFragment;
import com.example.sportz.livedata.ApiResponseLiveData;
import com.example.sportz.livedata.RecyclerViewUpdateLiveData;
import com.example.sportz.viewmodel.MatchViewModel;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    Toolbar toolbarlead;
    ViewPagerAdapter adapter;
    private ViewPagerAdapter mSectionsPageAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mSectionsPageAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        tabLayout=(TabLayout)findViewById(R.id.tabLayout);
        viewPager =(ViewPager)findViewById(R.id.viewPager);
        toolbarlead=(Toolbar)findViewById(R.id.toolbarlead);
        toolbarlead.setTitle("Team Details");
        toolbarlead.setTitleTextColor(Color.WHITE);
        toolbarlead.setOnClickListener(this);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        Bundle extras = getIntent().getExtras();
        if (extras == null)
            finish();

        String Team1 = getIntent().getExtras().getString("Team1");
        String Team2 = getIntent().getExtras().getString("Team2");
        String Team1_name = getIntent().getExtras().getString("Team1_Name");
        String Team2_Name = getIntent().getExtras().getString("Team2_Name");

        ArrayList<String> team_name=new ArrayList<>();

        ArrayList<String> team_no=new ArrayList<>();
        team_name.add(Team1_name);
        team_name.add(Team2_Name);
        team_no.add(Team1);
        team_no.add(Team2);

       for(int j=0; j<team_name.size(); j++){
            TeamDetailsFragment gb=new TeamDetailsFragment();
            Bundle b=new Bundle();
            b.putString("ucat",team_no.get(j));
            gb.setArguments(b);
            adapter.addFragment(gb,team_name.get(j));
            viewPager.setAdapter(adapter);
            tabLayout.setupWithViewPager(viewPager);
        }


    }


    public void showCustomDialog(Players players) {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // before
        dialog.setContentView(R.layout.dialog_info);
        dialog.setCancelable(true);
        TextView player_name=dialog.findViewById(R.id.player_name);
        TextView player_bating_style=dialog.findViewById(R.id.player_bating_style);
        TextView player_bowling_style=dialog.findViewById(R.id.player_bowling_style);
        TextView player_strike_rate=dialog.findViewById(R.id.player_strike_rate);
        TextView player_is_keeper=dialog.findViewById(R.id.player_total_runs);


        if(players.getName_Full()!=null){
            if(players.getIskeeper()!=null && players.getIskeeper().equalsIgnoreCase("true")){
                 player_name.setText(players.getName_Full()+" (WC)");}
            else if(players.getIscaptain()!=null && players.getIscaptain().equalsIgnoreCase("true")){
                player_name.setText(players.getName_Full()+" (C)");}
            else{
                player_name.setText(players.getName_Full());
            }
        }
        if(players.getBatting()!=null){
                if(players.getBatting().getStyle()!=null)
                    player_bating_style.setText("Bating Style : "+players.getBatting().getStyle());
                }
                if(players.getBowling()!=null){
                    if(players.getBowling().getStyle()!=null)
                        player_bowling_style.setText("Bowling Style : "+players.getBowling().getStyle());
                }
                if(players.getBatting()!=null){
                    if(players.getBatting().getStrikerate()!=null)
                        player_strike_rate.setText("Strikerate : "+players.getBatting().getStrikerate());
                }
                if(players.getBatting()!=null){
                    if(players.getBatting().getRuns()!=null){
                        player_is_keeper.setText("Runs : "+players.getBatting().getRuns());
                    }
                }

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;


        ((AppCompatButton) dialog.findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
        dialog.getWindow().setAttributes(lp);
    }


    @Override
    public void onClick(View v){
        if (v.getId() == R.id.toolbarlead) {
            onBackPressed();
        }

    }
    }







