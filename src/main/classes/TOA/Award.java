package main.classes.TOA;


import main.classes.JSON.JSONObject;

/**
 * Created by SPZ Productions on 8/13/2017.
 */
public class Award {
    private Object AwardsID;
    private Object EventID ;
    private Object AwardID;
    private Object TeamId;
    private Object RecieverNam;
    private Object AwardNamAdd;

    public Award(){
        this.AwardsID = "";
        this.EventID  = "";
        this.AwardID = "";
        this.TeamId = "";
        this.RecieverNam = "";
        this.AwardNamAdd = "";
    }

    public Award(Object AwardsID, Object EventID , Object AwardID, Object TeamId, Object RecieverNam, Object AwardNamAdd){
        this.AwardsID = AwardsID;
        this.EventID  = EventID;
        this.AwardID = AwardID;
        this.TeamId = TeamId;
        this.RecieverNam = RecieverNam;
        this.AwardNamAdd = AwardNamAdd;
    }

    public Award(JSONObject json) {
        this.AwardsID = json.get("award_key");
        this.AwardID = json.get("award_name");
        this.TeamId = json.get("team_key");
        this.RecieverNam = json.get("reciever_name");
        this.AwardNamAdd = json.get("award_desc");
    }

    public Object getAwardsID() {
        return AwardsID;
    }

    public void setAwardsID(Object awardsID) {
        AwardsID = awardsID;
    }

    public Object getEventID() {
        return EventID;
    }

    public void setEventID(Object eventID) {
        EventID = eventID;
    }

    public Object getAwardID() {
        return AwardID;
    }

    public void setAwardID(Object awardID) {
        AwardID = awardID;
    }

    public Object getTeamId() {
        return TeamId;
    }

    public void setTeamId(Object teamId) {
        TeamId = teamId;
    }

    public Object getRecieverNam() {
        return RecieverNam;
    }

    public void setRecieverNam(Object recieverNam) {
        RecieverNam = recieverNam;
    }

    public Object getAwardNamAdd() {
        return AwardNamAdd;
    }

    public void setAwardNamAdd(Object awardNamAdd) {
        AwardNamAdd = awardNamAdd;
    }
}
