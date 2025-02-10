package com.relief.model;

import java.sql.Timestamp;

public class ReliefResource {

    private int resourceId;
    private String resourceName;
    private String resourceType;
    private String resourceStatus;
    private int locationId;
    private int resourceQty;
    private Timestamp lastUpdated;

    public ReliefResource(int resourceId, String resourceName, String resourceType, 
                          String resourceStatus, int locationId, int resourceQty, Timestamp lastUpdated) {
        this.resourceId = resourceId;
        this.resourceName = resourceName;
        this.resourceType = resourceType;
        this.resourceStatus = resourceStatus;
        this.locationId = locationId;
        this.resourceQty = resourceQty;
        this.lastUpdated = lastUpdated;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getResourceStatus() {
        return resourceStatus;
    }

    public void setResourceStatus(String resourceStatus) {
        this.resourceStatus = resourceStatus;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public int getResourceQty() {
        return resourceQty;
    }

    public void setResourceQty(int resourceQty) { 
        this.resourceQty = resourceQty;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
