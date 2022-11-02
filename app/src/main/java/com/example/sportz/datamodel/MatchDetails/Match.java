package com.example.sportz.datamodel.MatchDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Match{

    @SerializedName("Id")
    @Expose
    private int Id;
    @SerializedName("Livecoverage")
    @Expose
    private String Livecoverage;
    @SerializedName("Code")
    @Expose
    private String Code;
    @SerializedName("League")
    @Expose
    private String League;
    @SerializedName("Number")
    @Expose
    private String Number;
    @SerializedName("Type")
    @Expose
    private String Type;
    @SerializedName("Date")
    @Expose
    private String Date;
    @SerializedName("Time")
    @Expose
    private String Time;
    @SerializedName("Offset")
    @Expose
    private String Offset;
    @SerializedName("Daynight")
    @Expose
    private String Daynight;


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getLivecoverage() {
        return Livecoverage;
    }

    public void setLivecoverage(String livecoverage) {
        Livecoverage = livecoverage;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getLeague() {
        return League;
    }

    public void setLeague(String league) {
        League = league;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getOffset() {
        return Offset;
    }

    public void setOffset(String offset) {
        Offset = offset;
    }

    public String getDaynight() {
        return Daynight;
    }

    public void setDaynight(String daynight) {
        Daynight = daynight;
    }
}
