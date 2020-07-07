package com.ini.interfaces.explanation.lambda.api.Supplier;

import static org.junit.Assert.assertEquals;

import java.util.function.Supplier;

import org.junit.Test;

public class TransportTest {

    @Test
    public void testUber() {
        Person persona = new Person("Jose", 100);
        Transport myTransport = Transport.getTransport(persona.getMoney());
        Integer timeExpected = 5;

        assertEquals(timeExpected, myTransport.get());
    }

    @Test
    public void testTaxi() {
        Person persona = new Person("Maoly", 45);
        Supplier<Integer> myTransport = Transport.getTransport(persona.getMoney());
        Integer timeExpected = 7;

        assertEquals(timeExpected, myTransport.get());
    }

    @Test
    public void testSubway() {
        Person persona = new Person("Hector", 25);
        Transport myTransport = Transport.getTransport(persona.getMoney());

        assertEquals(Transport.SUBWAY, myTransport);
    }

    @Test
    public void testWalking() {
        Person persona = new Person("Ale", 0);
        Integer myTime = Transport.getTransport(persona.getMoney()).get();
        Integer timeExpected = 40;

        assertEquals(timeExpected, myTime);
    }

}
