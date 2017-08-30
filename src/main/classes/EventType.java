package main.classes;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created by SPZ Productions on 8/16/2017.
 */
public class EventType {
    private String EventTypeID;
    private String Description;
    private String CreatedBy;
    private String CreatedOn;
    private String ModifiedBy;
    private String ModifiedOn;

    public EventType(String EventTypeID, String Description, String CreatedBy, String CreatedOn, String ModifiedBy, String ModifiedOn){
        this.EventTypeID = EventTypeID;
        this.Description = Description;
        this.CreatedBy = CreatedBy;
        this.CreatedOn = CreatedOn;
        this.ModifiedBy = ModifiedBy;
        this.ModifiedOn = ModifiedOn;
    }

    public EventType(ResultSet rs) throws SQLException {
        this.EventTypeID = rs.getString("EventTypeID");
        this.Description = rs.getString("Description");
        this.CreatedBy = rs.getString("CreatedBy");
        this.CreatedOn = rs.getString("CreatedOn");
        this.ModifiedBy = rs.getString("ModifiedBy");
        this.ModifiedOn = rs.getString("ModifiedOn");
    }

    public EventType(){
        this.EventTypeID = "";
        this.Description = "";
        this.CreatedBy = "";
        this.CreatedOn = "";
        this.ModifiedBy = "";
        this.ModifiedOn = "";
    }

    public String getEventTypeID() {
        return EventTypeID;
    }

    public void setEventTypeID(String eventTypeID) {
        EventTypeID = eventTypeID;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
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
