package com.example.sportz.datamodel.MatchDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Batsman{


    @SerializedName("Batsman")
    @Expose
    public String batsman;
    @SerializedName("Runs")
    @Expose
    public String runs;
    @SerializedName("Balls")
    @Expose
    public String balls;
    @SerializedName("Fours")
    @Expose
    public String fours;
    @SerializedName("Sixes")
    @Expose
    public String sixes;
    @SerializedName("Dots")
    @Expose
    public String dots;
    @SerializedName("Strikerate")
    @Expose
    public String strikerate;
    @SerializedName("Dismissal")
    @Expose
    public String dismissal;
    @SerializedName("Howout")
    @Expose
    public String howout;
    @SerializedName("Bowler")
    @Expose
    public String bowler;
    @SerializedName("Fielder")
    @Expose
    public String fielder;
    @SerializedName("Isonstrike")
    @Expose
    public boolean isonstrike;

    public String getBatsman() {
        return batsman;
    }

    public void setBatsman(String batsman) {
        this.batsman = batsman;
    }

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

    public String getFours() {
        return fours;
    }

    public void setFours(String fours) {
        this.fours = fours;
    }

    public String getSixes() {
        return sixes;
    }

    public void setSixes(String sixes) {
        this.sixes = sixes;
    }

    public String getDots() {
        return dots;
    }

    public void setDots(String dots) {
        this.dots = dots;
    }

    public String getStrikerate() {
        return strikerate;
    }

    public void setStrikerate(String strikerate) {
        this.strikerate = strikerate;
    }

    public String getDismissal() {
        return dismissal;
    }

    public void setDismissal(String dismissal) {
        this.dismissal = dismissal;
    }

    public String getHowout() {
        return howout;
    }

    public void setHowout(String howout) {
        this.howout = howout;
    }

    public String getBowler() {
        return bowler;
    }

    public void setBowler(String bowler) {
        this.bowler = bowler;
    }

    public String getFielder() {
        return fielder;
    }

    public void setFielder(String fielder) {
        this.fielder = fielder;
    }

    public boolean isIsonstrike() {
        return isonstrike;
    }

    public void setIsonstrike(boolean isonstrike) {
        this.isonstrike = isonstrike;
    }
}
