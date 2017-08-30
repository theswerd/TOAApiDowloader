package main.classes;

import org.json.simple.JSONObject;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by SPZ Productions on 8/11/2017.
 */
public class EventTeam {

    private String TeamID;
    private String RegionID;
    private String LeagueID;
    private String TeamNumber;
    private String TeamNameShort;
    private String TeamNameLong;
    private String RobotName;
    private String City;
    private String StateProv;
    private String Country;
    private String RookieYear;
    private String Website;
    private String HasCard;
    private String EventID;

    public EventTeam(){
        this.TeamID = "";
        this.RegionID = "";
        this.LeagueID = "";
        this.TeamNumber = "";
        this.TeamNameShort = "";
        this.TeamNameLong = "";
        this.RobotName = "";
        this.City = "";
        this.StateProv = "";
        this.Country = "";
        this.RookieYear = "";
        this.Website = "";
        this.HasCard = "";
        this.EventID = "";
    }

    public EventTeam(String TeamID, String RegionID, String LeagueID, String TeamNumber, String TeamNameShort, String TeamNameLong, String RobotName, String City, String StateProv, String Country, String RookieYear, String Website, String HasCard, String EventID){
        this.TeamID = TeamID;
        this.RegionID = RegionID;
        this.LeagueID = LeagueID;
        this.TeamNumber = TeamNumber;
        this.TeamNameShort = TeamNameShort;
        this.TeamNameLong = TeamNameLong;
        this.RobotName = RobotName;
        this.City = City;
        this.StateProv = StateProv;
        this.Country = Country;
        this.RookieYear = RookieYear;
        this.Website = Website;
        this.HasCard = HasCard;
        this.EventID = EventID;
    }

    public EventTeam(ResultSet rs) throws SQLException {
        this.TeamID = rs.getString("TeamID");
        this.RegionID = rs.getString("RegionID");
        this.LeagueID = rs.getString("LeagueID");
        this.TeamNumber = rs.getString("TeamNumber");
        this.TeamNameShort = rs.getString("TeamNameShort");
        this.TeamNameLong = rs.getString("TeamNameLong");
        this.RobotName = rs.getString("RobotName");
        this.City = rs.getString("City");
        this.StateProv = rs.getString("StateProv");
        this.Country = rs.getString("Country");
        this.RookieYear = rs.getString("RookieYear");
        this.Website = rs.getString("Website");
        this.HasCard = rs.getString("HasCard");
        this.EventID = rs.getString("EventID");
    }

    public EventTeam(JSONObject json){
        this.TeamID = json.get("team_key").toString();
        this.RegionID = json.get("region_key").toString();
        this.LeagueID = json.get("league_key").toString();
        this.TeamNumber = json.get("team_number").toString();
        this.TeamNameShort = json.get("team_name_short").toString();
        this.TeamNameLong = json.get("team_name_long").toString();
        this.RobotName = json.get("robot_name").toString();
        this.City = json.get("city").toString();
        this.StateProv = json.get("state_prov").toString();
        this.Country = json.get("country").toString();
        this.RookieYear = json.get("rookie_year").toString();
        this.Website = json.get("website").toString();
        this.HasCard = json.get("has_card").toString();
        this.EventID = json.get("event_key").toString();
    }

    public String getEventID() {
        return EventID;
    }

    public void setEventID(String eventID) {
        EventID = eventID;
    }

    public String getHasCard() {
        return HasCard;
    }

    public void setHasCard(String hasCard) {
        HasCard = hasCard;
    }

    public String getTeamID() {
        return TeamID;
    }

    public void setTeamID(String teamID) {
        TeamID = teamID;
    }

    public String getLeagueID() {
        return LeagueID;
    }

    public void setLeagueID(String leagueID) {
        LeagueID = leagueID;
    }

    public String getTeamNumber() {
        return TeamNumber;
    }

    public void setTeamNumber(String teamNumber) {
        TeamNumber = teamNumber;
    }

    public String getTeamNameShort() {
        return TeamNameShort;
    }

    public void setTeamNameShort(String teamNameShort) {
        TeamNameShort = teamNameShort;
    }

    public String getTeamNameLong() {
        return TeamNameLong;
    }

    public void setTeamNameLong(String teamNameLong) {
        TeamNameLong = teamNameLong;
    }

    public String getRobotName() {
        return RobotName;
    }

    public void setRobotName(String robotName) {
        RobotName = robotName;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getStateProv() {
        return StateProv;
    }

    public void setStateProv(String stateProv) {
        StateProv = stateProv;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getRookieYear() {
        return RookieYear;
    }

    public void setRookieYear(String rookieYear) {
        RookieYear = rookieYear;
    }

    public String getWebsite() {
        return Website;
    }

    public void setWebsite(String website) {
        Website = website;
    }

    public void setRegionID(String regionID) {
        RegionID = regionID;
    }

    public String getRegionID() {
        return RegionID;
    }
}

