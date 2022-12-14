package com.example.sportz.datamodel.MatchDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Venue{

    @SerializedName("Id")
    @Expose
    private int Id;
    @SerializedName("Name")
    @Expose
    private String Name;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}