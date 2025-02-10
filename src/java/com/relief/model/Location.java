package com.relief.model;

public class Location {
    private int locationID;
    private String locationName;
    private String coordinate; 
    private int population;
    private String reliefCenter; 

    // Constructor
    public Location(int locationID, String locationName, String coordinate, int population, String reliefCenter) {
        this.locationID = locationID;
        this.locationName = locationName;
        this.coordinate = coordinate;
        this.population = population;
        this.reliefCenter = reliefCenter;
    }

    // Getters and Setters
    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getReliefCenter() {
        return reliefCenter;
    }

    public void setReliefCenter(String reliefCenter) {
        this.reliefCenter = reliefCenter;
    }
}