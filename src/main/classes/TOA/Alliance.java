package main.classes.TOA;

import main.classes.JSON.JSONObject;

/**
 * Created by SPZ Productions on 8/13/2017.
 */
public class Alliance {

    private Object AllianceID;
    private Object EventID;
    private Object TeamID;
    private Object AllianceNum;
    private Object AlliancePick;
    private Object AllianceName;
    private Object CardCarry;

    public Alliance(){
        this.AllianceID = "";
        this.EventID = "";
        this.TeamID = "";
        this.AllianceNum = "";
        this.AlliancePick = "";
        this.AllianceName = "";
        this.CardCarry = "";
    }

    public Alliance(Object AllianceID, Object EventID, Object TeamID, Object AllianceNum, Object AlliancePick, Object AllianceName, Object CardCarry){
        this.AllianceID = AllianceID;
        this.EventID = EventID;
        this.TeamID = TeamID;
        this.AllianceNum = AllianceNum;
        this.AlliancePick = AlliancePick;
        this.AllianceName = AllianceName;
        this.CardCarry = CardCarry;
    }

    public Alliance(JSONObject json) {
        this.AllianceID = json.get("AllianceID");
        this.EventID = json.get("EventID");
        this.TeamID = json.get("TeamID");
        this.AllianceNum = json.get("AllianceNum");
        this.AlliancePick = json.get("AlliancePick");
        this.AllianceName = json.get("AllianceName");
        this.CardCarry = json.get("CardCarry");
    }

    public Object getAllianceID() {
        return AllianceID;
    }

    public void setAllianceID(Object allianceID) {
        AllianceID = allianceID;
    }

    public Object getEventID() {
        return EventID;
    }

    public void setEventID(Object eventID) {
        EventID = eventID;
    }

    public Object getTeamID() {
        return TeamID;
    }

    public void setTeamID(Object teamID) {
        TeamID = teamID;
    }

    public Object getAllianceNum() {
        return AllianceNum;
    }

    public void setAllianceNum(Object allianceNum) {
        AllianceNum = allianceNum;
    }

    public Object getAlliancePick() {
        return AlliancePick;
    }

    public void setAlliancePick(Object alliancePick) {
        AlliancePick = alliancePick;
    }

    public Object getAllianceName() {
        return AllianceName;
    }

    public void setAllianceName(Object allianceName) {
        AllianceName = allianceName;
    }

    public Object getCardCarry() {
        return CardCarry;
    }

    public void setCardCarry(Object cardCarry) {
        CardCarry = cardCarry;
    }
}
