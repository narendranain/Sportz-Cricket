package com.example.sportz.datamodel.MatchDetails;

        import android.os.Parcel;
        import android.os.Parcelable;

        import com.example.sportz.datamodel.MatchDetails.Match;
        import com.example.sportz.datamodel.MatchDetails.Series;
        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

        import java.util.ArrayList;

public class Matchdetail {

    @SerializedName("Match")
    @Expose
    private Match Match = null;
    @SerializedName("Team_Home")
    @Expose
    private String Team_Home;
    @SerializedName("Team_Away")
    @Expose
    private String Team_Away;

    @SerializedName("Series")
    @Expose
    private Series Series = null;

    @SerializedName("Venue")
    @Expose
    private Venue Venue = null;


    @SerializedName("Weather")
    @Expose
    private String Weather;
    @SerializedName("Tosswonby")
    @Expose
    private String Tosswonby;
    @SerializedName("Status")
    @Expose
    private String Status;
    @SerializedName("Status_Id")
    @Expose
    private String Status_Id;
    @SerializedName("Player_Match")
    @Expose
    private String Player_Match;
    @SerializedName("Result")
    @Expose
    private String Result;
    @SerializedName("Winningteam")
    @Expose
    private String Winningteam;
    @SerializedName("Winmargin")
    @Expose
    private String Winmargin;

    @SerializedName("Equation")
    @Expose
    private String Equation;




    public Match getMatch() {
        return Match;
    }

    public void setMatch(Match match) {
        this.Match = match;
    }

    public String getTeam_Home() {
        return Team_Home;
    }

    public void setTeam_Home(String team_Home) {
        Team_Home = team_Home;
    }

    public String getTeam_Away() {
        return Team_Away;
    }

    public void setTeam_Away(String team_Away) {
        Team_Away = team_Away;
    }

    public Series getSeries() {
        return Series;
    }

    public void setSeries(Series series) {
        Series = series;
    }

    public Venue getVenue() {
        return Venue;
    }

    public void setVenue(Venue venue) {
        Venue = venue;
    }

    public String getWeather() {
        return Weather;
    }

    public void setWeather(String weather) {
        Weather = weather;
    }

    public String getTosswonby() {
        return Tosswonby;
    }

    public void setTosswonby(String tosswonby) {
        Tosswonby = tosswonby;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getStatus_Id() {
        return Status_Id;
    }

    public void setStatus_Id(String status_Id) {
        Status_Id = status_Id;
    }

    public String getPlayer_Match() {
        return Player_Match;
    }

    public void setPlayer_Match(String player_Match) {
        Player_Match = player_Match;
    }

    public String getResult() {
        return Result;
    }

    public void setResult(String result) {
        Result = result;
    }

    public String getWinningteam() {
        return Winningteam;
    }

    public void setWinningteam(String winningteam) {
        Winningteam = winningteam;
    }

    public String getWinmargin() {
        return Winmargin;
    }

    public void setWinmargin(String winmargin) {
        Winmargin = winmargin;
    }

    public String getEquation() {
        return Equation;
    }

    public void setEquation(String equation) {
        Equation = equation;
    }
}
