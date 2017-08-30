package main.classes;

import org.json.simple.JSONObject;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by SPZ Productions on 8/13/2017.
 */
public class Alliance {

    private String AllianceID;
    private String EventID;
    private String TeamID;
    private String AllianceNum;
    private String AlliancePick;
    private String AllianceName;
    private String CardCarry;

    public Alliance(){
        this.AllianceID = "";
        this.EventID = "";
        this.TeamID = "";
        this.AllianceNum = "";
        this.AlliancePick = "";
        this.AllianceName = "";
        this.CardCarry = "";
    }

    public Alliance(String AllianceID, String EventID, String TeamID, String AllianceNum, String AlliancePick, String AllianceName, String CardCarry){
        this.AllianceID = AllianceID;
        this.EventID = EventID;
        this.TeamID = TeamID;
        this.AllianceNum = AllianceNum;
        this.AlliancePick = AlliancePick;
        this.AllianceName = AllianceName;
        this.CardCarry = CardCarry;
    }

    public Alliance(ResultSet rs) throws SQLException {
        this.AllianceID = rs.getString("AllianceID");
        this.EventID = rs.getString("EventID");
        this.TeamID = rs.getString("TeamID");
        this.AllianceNum = rs.getString("AllianceNum");
        this.AlliancePick = rs.getString("AlliancePick");
        this.AllianceName = rs.getString("AllianceName");
    }

    public Alliance(JSONObject json) {
        this.AllianceID = json.get("AllianceID").toString();
        this.EventID = json.get("EventID").toString();
        this.TeamID = json.get("TeamID").toString();
        this.AllianceNum = json.get("AllianceNum").toString();
        this.AlliancePick = json.get("AlliancePick").toString();
        this.AllianceName = json.get("AllianceName").toString();
        this.CardCarry = json.get("CardCarry").toString();
    }

    public String getAllianceID() {
        return AllianceID;
    }

    public void setAllianceID(String allianceID) {
        AllianceID = allianceID;
    }

    public String getEventID() {
        return EventID;
    }

    public void setEventID(String eventID) {
        EventID = eventID;
    }

    public String getTeamID() {
        return TeamID;
    }

    public void setTeamID(String teamID) {
        TeamID = teamID;
    }

    public String getAllianceNum() {
        return AllianceNum;
    }

    public void setAllianceNum(String allianceNum) {
        AllianceNum = allianceNum;
    }

    public String getAlliancePick() {
        return AlliancePick;
    }

    public void setAlliancePick(String alliancePick) {
        AlliancePick = alliancePick;
    }

    public String getAllianceName() {
        return AllianceName;
    }

    public void setAllianceName(String allianceName) {
        AllianceName = allianceName;
    }

    public String getCardCarry() {
        return CardCarry;
    }

    public void setCardCarry(String cardCarry) {
        CardCarry = cardCarry;
    }
}
