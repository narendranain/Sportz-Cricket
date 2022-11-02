package com.example.sportz.datamodel.MatchDetails.Teams;

import com.example.sportz.datamodel.MatchDetails.Batting;
import com.example.sportz.datamodel.MatchDetails.Bowling;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

public class Players {
    @SerializedName("Bowling")
    @Expose
    public Bowling Bowling;
    @SerializedName("Batting")
    @Expose
    public Batting Batting;
    @SerializedName("Position")
    @Expose
    public String Position;
    @SerializedName("Name_Full")
    @Expose
    public String Name_Full;
    @SerializedName("Iskeeper")
    @Expose
    public String Iskeeper;
    @SerializedName("Iscaptain")
    @Expose
    public String Iscaptain;



    public Bowling getBowling() {
        return Bowling;
    }

    public void setBowling(Bowling bowling) {
        Bowling = bowling;
    }

    public Batting getBatting() {
        return Batting;
    }

    public void setBatting(Batting batting) {
        Batting = batting;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public String getName_Full() {
        return Name_Full;
    }

    public void setName_Full(String name_Full) {
        Name_Full = name_Full;
    }

    public String getIskeeper() {
        return Iskeeper;
    }

    public void setIskeeper(String iskeeper) {
        Iskeeper = iskeeper;
    }

    public String getIscaptain() {
        return Iscaptain;
    }

    public void setIscaptain(String iscaptain) {
        Iscaptain = iscaptain;
    }
}
