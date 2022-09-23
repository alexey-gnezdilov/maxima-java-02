package org.example;

public class App {
    public static void main(String[] args) {
        City irkutsk = new City("Irkuts", 250, true, true);

        Transport truck = new Truck("truck", 500, 120, 50.0f);
        Transport plane = new Plane("plane", 1000, 500, 10.0f);
        Transport ship = new Ship("ship", 2000, 240, 500.0f);

        Logistics log = new Logistics(truck, plane, ship);
        System.out.println(log.getShipping(irkutsk, 2000, 24));
    }
}
