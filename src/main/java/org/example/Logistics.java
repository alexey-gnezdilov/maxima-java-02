package org.example;

public class Logistics {

    //свойство - все транспортные средства
    private Transport[] vehicles;

    //Конструктор, принимающий произвольное число паарметров (транспортные средства)
    public Logistics(Transport... transports) {
        vehicles = new Transport[transports.length];
        for (int i = 0; i < vehicles.length; i++) {
            vehicles[i] = transports[i];
        }
    }

    //Получить самое оптимальное по стоимости доставки транспортное средство
    public Transport getShipping(City city, int weight, int hours) {
        Transport minCostTransport = null;
        for (Transport vehicle : vehicles) {
            if (isShippingAvailable(city, vehicle, weight, hours)) {
                if (minCostTransport == null) {
                    minCostTransport = vehicle;
                } else if (vehicle.getCostOfKm() < minCostTransport.getCostOfKm()) {
                    minCostTransport = vehicle;
                }
            }
        }
        return minCostTransport;
    }

    //Проверка - доступна ли доставка для транспорта в указанный город
    private boolean isShippingAvailable(City city, Transport transport, int weight, int hours) {
        return !transport.isRepairing()
                && transport.isCityAvailable(city)
                && transport.getCapacity() >= weight
                && (float) city.getDistanceKm() / transport.getSpeed() <= (float) hours;
    }
}