package org.example.services;

import org.example.model.city.City;
import org.example.model.transport.Plane;
import org.example.model.transport.Ship;
import org.example.model.transport.Transport;
import org.example.model.transport.Truck;

public class TransportFactory {

    //Конструктор по умолчанию
    public TransportFactory(){}

    public static Transport getTransport(City city, int weight, int hours) {

        String[] names = {"Plane", "Ship", "Truck"};
        int capacity = roundCapacity(weight);
        int speed = roundSpeed(city.getDistanceKm() / hours);
        float cost = randomCost();

        if (speed >= 120 && city.hasAirport()) {
            return new Plane(names[0], capacity, speed, cost);
        } else if (speed <= 40 && city.isOnWater()) {
            return new Ship(names[1], capacity, speed, cost);
        } else {
            return new Truck(names[2], capacity, speed, cost);
        }
    }

    //Округление грузоподъёмности
    private static int roundCapacity(int capacity) {
        return capacity % 500 == 0 ? capacity : capacity - capacity % 500 + (capacity % 500 == 0 ? 0 : 500);
    }
    //Округление скорости
    private static int roundSpeed(int speed) {
        return speed % 10 == 0 ? speed : speed - speed % 10 + (speed % 45 == 0 ? 0 : 10);
    }

    //Генерация случайной стоимости
    private static float randomCost() {
        return (float) Math.random() * 100;
    }

    //метод-пустышка
    public void sayHelloFactory() {
        System.out.println("Hello Factory");
    }
}