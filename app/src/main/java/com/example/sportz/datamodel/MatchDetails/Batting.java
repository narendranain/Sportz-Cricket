package com.example.sportz.datamodel.MatchDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Batting{
    @SerializedName("Style")
    @Expose
    public String style;
    @SerializedName("Average")
    @Expose
    public String average;
    @SerializedName("Strikerate")
    @Expose
    public String strikerate;
    @SerializedName("Runs")
    @Expose
    public String runs;

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

    public String getStrikerate() {
        return strikerate;
    }

    public void setStrikerate(String strikerate) {
        this.strikerate = strikerate;
    }

    public String getRuns() {
        return runs;
    }

    public void setRuns(String runs) {
        this.runs = runs;
    }
}
