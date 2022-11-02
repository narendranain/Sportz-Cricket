package com.example.sportz.datamodel.MatchDetails.InningModel;

import com.example.sportz.datamodel.MatchDetails.Batsman;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Partnership_Current{
    @SerializedName("Runs")
    @Expose
    public String runs;
    @SerializedName("Balls")
    @Expose
    public String balls;

    @SerializedName("Batsmen")
    @Expose
    public ArrayList<Batsman> batsmen;

    public String getRuns() {
        return runs;
    }

    public void setRuns(String runs) {
        this.runs = runs;
    }

    public String getBalls() {
        return balls;
    }

    public void setBalls(String balls) {
        this.balls = balls;
    }

    public ArrayList<Batsman> getBatsmen() {
        return batsmen;
    }

    public void setBatsmen(ArrayList<Batsman> batsmen) {
        this.batsmen = batsmen;
    }
}