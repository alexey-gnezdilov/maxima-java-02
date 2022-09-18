package org.example;

public class City {
    String name;
    int distanceKm;
    boolean hasAirport;
    boolean isOnWater;

    public City(String name, int distanceKm, boolean hasAirport, boolean isOnWater) {
        this.name = name;
        this.distanceKm = distanceKm;
        this.hasAirport = hasAirport;
        this.isOnWater = isOnWater;
    }

    public City(String name, int distanceKm) {
        this.name = name;
        this.distanceKm = distanceKm;
        this.hasAirport = false;
        this.isOnWater = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistanceKm() {
        return distanceKm;
    }

    public void setDistanceKm(int distanceKm) {
        this.distanceKm = distanceKm;
    }
}
