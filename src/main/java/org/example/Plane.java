package org.example;

public class Plane extends Transport{

    public Plane(String name, int capacity, int speed, float costOfKm) {
        super(name, capacity, speed, costOfKm);
    }

    @Override
    public float getPrice(City city) {
        return !city.hasAirport() ? 0 : (float) city.getDistanceKm() * getCostOfKm();
    }
}
