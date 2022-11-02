package com.example.sportz.datamodel.MatchDetails.InningModel;

import com.example.sportz.datamodel.MatchDetails.Batsman;
import com.example.sportz.datamodel.MatchDetails.FallofWicket;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;

import java.util.ArrayList;

public class Inning{

    @SerializedName("Number")
    @Expose
    private String Number;
    @SerializedName("Battingteam")
    @Expose
    private String Battingteam;
    @SerializedName("Total")
    @Expose
    private String Total;
    @SerializedName("Wickets")
    @Expose
    private String Wickets;
    @SerializedName("Overs")
    @Expose
    private String Overs;

    @SerializedName("Runrate")
    @Expose
    private String Runrate;
    @SerializedName("Byes")
    @Expose
    private String Byes;
    @SerializedName("Legbyes")
    @Expose
    private String Legbyes;
    @SerializedName("Wides")
    @Expose
    private String Wides;
    @SerializedName("Noballs")
    @Expose
    private String Noballs;
    @SerializedName("Penalty")
    @Expose
    private String Penalty;
    @SerializedName("AllottedOvers")
    @Expose
    private String AllottedOvers;

    @SerializedName("Batsmen")
    @Expose
    public ArrayList<Batsman> batsmen;
    @SerializedName("Partnership_Current")
    @Expose
    public Partnership_Current partnership_Current;
    @SerializedName("Bowlers")
    @Expose
    public ArrayList<Bowler> bowlers;
    @SerializedName("FallofWickets")
    @Expose
    public ArrayList<FallofWicket> fallofWickets;
    @SerializedName("PowerPlay")
    @Expose
    public PowerPlay powerPlay;
    @SerializedName("Target")
    @Expose
    public String target;

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getBattingteam() {
        return Battingteam;
    }

    public void setBattingteam(String battingteam) {
        Battingteam = battingteam;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String total) {
        Total = total;
    }

    public String getWickets() {
        return Wickets;
    }

    public void setWickets(String wickets) {
        Wickets = wickets;
    }

    public String getOvers() {
        return Overs;
    }

    public void setOvers(String overs) {
        Overs = overs;
    }

    public String getRunrate() {
        return Runrate;
    }

    public void setRunrate(String runrate) {
        Runrate = runrate;
    }

    public String getByes() {
        return Byes;
    }

    public void setByes(String byes) {
        Byes = byes;
    }

    public String getLegbyes() {
        return Legbyes;
    }

    public void setLegbyes(String legbyes) {
        Legbyes = legbyes;
    }

    public String getWides() {
        return Wides;
    }

    public void setWides(String wides) {
        Wides = wides;
    }

    public String getNoballs() {
        return Noballs;
    }

    public void setNoballs(String noballs) {
        Noballs = noballs;
    }

    public String getPenalty() {
        return Penalty;
    }

    public void setPenalty(String penalty) {
        Penalty = penalty;
    }

    public String getAllottedOvers() {
        return AllottedOvers;
    }

    public void setAllottedOvers(String allottedOvers) {
        AllottedOvers = allottedOvers;
    }




    public Partnership_Current getPartnership_Current() {
        return partnership_Current;
    }

    public void setPartnership_Current(Partnership_Current partnership_Current) {
        this.partnership_Current = partnership_Current;
    }

    public ArrayList<Batsman> getBatsmen() {
        return batsmen;
    }

    public void setBatsmen(ArrayList<Batsman> batsmen) {
        this.batsmen = batsmen;
    }

    public ArrayList<Bowler> getBowlers() {
        return bowlers;
    }

    public void setBowlers(ArrayList<Bowler> bowlers) {
        this.bowlers = bowlers;
    }

    public ArrayList<FallofWicket> getFallofWickets() {
        return fallofWickets;
    }

    public void setFallofWickets(ArrayList<FallofWicket> fallofWickets) {
        this.fallofWickets = fallofWickets;
    }

    public PowerPlay getPowerPlay() {
        return powerPlay;
    }

    public void setPowerPlay(PowerPlay powerPlay) {
        this.powerPlay = powerPlay;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}

