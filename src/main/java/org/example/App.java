package org.example;

public class App {
    public static void main(String[] args) {
        City irkutsk = new City("Irkutsk", 250, true, false);
        System.out.println(TransportFactory.getTransport(irkutsk, 425, 64));
    }

}
