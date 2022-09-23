package org.example;

public class Logistics {

    //свойство - все транспортные средства
    private Transport[] vehicles;

    //свойство - доступные ТС для данного заказа
    private Transport[] availableVehicles;

    //свойство - все цены (не равные нулю) на один город
    private float[] allPrices;

    //Конструктор, принимающий произвольное число паарметров (транспортные средства)
    public Logistics(Transport... transports) {

        vehicles = new Transport[transports.length];
        availableVehicles = new Transport[transports.length];
        allPrices = new float[transports.length];

        for (int i = 0; i < vehicles.length; i++) {

            String name = transports[i].getName();
            int capacity = transports[i].getCapacity();
            int speed = transports[i].getSpeed();
            float costOfKm = transports[i].getCostOfKm();

            switch (transports[i].getClass().getSimpleName()) {
                case "Plane":
                    vehicles[i] = new Plane(name, capacity, speed, costOfKm);
                    break;
                case "Ship":
                    vehicles[i] = new Ship(name, capacity, speed, costOfKm);
                    break;
                case "Truck":
                    vehicles[i] = new Truck(name, capacity, speed, costOfKm);
                    break;
            }
        }
    }


    //Получить самое оптимальное по стоимости доставки транспортное средство
    public Transport getShipping(City city, int weight, int hours) {
        countAllPrices(city, weight, hours);
        if (areAllPricesZero(sumAllPrices())) {
            return null;
        }
        return availableVehicles[getMinPrice()];
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
        return (float) city.getDistanceKm() / transport.getSpeed() <= (float) hours;
    }

    //Посчитать все цены
    public void countAllPrices(City city, int weight, int hours) {
        for (int i = 0, j = 0; i < vehicles.length; i++) {
            if (isShippingAvailable(city, vehicles[i], weight, hours)) {
                allPrices[j] = vehicles[i].getPrice(city);
                availableVehicles[j] = vehicles[i];
                j++;
            }
        }
    }

    //Просуммировать все цены
    public float sumAllPrices() {
        float sum = 0;
        for (float allPrice : allPrices) {
            sum += allPrice;
        }
        return sum;
    }

    //Проверить - не равны ли "0" все цены
    public boolean areAllPricesZero(float sum) {
        return sum == 0;
    }

    //Найти минимальную цену (получить индекс минимальной цены)
    public int getMinPrice() {
        float min = allPrices[0];
        int minIndex = 0;
        for (int i = 1; i < allPrices.length; i++) {
            if (allPrices[i] != 0 && allPrices[i] < min) {
                minIndex = i;
            }
        }
        return minIndex;
    }
}




