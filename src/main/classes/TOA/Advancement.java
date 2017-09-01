package main.classes.TOA;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by SPZ Productions on 8/13/2017.
 */
public class Advancement {

    private String AdvancementsID;
    private String EventID;
    private String AdvancementID;
    private String TeamID;
    private String ReasonSkip;

    public Advancement(){
        this.AdvancementsID = "";
        this.EventID = "";
        this.AdvancementID = "";
        this.TeamID = "";
        this.ReasonSkip = "";
    }

    public Advancement(String AdvancementsID, String EventID, String AdvancementID, String TeamID, String ReasonSkip){
        this.AdvancementsID = AdvancementsID;
        this.EventID = EventID;
        this.AdvancementID = AdvancementID;
        this.TeamID = TeamID;
        this.ReasonSkip = ReasonSkip;
    }

    public Advancement(ResultSet rs) throws SQLException {
        this.AdvancementsID = rs.getString("AdvancementsID");
        this.EventID = rs.getString("EventID");
        this.AdvancementID = rs.getString("AdvancementID");
        this.TeamID = rs.getString("TeamID");
        this.ReasonSkip = rs.getString("ReasonSkip");
    }

    public String getAdvancementsID() {
        return AdvancementsID;
    }

    public void setAdvancementsID(String advancementsID) {
        AdvancementsID = advancementsID;
    }

    public String getEventID() {
        return EventID;
    }

    public void setEventID(String eventID) {
        EventID = eventID;
    }

    public String getAdvancementID() {
        return AdvancementID;
    }

    public void setAdvancementID(String advancementID) {
        AdvancementID = advancementID;
    }

    public String getTeamID() {
        return TeamID;
    }

    public void setTeamID(String teamID) {
        TeamID = teamID;
    }

    public String getReasonSkip() {
        return ReasonSkip;
    }

    public void setReasonSkip(String reasonSkip) {
        ReasonSkip = reasonSkip;
    }
}
