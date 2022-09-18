package org.example;

public class Ship extends Transport{
    public Ship(String name, int capacity, int speed, float costOfKm) {
        super(name, capacity, speed, costOfKm);
    }

    @Override
    public float getPrice(City city) {
        if (!city.isOnWater) {
            return 0;
        } else {
            float price = city.distanceKm * costOfKm;
            return price;
        }
    }
}
