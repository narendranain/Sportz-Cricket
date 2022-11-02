package com.example.sportz.datamodel.MatchDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bowling{
    @SerializedName("Style")
    @Expose
    public String style;
    @SerializedName("Average")
    @Expose
    public String average;
    @SerializedName("Economyrate")
    @Expose
    public String economyrate;
    @SerializedName("Wickets")
    @Expose
    public String wickets;

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }

    public String getEconomyrate() {
        return economyrate;
    }

    public void setEconomyrate(String economyrate) {
        this.economyrate = economyrate;
    }

    public String getWickets() {
        return wickets;
    }

    public void setWickets(String wickets) {
        this.wickets = wickets;
    }
}
