package com.ini.interfaces.explanation.lambda.api.Consumer;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PersonTest {

    @Before
    public void ini() {
        Transport.TAXI.setUnAvailable();
    }

    @Test
    public void testWalking() {
        Person persona = new Person("Jose", 59.50);
        Transport myTransport = persona.getTransport();

        assertEquals(Transport.WALKING, myTransport);
    }

    @Test
    public void testTaxiTransport() {
        Transport.TAXI.setAvailable();

        Person persona = new Person("Jose", 59.50);
        Transport myTransport = persona.getTransport();

        assertEquals(Transport.TAXI, myTransport);
    }

    @Test
    public void testDoubleTransport() {
        Transport.TAXI.setAvailable();

        Person persona = new Person("Jose", 59.50);

        Transport myTransport = persona.getTransport();
        assertEquals(Transport.TAXI, myTransport);

        myTransport = persona.getTransport();
        assertEquals(Transport.WALKING, myTransport);
    }

}
