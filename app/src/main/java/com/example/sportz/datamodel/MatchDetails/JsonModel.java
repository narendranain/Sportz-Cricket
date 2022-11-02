package com.example.sportz.datamodel.MatchDetails;

import com.example.sportz.datamodel.MatchDetails.InningModel.Inning;
import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonModel {

    @SerializedName("Matchdetail")
    @Expose
    private Matchdetail Matchdetail;
    @SerializedName("Innings")
    @Expose
    private ArrayList<Inning> Innings;
    @SerializedName("Teams")
    @Expose
    private JsonObject Teams;

    public com.example.sportz.datamodel.MatchDetails.Matchdetail getMatchdetail() {
        return Matchdetail;
    }

    public void setMatchdetail(com.example.sportz.datamodel.MatchDetails.Matchdetail matchdetail) {
        Matchdetail = matchdetail;
    }


    public ArrayList<Inning> getInnings() {
        return Innings;
    }

    public void setInnings(ArrayList<Inning> innings) {
        Innings = innings;
    }

    public JsonObject getTeams() {
        return Teams;
    }

    public void setTeams(JsonObject teams) {
        Teams = teams;
    }
}
