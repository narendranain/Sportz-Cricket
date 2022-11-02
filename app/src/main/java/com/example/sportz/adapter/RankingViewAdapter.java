package com.example.sportz.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;
import com.example.sportz.R;
import com.example.sportz.SecondActivity;
import com.example.sportz.datamodel.MatchDetails.JsonModel;
import com.example.sportz.datamodel.MatchDetails.Teams.Players;
import com.example.sportz.datamodel.MatchDetails.Teams.Team;
import com.example.sportz.fragments.TeamDetailsFragment;
import com.google.gson.Gson;


import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import de.hdodenhof.circleimageview.CircleImageView;

public class RankingViewAdapter extends RecyclerView.Adapter<RankingViewAdapter.ViewHolder> {

    private static final String TAG = "Testing" ;
    private ArrayList<String> rankimage = new ArrayList<>();
    private ArrayList<String> rank = new ArrayList<>();
    private ArrayList<String> rankname = new ArrayList<>();
    private ArrayList<String> rankscore = new ArrayList<>();
    private Context mContext;
    String temp;
    private JsonModel jsonModels;
    Players players;
    Team team1;
    Team team2;
    ArrayList<String> players_id;
    HashMap<Integer,String> players_id_sorted;
    Dialog dialog;
    Gson gson= new Gson();





    public RankingViewAdapter(JsonModel jsonModels, Context mContext,String temp) {
        this.jsonModels = jsonModels;
        this.mContext = mContext;
        this.temp=temp;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if(viewType%2==0){
            View view = View.inflate(parent.getContext(), R.layout.activity_left_player, null);
            ViewHolder cholder = new ViewHolder(view,viewType);
            return cholder;}
        else{
            View view = View.inflate(parent.getContext(), R.layout.activity_right_player, null);
            ViewHolder cholder = new ViewHolder(view,viewType);
            return cholder;
        }

    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called.");


      team1=new Team();
      team2=new Team();
      players_id=new ArrayList<>();
      players_id_sorted =new HashMap<>();

        if (temp.equalsIgnoreCase(jsonModels.getMatchdetail().getTeam_Home())) {
            team1 = gson.fromJson(jsonModels.getTeams().get(jsonModels.getMatchdetail().getTeam_Home()).toString(), Team.class);
        }
        else {
            team1 = gson.fromJson(jsonModels.getTeams().get(jsonModels.getMatchdetail().getTeam_Away()).toString(), Team.class);
        }
        players=new Players();
        if (position<team1.getPlayers().size()-3) {
            Iterator<String> keys=team1.getPlayers().keySet().iterator();
            while(keys.hasNext())
            {
                String key=keys.next();
                try {
                    players_id.add(key);
                    Players temp_players =gson.fromJson(team1.getPlayers().get(key).toString(),Players.class);
                    players_id_sorted.put(Integer.valueOf(temp_players.getPosition()),key);

                    //  players =gson.fromJson(team1.getPlayers().get(key).toString(),Players.class);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (position<players_id_sorted.size()-3) {
                players =gson.fromJson(team1.getPlayers().get(players_id_sorted.get(3+position)).toString(),Players.class);

                if (position % 2 == 0) {
                    holder.hash1.setText("# "+String.valueOf((4+ position)));
                    if(players.getIskeeper()!=null && players.getIskeeper().equalsIgnoreCase("true")){
                        holder.name3.setText(players.getName_Full()+" (WC)");}
                    else if(players.getIscaptain()!=null && players.getIscaptain().equalsIgnoreCase("true")){
                        holder.name3.setText(players.getName_Full()+" (C)");}
                    else{
                        holder.name3.setText(players.getName_Full());

                     }
                    holder.score3.setText(String.valueOf(players.getBatting().getRuns()));

                } else {
                      holder.hash2.setText(String.valueOf("# " + (4 + position)));
                    if(players.getIskeeper()!=null && players.getIskeeper().equalsIgnoreCase("true")){
                        holder.rname3.setText(players.getName_Full()+" (WC)");}
                    else if(players.getIscaptain()!=null && players.getIscaptain().equalsIgnoreCase("true")){
                        holder.rname3.setText(players.getName_Full()+" (C)");}
                    else{
                        holder.rname3.setText(players.getName_Full());

                }
                    holder.rscore3.setText(String.valueOf(players.getBatting().getRuns()));



                }
            }
        }

    }
    @Override
    public int getItemCount() {

        if(jsonModels.getTeams().size()>0)
            return 11-3;
        else
            return 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        TextView name3,score3,rname3,rscore3,hash1,hash2;
        CircleImageView rimage_view3,image_view3;
        RankingViewAdapter.OnCardClickListner onCardClickListner;

        public ViewHolder(View itemView,int viewType) {
            super(itemView);

            if(viewType%2==0){
                image_view3 = itemView.findViewById(R.id.image_view3);
                score3 = itemView.findViewById(R.id.score3);
                hash1 = itemView.findViewById(R.id.hash1);
                name3 = itemView.findViewById(R.id.name3);
                image_view3.setOnClickListener(this);
            }
            else{
                rimage_view3 = itemView.findViewById(R.id.rimage_view3);
                rscore3=itemView.findViewById(R.id.rscore3);
                hash2=itemView.findViewById(R.id.hash2);
                rname3=itemView.findViewById(R.id.rname3);
                rimage_view3.setOnClickListener(this);
            }

        }


        @Override
        public void onClick(View v) {
            System.out.println("Item clicked pos " + getAdapterPosition());
            int position = getAdapterPosition();
            int newpos=position+3;
            if (mContext instanceof SecondActivity) {
                players =gson.fromJson(team1.getPlayers().get(players_id_sorted.get(newpos)).toString(),Players.class);
                ((SecondActivity)mContext).showCustomDialog(players);
            }
        }

        @Override
        public boolean onLongClick(View v) {
            int position = getAdapterPosition();
            onCardClickListner.OnItemLongClicked(v, jsonModels, position);
            return true;
        }
    }
    public interface OnCardClickListner {
        void OnItemLongClicked(View view, JsonModel user, int position);
        void OnItemClick(View view, JsonModel user, int position);
    }
}



