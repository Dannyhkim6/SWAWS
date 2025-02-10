package com.relief.model;

import java.sql.Timestamp;

public class Request {

    private int requestId;
    private int resourceId;
    private int requestQty;
    private Timestamp requestDate;
    private String requestStatus;
    private String priority;
    private String name;
    private String email;
    private String phonenum;
    private int locationId; 

    public Request(int requestId, int resourceId, int requestQty, 
                   Timestamp requestDate, String requestStatus, String priority, 
                   String name, String email, String phonenum, int locationId) {
        this.requestId = requestId;
        this.resourceId = resourceId;
        this.requestQty = requestQty;
        this.requestDate = requestDate;
        this.requestStatus = requestStatus;
        this.priority = priority;
        this.name = name;
        this.email = email;
        this.phonenum = phonenum;
        this.locationId = locationId;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public int getRequestQty() {
        return requestQty;
    }

    public void setRequestQty(int requestQty) {
        this.requestQty = requestQty;
    }

    public Timestamp getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Timestamp requestDate) {
        this.requestDate = requestDate;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }
    
    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }
}
