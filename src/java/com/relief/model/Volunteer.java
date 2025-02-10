package com.relief.model;

public class Volunteer {

    private int volunteerID;
    private String name;
    private String nric; 
    private String email;
    private String phoneNum;
    private String areaOfInterest;
    private String reason;
    private String status;
    private String gender; 

    public Volunteer(int volunteerID, String name, String nric, String email, String phoneNum, String areaOfInterest, String reason, String status, String gender) {
        this.volunteerID = volunteerID;
        this.name = name;
        this.nric = nric;
        this.email = email;
        this.phoneNum = phoneNum;
        this.areaOfInterest = areaOfInterest;
        this.reason = reason;
        this.status = status;
        this.gender = gender;
    }

    public int getVolunteerID() {
        return volunteerID;
    }

    public void setVolunteerID(int volunteerID) {
        this.volunteerID = volunteerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNric() {
        return nric;
    }

    public void setNric(String nric) {
        this.nric = nric;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getAreaOfInterest() {
        return areaOfInterest;
    }

    public void setAreaOfInterest(String areaOfInterest) {
        this.areaOfInterest = areaOfInterest;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}