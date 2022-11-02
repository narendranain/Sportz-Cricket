package com.example.sportz.datamodel.MatchDetails.Teams;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

public class Team {
    @SerializedName("Name_Full")
    @Expose
    public  String Name_Full;
    @SerializedName("Name_Short")
    @Expose
    public  String Name_Short;
    @SerializedName("Players")
    @Expose
    public JsonObject Players;

    public String getName_Full() {
        return Name_Full;
    }

    public void setName_Full(String name_Full) {
        Name_Full = name_Full;
    }

    public String getName_Short() {
        return Name_Short;
    }

    public void setName_Short(String name_Short) {
        Name_Short = name_Short;
    }

    public JsonObject getPlayers() {
        return Players;
    }

    public void setPlayers(JsonObject players) {
        Players = players;
    }
}
