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
    public void shouldGetSomeTransport(){
        assertNotNull(transport);
    }

    @Test
    public void shouldBeOnTime(){
        assertTrue(transport.getSpeed() > 50 / 24);
    }

    @Test
    public void shouldWeightSuitable(){
        assertFalse(transport.getCapacity() > 5000);
    }

    @Test
    public void shouldNotBeOnRepair(){
        assertFalse(transport.isRepairing());
    }

    @Test
    public void shouldCapacityBe500(){
        assertEquals(500, TransportFactory.roundCapacity(435));
    }

    @Test
    public void shouldSpeedBe90(){
        assertEquals(90, TransportFactory.roundSpeed(87));
    }
}
