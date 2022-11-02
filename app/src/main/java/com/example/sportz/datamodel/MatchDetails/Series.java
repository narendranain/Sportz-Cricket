package com.example.sportz.datamodel.MatchDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Series{

    @SerializedName("Id")
    @Expose
    private int Id;
    @SerializedName("Name")
    @Expose
    private String Name;
    @SerializedName("Status")
    @Expose
    private String Status;
    @SerializedName("Tour")
    @Expose
    private String Tour;
    @SerializedName("Tour_Name")
    @Expose
    private String Tour_Name;

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

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getTour() {
        return Tour;
    }

    public void setTour(String tour) {
        Tour = tour;
    }

    public String getTour_Name() {
        return Tour_Name;
    }

    public void setTour_Name(String tour_Name) {
        Tour_Name = tour_Name;
    }
}
