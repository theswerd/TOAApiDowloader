package main.classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by SPZ Productions on 8/17/2017.
 */
public class EventParticipant {

    private String EventParticipantID;
    private String EventID;
    private String TeamID;
    private String IsActive;
    private String CardCarryQualifacation;
    private String WasAddedFromUI;
    private String CreatedBy;
    private String CreatedOn;
    private String ModifiedBy;
    private String ModifiedOn;

    public EventParticipant(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8){
        this.EventParticipantID = "";
        this.EventID = "";
        this.TeamID = "";
        this.IsActive = "";
        this.CardCarryQualifacation = "";
        this.WasAddedFromUI = "";
        this.CreatedBy = "";
        this.CreatedOn = "";
        this.ModifiedBy = "";
        this.ModifiedOn = "";
    }

    public EventParticipant(String EventParticipantID, String EventID, String TeamID, String IsActive, String CardCarryQualifacation, String WasAddedFromUI, String CreatedBy, String CreatedOn, String ModifiedBy, String ModifiedOn){
        this.EventParticipantID = EventParticipantID;
        this.EventID = EventID;
        this.TeamID = TeamID;
        this.IsActive = IsActive;
        this.CardCarryQualifacation = CardCarryQualifacation;
        this.WasAddedFromUI = WasAddedFromUI;
        this.CreatedBy = CreatedBy;
        this.CreatedOn = CreatedOn;
        this.ModifiedBy = ModifiedBy;
        this.ModifiedOn = ModifiedOn;
    }

    public EventParticipant(ResultSet rs) throws SQLException {
        this.EventParticipantID = rs.getString("EventParticipantID");
        this.EventID = rs.getString("EventID");
        this.TeamID = rs.getString("TeamID");
        this.IsActive = rs.getString("IsActive");
        this.CardCarryQualifacation = rs.getString("CardCarryQualification");
        this.WasAddedFromUI = rs.getString("WasAddedFromUI");
        this.CreatedBy = rs.getString("CreatedBy");
        this.CreatedOn = rs.getString("CreatedOn");
        this.ModifiedBy = rs.getString("ModifiedBy");
        this.ModifiedOn = rs.getString("ModifiedOn");
    }

    public String getEventParticipantID() {
        return EventParticipantID;
    }

    public void setEventParticipantID(String eventParticipantID) {
        EventParticipantID = eventParticipantID;
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

    public String getIsActive() {
        return IsActive;
    }

    public void setIsActive(String isActive) {
        IsActive = isActive;
    }

    public String getCardCarryQualifacation() {
        return CardCarryQualifacation;
    }

    public void setCardCarryQualifacation(String cardCarryQualifacation) {
        CardCarryQualifacation = cardCarryQualifacation;
    }

    public String getWasAddedFromUI() {
        return WasAddedFromUI;
    }

    public void setWasAddedFromUI(String wasAddedFromUI) {
        WasAddedFromUI = wasAddedFromUI;
    }

    public String getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(String createdBy) {
        CreatedBy = createdBy;
    }

    public String getCreatedOn() {
        return CreatedOn;
    }

    public void setCreatedOn(String createdOn) {
        CreatedOn = createdOn;
    }

    public String getModifiedBy() {
        return ModifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        ModifiedBy = modifiedBy;
    }

    public String getModifiedOn() {
        return ModifiedOn;
    }

    public void setModifiedOn(String modifiedOn) {
        ModifiedOn = modifiedOn;
    }
}
