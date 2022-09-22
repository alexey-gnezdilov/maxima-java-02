package org.example;

public class Logistics {

    //свойство - транспортные средства
    private Transport[] vehicles;

    //Конструктор, принимающий произвольное число паарметров (транспортные средства)
    public Logistics(Transport... transports) {

        vehicles = new Transport[transports.length];

        for (int i = 0; i < vehicles.length; i++) {
            String name = transports[i].getName();
            int capacity = transports[i].getCapacity();
            int speed = transports[i].getSpeed();
            float costOfKm = transports[i].getCostOfKm();

            if (transports[i].getClass().getSimpleName().equals("Plane")) {
                vehicles[i] = new Plane(name, capacity, speed, costOfKm);
            } else if (transports[i].getClass().getSimpleName().equals("Ship")) {
                vehicles[i] = new Ship(name, capacity, speed, costOfKm);
            } else if (transports[i].getClass().getSimpleName().equals("Truck")) {
                vehicles[i] = new Truck(name, capacity, speed, costOfKm);
            }
        }
    }


    //Получить самое оптимальное по стоимости доставки транспортное средство
    public Transport getShipping(City city, int weight, int hours) {
        return vehicles[getMinPrice(getAllAvailablePrices(city, weight, hours))];
    }

    //Проверка - доступна ли доставка для транспорта в указанный город
    public boolean isShippingAvailable(City city, Transport transport, int weight, int hours) {
        return !transport.isRepairing()
                && isCityAvailable(city, transport)
                && isCapacityEnough(transport, weight)
                && isTimeEnough(city, transport, hours);
    }

    //Проверка - доступен ли данный транспорт в данном городе
    public boolean isCityAvailable(City city, Transport transport) {
        if (transport.getClass().getSimpleName().equals("Truck")) {
            return true;
        }
        if (transport.getClass().getSimpleName().equals("Plane")) {
            return city.hasAirport();
        }
        if (transport.getClass().getSimpleName().equals("Ship")) {
            return city.isOnWater();
        }
        return false;
    }

    //Проверка - достаточно ли грузоподъёмности у данного транспорта
    public boolean isCapacityEnough(Transport transport, int weight) {
        return transport.getCapacity() >= weight;
    }

    //Проверка - успеет ли данный транспорт в данный город
    public boolean isTimeEnough(City city, Transport transport, int hours) {
        return (float) (city.getDistanceKm() / transport.getSpeed()) <= (float) hours;
    }

    //Получить все цены у доступных транспортов
    public float[] getAllAvailablePrices(City city, int weight, int hours) {
        float[] allAvailablePrices = new float[vehicles.length];
        for (int i = 0; i < vehicles.length; i++) {
            if (isShippingAvailable(city, vehicles[i], weight, hours)) {
                allAvailablePrices[i] = vehicles[i].getPrice(city);
            } else {
                allAvailablePrices[i] = 0;
            }
        }
        return allAvailablePrices;
    }

    //Получить минимальную цену (индекс минимальной цены)
    public int getMinPrice(float[] allAvailablePrices) {
        int indexOfMin = 0;
        for (int i = 1; i < allAvailablePrices.length; i++) {
            if (allAvailablePrices[i] < allAvailablePrices[indexOfMin]) {
                indexOfMin = i;
            }
        }
        return indexOfMin;
    }
}