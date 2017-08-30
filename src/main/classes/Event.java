package main.classes;

import org.json.simple.JSONObject;

/**
 * Created by SPZ Productions on 8/28/2017.
 */
public class Event {
    private String EventID;
    private String SeasonID;
    private String RegionID;
    private String LeagueID;
    private String EventCode;
    private String EventRegionNum;
    private String DivisionID;
    private String EventTypeID;
    private String EventName;
    private String DivisionName;
    private String StartDate;
    private String EndDate;
    private String WeekID;
    private String City;
    private String StateProv;
    private String Country;
    private String Venue;
    private String EventWebsite;
    private String TimeZone;
    private String ActiveTournamentLevel;
    private String AllianceCount;
    private String NumberOfFields;
    private String AdvanceSpots;
    private String AdvancementEvent;

    public Event(){
        this.EventID = "";
        this.SeasonID = "";
        this.RegionID = "";
        this.LeagueID = "";
        this.EventCode = "";
        this.EventRegionNum = "";
        this.DivisionID = "";
        this.EventTypeID = "";
        this.EventName = "";
        this.DivisionName = "";
        this.StartDate = "";
        this.EndDate = "";
        this.WeekID = "";
        this.City = "";
        this.StateProv = "";
        this.Country = "";
        this.Venue = "";
        this.EventWebsite = "";
        this.TimeZone = "";
        this.ActiveTournamentLevel = "";
        this.AllianceCount = "";
        this.NumberOfFields = "";
        this.AdvanceSpots = "";
        this.AdvancementEvent = "";
    }

    public Event(String EventID, String SeasonID, String RegionID, String LeagueID, String EventCode, String EventRegionNum, String DivisionID,
                 String EventTypeID, String EventName, String DivisionName, String StartDate, String EndDate, String WeekID, String City,
                 String StateProv, String Country, String Venue, String EventWebsite, String TimeZone, String ActiveTournamentLevel,
                 String AllianceCount, String NumberOfFields, String AdvanceSpots, String AdvancementEvent){

        this.EventID = EventID;
        this.SeasonID = SeasonID;
        this.RegionID = RegionID;
        this.LeagueID = LeagueID;
        this.EventCode = EventCode;
        this.EventRegionNum = EventRegionNum;
        this.DivisionID = DivisionID;
        this.EventTypeID = EventTypeID;
        this.EventName = EventName;
        this.DivisionName = DivisionName;
        this.StartDate = StartDate;
        this.EndDate = EndDate;
        this.WeekID = WeekID;
        this.City = City;
        this.StateProv = StateProv;
        this.Country = Country;
        this.Venue = Venue;
        this.EventWebsite = EventWebsite;
        this.TimeZone = TimeZone;
        this.ActiveTournamentLevel = ActiveTournamentLevel;
        this.AllianceCount = AllianceCount;
        this.NumberOfFields = NumberOfFields;
        this.AdvanceSpots = AdvanceSpots;
        this.AdvancementEvent = AdvancementEvent;

    }

    public Event(JSONObject json){
        this.EventID = json.get("event_code").toString();
        this.SeasonID = json.get("season_key").toString();
        this.RegionID = json.get("region_key").toString();
        this.LeagueID = json.get("league_key").toString();
        this.EventCode = json.get("event_key").toString();
        this.EventRegionNum = json.get("event_region_number").toString();
        this.DivisionID = json.get("division_id").toString();
        this.EventTypeID = json.get("event_type").toString();
        this.EventName = json.get("event_name").toString();
        this.DivisionName = json.get("division_name").toString();
        this.StartDate = json.get("start_date").toString();
        this.EndDate = json.get("end_date").toString();
        this.WeekID = json.get("week_key").toString();
        this.City = json.get("city").toString();
        this.StateProv = json.get("state_prov").toString();
        this.Country = json.get("country").toString();
        this.Venue = json.get("venue").toString();
        this.EventWebsite = json.get("event_website").toString();
        this.TimeZone = json.get("time_zone").toString();
        this.ActiveTournamentLevel = json.get("tournament_level").toString();
        this.AllianceCount = json.get("alliance_count").toString();
        this.NumberOfFields = json.get("fields").toString();
        this.AdvanceSpots = json.get("advancement_spots").toString();
        this.AdvancementEvent = json.get("advancement_event").toString();
    }

    public String getEventID() {
        return EventID;
    }

    public void setEventID(String eventID) {
        EventID = eventID;
    }

    public String getSeasonID() {
        return SeasonID;
    }

    public void setSeasonID(String seasonID) {
        SeasonID = seasonID;
    }

    public String getRegionID() {
        return RegionID;
    }

    public void setRegionID(String regionID) {
        RegionID = regionID;
    }

    public String getLeagueID() {
        return LeagueID;
    }

    public void setLeagueID(String leagueID) {
        LeagueID = leagueID;
    }

    public String getEventCode() {
        return EventCode;
    }

    public void setEventCode(String eventCode) {
        EventCode = eventCode;
    }

    public String getEventRegionNum() {
        return EventRegionNum;
    }

    public void setEventRegionNum(String eventRegionNum) {
        EventRegionNum = eventRegionNum;
    }

    public String getDivisionID() {
        return DivisionID;
    }

    public void setDivisionID(String divisionID) {
        DivisionID = divisionID;
    }

    public String getEventTypeID() {
        return EventTypeID;
    }

    public void setEventTypeID(String eventTypeID) {
        EventTypeID = eventTypeID;
    }

    public String getEventName() {
        return EventName;
    }

    public void setEventName(String eventName) {
        EventName = eventName;
    }

    public String getDivisionName() {
        return DivisionName;
    }

    public void setDivisionName(String divisionName) {
        DivisionName = divisionName;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String startDate) {
        StartDate = startDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String endDate) {
        EndDate = endDate;
    }

    public String getWeekID() {
        return WeekID;
    }

    public void setWeekID(String weekID) {
        WeekID = weekID;
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

    public String getVenue() {
        return Venue;
    }

    public void setVenue(String venue) {
        Venue = venue;
    }

    public String getEventWebsite() {
        return EventWebsite;
    }

    public void setEventWebsite(String eventWebsite) {
        EventWebsite = eventWebsite;
    }

    public String getTimeZone() {
        return TimeZone;
    }

    public void setTimeZone(String timeZone) {
        TimeZone = timeZone;
    }

    public String getActiveTournamentLevel() {
        return ActiveTournamentLevel;
    }

    public void setActiveTournamentLevel(String activeTournamentLevel) {
        ActiveTournamentLevel = activeTournamentLevel;
    }

    public String getAllianceCount() {
        return AllianceCount;
    }

    public void setAllianceCount(String allianceCount) {
        AllianceCount = allianceCount;
    }

    public String getNumberOfFields() {
        return NumberOfFields;
    }

    public void setNumberOfFields(String numberOfFields) {
        NumberOfFields = numberOfFields;
    }

    public String getAdvanceSpots() {
        return AdvanceSpots;
    }

    public void setAdvanceSpots(String advanceSpots) {
        AdvanceSpots = advanceSpots;
    }

    public String getAdvancementEvent() {
        return AdvancementEvent;
    }

    public void setAdvancementEvent(String advancementEvent) {
        AdvancementEvent = advancementEvent;
    }
}