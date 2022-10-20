package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TransportFactoryTest {

    private Transport transport;
    private City city;

    @Test
    public void isShip(){
        city = new City("Irkutsk", 50, false, true);
        transport = TransportFactory.getTransport(city, 5000, 35);
        assertTrue(transport instanceof Ship);
    }

    @Test
    public void isPlane(){
        city = new City("Novosibirsk", 5000, true, false);
        transport = TransportFactory.getTransport(city, 5000, 40);
        assertTrue(transport instanceof Plane);
    }

    @Test
    public void isTruck(){
        city = new City("Moskva", 5000, true, true);
        transport = TransportFactory.getTransport(city, 5000, 100);
        assertTrue(transport instanceof Truck);
    }

    @Test
    public void isCapacityRoundCorrectly(){
        city = new City("Moskva", 5000, true, true);
        transport = TransportFactory.getTransport(city, 500, 100);
        assertEquals(500, transport.getCapacity());
    }

    @Test
    public void isSpeedRoundCorrectly(){
        city = new City("Moskva", 5000, true, true);
        transport = TransportFactory.getTransport(city, 500, 24);
        assertEquals(210, transport.getSpeed());
    }
}
