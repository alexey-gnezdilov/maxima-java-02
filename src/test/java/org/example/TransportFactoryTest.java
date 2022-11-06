package org.example;

import org.example.model.city.City;
import org.example.model.transport.Plane;
import org.example.model.transport.Ship;
import org.example.model.transport.Transport;
import org.example.model.transport.Truck;
import org.example.services.TransportFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class TransportFactoryTest {

    private Transport transport;
    private City city;

    //Ship creating tests
    @Test
    public void isTransportWithSpeedLessThan40AndCityOnWater(){
        city = new City("Igevsk", 50, false, true);
        transport = TransportFactory.getTransport(city, 5000, 35);
        assertTrue(transport instanceof Ship);
    }

    @Test
    public void isTransportWithSpeedEquals40AndCityOnWater(){
        city = new City("Irkutsk", 400, false, true);
        transport = TransportFactory.getTransport(city, 5000, 10);
        assertTrue(transport instanceof Ship);
    }

    //Plane creating tests
    @Test
    public void isTransportWithSpeedMoreThan120AndHasAirport(){
        city = new City("New_York", 5000, true, false);
        transport = TransportFactory.getTransport(city, 5000, 40);
        assertTrue(transport instanceof Plane);
    }

    @Test
    public void isTransportWithSpeedEquals120AndHasAirport(){
        city = new City("Novosibirsk", 960, true, false);
        transport = TransportFactory.getTransport(city, 5000, 8);
        assertTrue(transport instanceof Plane);
    }

    //Truck creating tests
    @Test
    public void isTransportWithSpeedLessThan40AndWithoutWater(){
        city = new City("Piter", 1350, true, false);
        transport = TransportFactory.getTransport(city, 5000, 50);
        assertTrue(transport instanceof Truck);
    }

    @Test
    public void isTransportWithSpeedEquals40AndWithoutWater(){
        city = new City("Ufa", 1480, false, false);
        transport = TransportFactory.getTransport(city, 5000, 37);
        assertTrue(transport instanceof Truck);
    }

    @Test
    public void isTransportWithSpeedMoreThan120AndWithoutAirport(){
        city = new City("Moskva", 4500, false, false);
        transport = TransportFactory.getTransport(city, 5000, 36);
        assertTrue(transport instanceof Truck);
    }

    @Test
    public void isTransportWithSpeedEquals120AndWithoutAirport(){
        city = new City("UAR", 360, false, false);
        transport = TransportFactory.getTransport(city, 5000, 3);
        assertTrue(transport instanceof Truck);
    }

    @Test
    public void isTransportWithSpeedBetween40And120(){
        city = new City("China", 2300, false, false);
        transport = TransportFactory.getTransport(city, 5000, 46);
        assertTrue(transport instanceof Truck);
    }

    //Transport creating negative tests
    @Test
    public void shouldNotBeShip() {
        city = new City("Poland", 4000, false, false);
        transport = TransportFactory.getTransport(city, 5000, 100);
        assertFalse(transport instanceof Ship);
    }

    @Test
    public void shouldNotBePlane() {
        city = new City("ULAN_UDE", 3380, false, false);
        transport = TransportFactory.getTransport(city, 5000, 26);
        assertFalse(transport instanceof Plane);
    }

    @Test
    public void shouldNotBeTruck() {
        city = new City("Izrael", 4000, false, true);
        transport = TransportFactory.getTransport(city, 5000, 100);
        assertFalse(transport instanceof Truck);
    }

    //Rounding tests
    @Test
    public void shouldRoundCapacity(){
        city = new City("Taiwan", 3500, true, true);
        transport = TransportFactory.getTransport(city, 700, 100);
        assertEquals(1000, transport.getCapacity());
    }

    @Test
    public void shouldNotRoundCapacity(){
        city = new City("Belgium", 3500, true, true);
        transport = TransportFactory.getTransport(city, 500, 100);
        assertEquals(500, transport.getCapacity());
    }

    @Test
    public void shouldRoundSpeed(){
        city = new City("USA", 5000, true, true);
        transport = TransportFactory.getTransport(city, 500, 24);
        assertEquals(210, transport.getSpeed());
    }

    @Test
    public void shouldNotRoundSpeed(){
        city = new City("Russia", 5000, true, true);
        transport = TransportFactory.getTransport(city, 500, 50);
        assertEquals(100, transport.getSpeed());
    }
}
