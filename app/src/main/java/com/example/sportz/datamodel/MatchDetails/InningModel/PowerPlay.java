package com.example.sportz.datamodel.MatchDetails.InningModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PowerPlay {
    @SerializedName("PP1")
    @Expose
    public String PP1;
    @SerializedName("PP2")
    @Expose
    public String PP2;

    public String getPP1() {
        return PP1;
    }

    public void setPP1(String PP1) {
        this.PP1 = PP1;
    }

    public String getPP2() {
        return PP2;
    }

    public void setPP2(String PP2) {
        this.PP2 = PP2;
    }
}
