package org.example;

public class Plane extends Transport{
    public Plane(String name, int capacity, int speed, float costOfKm) {
        super(name, capacity, speed, costOfKm);
    }

    @Override
    public float getPrice(City city) {
        if (!city.hasAirport) {
            return 0;
        } else {
            float price = city.distanceKm * costOfKm;
            return price;
        }
    }
}
