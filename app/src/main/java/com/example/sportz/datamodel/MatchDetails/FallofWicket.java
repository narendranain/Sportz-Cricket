package com.example.sportz.datamodel.MatchDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FallofWicket{
    @SerializedName("Batsman")
    @Expose
    public String batsman;
    @SerializedName("Score")
    @Expose
    public String score;
    @SerializedName("Overs")
    @Expose
    public String overs;

    public String getBatsman() {
        return batsman;
    }

    public void setBatsman(String batsman) {
        this.batsman = batsman;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getOvers() {
        return overs;
    }

    public void setOvers(String overs) {
        this.overs = overs;
    }
}
