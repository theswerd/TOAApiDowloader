package main.classes;

import org.json.simple.JSONObject;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by SPZ Productions on 8/13/2017.
 */
public class Award {
    private String AwardsID;
    private String EventID ;
    private String AwardID;
    private String TeamId;
    private String RecieverNam;
    private String AwardNamAdd;

    public Award(){
        this.AwardsID = "";
        this.EventID  = "";
        this.AwardID = "";
        this.TeamId = "";
        this.RecieverNam = "";
        this.AwardNamAdd = "";
    }

    public Award(String AwardsID, String EventID , String AwardID, String TeamId, String RecieverNam, String AwardNamAdd){
        this.AwardsID = AwardsID;
        this.EventID  = EventID;
        this.AwardID = AwardID;
        this.TeamId = TeamId;
        this.RecieverNam = RecieverNam;
        this.AwardNamAdd = AwardNamAdd;
    }

    public Award(ResultSet rs) throws SQLException {
        this.AwardsID = rs.getString("AwardsID");
        this.EventID  = rs.getString("EventID");
        this.AwardID = rs.getString("AwardID");
        this.TeamId = rs.getString("TeamId");
        this.RecieverNam = rs.getString("RecieverNam");
        this.AwardNamAdd = rs.getString("AwardNamAdd");
    }

    public Award(JSONObject json) {
        this.AwardsID = json.get("award_key").toString();
        this.AwardID = json.get("award_name").toString();
        this.TeamId = json.get("team_key").toString();
        this.RecieverNam = json.get("reciever_name").toString();
        this.AwardNamAdd = json.get("award_desc").toString();
    }

    public String getAwardsID() {
        return AwardsID;
    }

    public void setAwardsID(String awardsID) {
        AwardsID = awardsID;
    }

    public String getEventID() {
        return EventID;
    }

    public void setEventID(String eventID) {
        EventID = eventID;
    }

    public String getAwardID() {
        return AwardID;
    }

    public void setAwardID(String awardID) {
        AwardID = awardID;
    }

    public String getTeamId() {
        return TeamId;
    }

    public void setTeamId(String teamId) {
        TeamId = teamId;
    }

    public String getRecieverNam() {
        return RecieverNam;
    }

    public void setRecieverNam(String recieverNam) {
        RecieverNam = recieverNam;
    }

    public String getAwardNamAdd() {
        return AwardNamAdd;
    }

    public void setAwardNamAdd(String awardNamAdd) {
        AwardNamAdd = awardNamAdd;
    }
}
