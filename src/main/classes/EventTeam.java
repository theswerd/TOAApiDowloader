package main.classes;


/**
 * Created by SPZ Productions on 8/11/2017.
 */
public class EventTeam {

    private Object TeamID;
    private Object RegionID;
    private Object LeagueID;
    private Object TeamNumber;
    private Object TeamNameShort;
    private Object TeamNameLong;
    private Object RobotName;
    private Object City;
    private Object StateProv;
    private Object Country;
    private Object RookieYear;
    private Object Website;
    private Object HasCard;
    private Object EventID;

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

    public EventTeam(Object TeamID, Object RegionID, Object LeagueID, Object TeamNumber, Object TeamNameShort, Object TeamNameLong, Object RobotName, Object City, Object StateProv, Object Country, Object RookieYear, Object Website, Object HasCard, Object EventID){
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

    public EventTeam(JSONObject json){
        this.TeamID = json.get("team_key");
        this.RegionID = json.get("region_key");
        this.LeagueID = json.get("league_key");
        this.TeamNumber = json.get("team_number");
        this.TeamNameShort = json.get("team_name_short");
        this.TeamNameLong = json.get("team_name_long");
        this.RobotName = json.get("robot_name");
        this.City = json.get("city");
        this.StateProv = json.get("state_prov");
        this.Country = json.get("country");
        this.RookieYear = json.get("rookie_year");
        this.Website = json.get("website");
        this.HasCard = json.get("has_card");
        this.EventID = json.get("event_key");
    }

    public Object getEventID() {
        return EventID;
    }

    public void setEventID(Object eventID) {
        EventID = eventID;
    }

    public Object getHasCard() {
        return HasCard;
    }

    public void setHasCard(Object hasCard) {
        HasCard = hasCard;
    }

    public Object getTeamID() {
        return TeamID;
    }

    public void setTeamID(Object teamID) {
        TeamID = teamID;
    }

    public Object getLeagueID() {
        return LeagueID;
    }

    public void setLeagueID(Object leagueID) {
        LeagueID = leagueID;
    }

    public Object getTeamNumber() {
        return TeamNumber;
    }

    public void setTeamNumber(Object teamNumber) {
        TeamNumber = teamNumber;
    }

    public Object getTeamNameShort() {
        return TeamNameShort;
    }

    public void setTeamNameShort(Object teamNameShort) {
        TeamNameShort = teamNameShort;
    }

    public Object getTeamNameLong() {
        return TeamNameLong;
    }

    public void setTeamNameLong(Object teamNameLong) {
        TeamNameLong = teamNameLong;
    }

    public Object getRobotName() {
        return RobotName;
    }

    public void setRobotName(Object robotName) {
        RobotName = robotName;
    }

    public Object getCity() {
        return City;
    }

    public void setCity(Object city) {
        City = city;
    }

    public Object getStateProv() {
        return StateProv;
    }

    public void setStateProv(Object stateProv) {
        StateProv = stateProv;
    }

    public Object getCountry() {
        return Country;
    }

    public void setCountry(Object country) {
        Country = country;
    }

    public Object getRookieYear() {
        return RookieYear;
    }

    public void setRookieYear(Object rookieYear) {
        RookieYear = rookieYear;
    }

    public Object getWebsite() {
        return Website;
    }

    public void setWebsite(Object website) {
        Website = website;
    }

    public void setRegionID(Object regionID) {
        RegionID = regionID;
    }

    public Object getRegionID() {
        return RegionID;
    }
}

