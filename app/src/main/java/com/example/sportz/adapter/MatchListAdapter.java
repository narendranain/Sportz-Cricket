package com.example.sportz.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sportz.R;
import com.example.sportz.datamodel.MatchDetails.JsonModel;
import com.example.sportz.datamodel.MatchDetails.Matchdetail;
import com.example.sportz.datamodel.MatchDetails.Teams.Team;
import com.example.sportz.viewmodel.MatchViewModel;
import com.google.gson.Gson;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MatchListAdapter extends RecyclerView.Adapter<MatchListAdapter.HomeViewHolder> {


    public interface ItemClickListener {
        void TypeClick(int position);
    }
    private Drawable unwrappedDrawable,wrappedDrawable;
    private int checkedPosition = 0;
    private Context context;
    private JsonModel jsonModels;
    private ItemClickListener itemClickListener;

    public MatchListAdapter(Context context, JsonModel jsonModels, ItemClickListener itemClickListener) {
        this.context = context;
        this.jsonModels = jsonModels;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View theView = LayoutInflater.from(context).inflate(R.layout.activity_first, parent, false);
        return new HomeViewHolder(theView);
    }

    @Override
    public void onBindViewHolder(@NonNull final HomeViewHolder holder, final int position) {

        holder.bind(jsonModels);



    }

    @Override
    public int getItemCount() {
        return jsonModels.getTeams().size()-1;

    }

    public class HomeViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.team_a)
        TextView team_a;
        @BindView(R.id.team_b)
        TextView team_b;
        @BindView(R.id.match_time_date)
        TextView match_time_date;
        @BindView(R.id.match_venue)
        TextView match_venue;

        public HomeViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
        void bind(final JsonModel jsonModel) {
            if (jsonModel != null) {
                Team team1 =new Team();
                Team team2 =new Team();
                Matchdetail  matchdetail=new Matchdetail();
                matchdetail=jsonModel.getMatchdetail();
                Gson gson= new Gson();
                team1  = gson.fromJson(jsonModel.getTeams().get(jsonModel.getMatchdetail().getTeam_Home()).toString(),Team.class);
                team2  = gson.fromJson(jsonModel.getTeams().get(jsonModel.getMatchdetail().getTeam_Away()).toString(),Team.class);


                team_a.setText(team1.getName_Full());
                team_b.setText(team2.getName_Full());
                match_time_date.setText(matchdetail.getMatch().getDate() + " at "+matchdetail.getMatch().getTime());
                match_venue.setText(matchdetail.getVenue().getName());
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (checkedPosition != getAdapterPosition()) {
                            notifyItemChanged(checkedPosition);
                            checkedPosition = getAdapterPosition();
                        }
                        itemClickListener.TypeClick(getAdapterPosition());
                    }
                });
            }
        }
    }
}
