package org.example;

public class City {
    String name;
    int distanceKm;

    public City(String name, int distanceKm) {
        this.name = name;
        this.distanceKm = distanceKm;
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
