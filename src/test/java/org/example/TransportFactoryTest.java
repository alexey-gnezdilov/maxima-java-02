package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TransportFactoryTest {

    private Transport transport;

    @Before
    public void prepare(){
        transport = TransportFactory.getTransport(
                new City("Irkutsk", 50, true, true),
                5000,
                24);
    }

    @Test
    public void shouldBePlane(){
        assertTrue(transport instanceof Plane);
    }

    @Test
    public void shouldBeShip(){
        assertTrue(transport instanceof Ship);
    }

    @Test
    public void shouldBeTruck(){
        assertTrue(transport instanceof Truck);
    }
}
