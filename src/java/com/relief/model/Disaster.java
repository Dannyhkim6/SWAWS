package com.relief.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Disaster {
    private int disasterID;
    private String disasterName;
    private String disasterType;
    private int disasterLoc;
    private String disasterDate;
//    private Timestamp disasterDate;
    private String description;
    private String severity;
    
        private String locationName;


    public Disaster(int disasterID, String disasterName, String disasterType, int disasterLoc, String disasterDate, String description, String severity) {
        this.disasterID = disasterID;
        this.disasterName = disasterName;
        this.disasterType = disasterType;
        this.disasterLoc = disasterLoc;
        this.disasterDate = disasterDate;
        this.description = description;
        this.severity = severity;
    }

    public int getDisasterID() { return disasterID; }
    public void setDisasterID(int disasterID) { this.disasterID = disasterID; }
    public String getDisasterName() { return disasterName; }
    public void setDisasterName(String disasterName) { this.disasterName = disasterName; }
    public String getDisasterType() { return disasterType; }
    public void setDisasterType(String disasterType) { this.disasterType = disasterType; }
    public int getDisasterLoc() { return disasterLoc; }
    public void setDisasterLoc(int disasterLoc) { this.disasterLoc = disasterLoc; }
    public String getDisasterDate() { return disasterDate; }
    public void setDisasterDate(String disasterDate) { this.disasterDate = disasterDate; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }
    
     public String getLocationName() {
        return locationName;
    }
     public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}