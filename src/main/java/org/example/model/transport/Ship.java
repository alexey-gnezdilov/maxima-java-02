package org.example.model.transport;

import org.example.model.city.City;

public class Ship extends Transport{

    public Ship(String name, int capacity, int speed, float costOfKm) {
        super(name, capacity, speed, costOfKm);
    }

    @Override
    public float getPrice(City city) {
        return city.isOnWater() ? city.getDistanceKm() * getCostOfKm() : 0;
    }
}