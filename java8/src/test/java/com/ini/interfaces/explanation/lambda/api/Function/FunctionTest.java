package com.ini.interfaces.explanation.lambda.api.Function;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.function.Function;

import org.junit.Test;

public class FunctionTest {

    @Test
    public void testApply() {
        Function<Person, Transport> myTransport = person -> person.getTransport();

        assertTrue(Transport.class.isInstance(myTransport.apply(new Person("Jose", 1_000.0))));
    }

    @Test
    public void testAndThen() {
        Function<Person, Transport> myTransport1 = person -> person.getTransport();
        Function<Transport, String> myCost1 = transport -> "my transport cost " + transport.getCost();
        String myData = myCost1.apply(myTransport1.apply(new Person("Jose", 1_000.0)));

        Function<Person, Transport> myTransport2 = person -> person.getTransport();
        Function<Person, String> myCost2 =
                myTransport2
                .andThen(transport -> transport.getCost())
                .andThen(cost -> "my transport cost " + cost);

        assertEquals(myData, myCost2.apply(new Person("Jose", 1_000.0)));
    }

    @Test
    public void testCompose() {
        Function<Person, Transport> myTransport = person -> person.getTransport();
        Function<String, Transport> myPerson = myTransport.compose(name -> new Person(name, 0.0));

        assertTrue(Transport.class.isInstance(myPerson.apply("Jose")));
    }

    @Test
    public void testIdentity() {
        Function<String, String> myName = Function.identity();

        assertEquals("Jose", myName.apply("Jose"));
    }

    @Test
    public void testComplexExample1() {
        Function<Person, Person> identity = Function.identity();
        Function<String, Person> compose = identity.compose(name -> new Person(name, 1000.0));
        Function<String, Double> andThen = compose.andThen(person -> person.getMoney());
        Function<String, String> myMoney1 = andThen.andThen(money -> "I have " + money + " pesos.");

        Function<String, String> myMoney2 =
                Function.<Person>identity()
                .<String>compose(name -> new Person(name, 1_000.0))
                .andThen(person -> person.getMoney())
                .andThen(money -> "I have " + money + " pesos.");

        assertEquals(myMoney1.apply("Jose"), myMoney2.apply("Jose"));
    }

}
