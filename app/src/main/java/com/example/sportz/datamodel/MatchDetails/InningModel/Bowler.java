package com.example.sportz.datamodel.MatchDetails.InningModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Bowler{
    @SerializedName("Bowler")
    @Expose
    public String bowler;
    @SerializedName("Overs")
    @Expose
    public String overs;
    @SerializedName("Maidens")
    @Expose
    public String maidens;
    @SerializedName("Runs")
    @Expose
    public String runs;
    @SerializedName("Wickets")
    @Expose
    public String wickets;
    @SerializedName("Economyrate")
    @Expose
    public String economyrate;
    @SerializedName("Noballs")
    @Expose
    public String noballs;
    @SerializedName("Wides")
    @Expose
    public String wides;
    @SerializedName("Dots")
    @Expose
    public String dots;
    @SerializedName("Isbowlingtandem")
    @Expose
    public boolean isbowlingtandem;
    @SerializedName("Isbowlingnow")
    @Expose
    public boolean isbowlingnow;
    @SerializedName("ThisOver")
    @Expose
    public ArrayList<ThisOver> thisOver;

    public String getBowler() {
        return bowler;
    }

    public void setBowler(String bowler) {
        this.bowler = bowler;
    }

    public String getOvers() {
        return overs;
    }

    public void setOvers(String overs) {
        this.overs = overs;
    }

    public String getMaidens() {
        return maidens;
    }

    public void setMaidens(String maidens) {
        this.maidens = maidens;
    }

    public String getRuns() {
        return runs;
    }

    public void setRuns(String runs) {
        this.runs = runs;
    }

    public String getWickets() {
        return wickets;
    }

    public void setWickets(String wickets) {
        this.wickets = wickets;
    }

    public String getEconomyrate() {
        return economyrate;
    }

    public void setEconomyrate(String economyrate) {
        this.economyrate = economyrate;
    }

    public String getNoballs() {
        return noballs;
    }

    public void setNoballs(String noballs) {
        this.noballs = noballs;
    }

    public String getWides() {
        return wides;
    }

    public void setWides(String wides) {
        this.wides = wides;
    }

    public String getDots() {
        return dots;
    }

    public void setDots(String dots) {
        this.dots = dots;
    }

    public boolean isIsbowlingtandem() {
        return isbowlingtandem;
    }

    public void setIsbowlingtandem(boolean isbowlingtandem) {
        this.isbowlingtandem = isbowlingtandem;
    }

    public boolean isIsbowlingnow() {
        return isbowlingnow;
    }

    public void setIsbowlingnow(boolean isbowlingnow) {
        this.isbowlingnow = isbowlingnow;
    }

    public ArrayList<ThisOver> getThisOver() {
        return thisOver;
    }

    public void setThisOver(ArrayList<ThisOver> thisOver) {
        this.thisOver = thisOver;
    }
}
