package main.classes.TOA;

import main.classes.JSON.JSONObject;

/**
 * Created by SPZ Productions on 8/28/2017.
 */
public class Event {
    private Object EventID;
    private Object SeasonID;
    private Object RegionID;
    private Object LeagueID;
    private Object EventCode;
    private Object EventRegionNum;
    private Object DivisionID;
    private Object EventTypeID;
    private Object EventName;
    private Object DivisionName;
    private Object StartDate;
    private Object EndDate;
    private Object WeekID;
    private Object City;
    private Object StateProv;
    private Object Country;
    private Object Venue;
    private Object EventWebsite;
    private Object TimeZone;
    private Object ActiveTournamentLevel;
    private Object AllianceCount;
    private Object NumberOfFields;
    private Object AdvanceSpots;
    private Object AdvancementEvent;

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

    public Event(Object EventID, Object SeasonID, Object RegionID, Object LeagueID, Object EventCode, Object EventRegionNum, Object DivisionID,
                 Object EventTypeID, Object EventName, Object DivisionName, Object StartDate, Object EndDate, Object WeekID, Object City,
                 Object StateProv, Object Country, Object Venue, Object EventWebsite, Object TimeZone, Object ActiveTournamentLevel,
                 Object AllianceCount, Object NumberOfFields, Object AdvanceSpots, Object AdvancementEvent){

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
        this.EventID = json.get("event_code");
        this.SeasonID = json.get("season_key");
        this.RegionID = json.get("region_key");
        this.LeagueID = json.get("league_key");
        this.EventCode = json.get("event_key");
        this.EventRegionNum = json.get("event_region_number");
        this.DivisionID = json.get("division_id");
        this.EventTypeID = json.get("event_type");
        this.EventName = json.get("event_name");
        this.DivisionName = json.get("division_name");
        this.StartDate = json.get("start_date");
        this.EndDate = json.get("end_date");
        this.WeekID = json.get("week_key");
        this.City = json.get("city");
        this.StateProv = json.get("state_prov");
        this.Country = json.get("country");
        this.Venue = json.get("venue");
        this.EventWebsite = json.get("event_website");
        this.TimeZone = json.get("time_zone");
        this.ActiveTournamentLevel = json.get("tournament_level");
        this.AllianceCount = json.get("alliance_count");
        this.NumberOfFields = json.get("fields");
        this.AdvanceSpots = json.get("advancement_spots");
        this.AdvancementEvent = json.get("advancement_event");
    }

    public Object getEventID() {
        return EventID;
    }

    public void setEventID(Object eventID) {
        EventID = eventID;
    }

    public Object getSeasonID() {
        return SeasonID;
    }

    public void setSeasonID(Object seasonID) {
        SeasonID = seasonID;
    }

    public Object getRegionID() {
        return RegionID;
    }

    public void setRegionID(Object regionID) {
        RegionID = regionID;
    }

    public Object getLeagueID() {
        return LeagueID;
    }

    public void setLeagueID(Object leagueID) {
        LeagueID = leagueID;
    }

    public Object getEventCode() {
        return EventCode;
    }

    public void setEventCode(Object eventCode) {
        EventCode = eventCode;
    }

    public Object getEventRegionNum() {
        return EventRegionNum;
    }

    public void setEventRegionNum(Object eventRegionNum) {
        EventRegionNum = eventRegionNum;
    }

    public Object getDivisionID() {
        return DivisionID;
    }

    public void setDivisionID(Object divisionID) {
        DivisionID = divisionID;
    }

    public Object getEventTypeID() {
        return EventTypeID;
    }

    public void setEventTypeID(Object eventTypeID) {
        EventTypeID = eventTypeID;
    }

    public Object getEventName() {
        return EventName;
    }

    public void setEventName(Object eventName) {
        EventName = eventName;
    }

    public Object getDivisionName() {
        return DivisionName;
    }

    public void setDivisionName(Object divisionName) {
        DivisionName = divisionName;
    }

    public Object getStartDate() {
        return StartDate;
    }

    public void setStartDate(Object startDate) {
        StartDate = startDate;
    }

    public Object getEndDate() {
        return EndDate;
    }

    public void setEndDate(Object endDate) {
        EndDate = endDate;
    }

    public Object getWeekID() {
        return WeekID;
    }

    public void setWeekID(Object weekID) {
        WeekID = weekID;
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

    public Object getVenue() {
        return Venue;
    }

    public void setVenue(Object venue) {
        Venue = venue;
    }

    public Object getEventWebsite() {
        return EventWebsite;
    }

    public void setEventWebsite(Object eventWebsite) {
        EventWebsite = eventWebsite;
    }

    public Object getTimeZone() {
        return TimeZone;
    }

    public void setTimeZone(Object timeZone) {
        TimeZone = timeZone;
    }

    public Object getActiveTournamentLevel() {
        return ActiveTournamentLevel;
    }

    public void setActiveTournamentLevel(Object activeTournamentLevel) {
        ActiveTournamentLevel = activeTournamentLevel;
    }

    public Object getAllianceCount() {
        return AllianceCount;
    }

    public void setAllianceCount(Object allianceCount) {
        AllianceCount = allianceCount;
    }

    public Object getNumberOfFields() {
        return NumberOfFields;
    }

    public void setNumberOfFields(Object numberOfFields) {
        NumberOfFields = numberOfFields;
    }

    public Object getAdvanceSpots() {
        return AdvanceSpots;
    }

    public void setAdvanceSpots(Object advanceSpots) {
        AdvanceSpots = advanceSpots;
    }

    public Object getAdvancementEvent() {
        return AdvancementEvent;
    }

    public void setAdvancementEvent(Object advancementEvent) {
        AdvancementEvent = advancementEvent;
    }
}