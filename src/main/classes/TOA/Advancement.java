package main.classes.TOA;

import main.classes.JSON.JSONObject;

/**
 * Created by SPZ Productions on 8/13/2017.
 */
public class Advancement {

    private Object AdvancementsID;
    private Object EventID;
    private Object AdvancementID;
    private Object TeamID;
    private Object ReasonSkip;

    public Advancement(){
        this.AdvancementsID = "";
        this.EventID = "";
        this.AdvancementID = "";
        this.TeamID = "";
        this.ReasonSkip = "";
    }

    public Advancement(Object AdvancementsID, Object EventID, Object AdvancementID, Object TeamID, Object ReasonSkip){
        this.AdvancementsID = AdvancementsID;
        this.EventID = EventID;
        this.AdvancementID = AdvancementID;
        this.TeamID = TeamID;
        this.ReasonSkip = ReasonSkip;
    }

    public Advancement(JSONObject json){
        this.AdvancementsID = json.get("AdvancementsID");
        this.EventID = json.get("EventID");
        this.AdvancementID = json.get("AdvancementID");
        this.TeamID = json.get("TeamID");
        this.ReasonSkip = json.get("ReasonSkip");
    }

    public Object getAdvancementsID() {
        return AdvancementsID;
    }

    public void setAdvancementsID(Object advancementsID) {
        AdvancementsID = advancementsID;
    }

    public Object getEventID() {
        return EventID;
    }

    public void setEventID(Object eventID) {
        EventID = eventID;
    }

    public Object getAdvancementID() {
        return AdvancementID;
    }

    public void setAdvancementID(Object advancementID) {
        AdvancementID = advancementID;
    }

    public Object getTeamID() {
        return TeamID;
    }

    public void setTeamID(Object teamID) {
        TeamID = teamID;
    }

    public Object getReasonSkip() {
        return ReasonSkip;
    }

    public void setReasonSkip(Object reasonSkip) {
        ReasonSkip = reasonSkip;
    }
}
