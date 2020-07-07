package com.ini.interfaces.explanation.lambda.api.Supplier;

import static org.junit.Assert.assertTrue;

import java.util.function.Supplier;

import org.junit.Test;

public class SupplierTest {

    @Test
    public void testString() {
        Supplier<String> greeting = () -> "Hello, how are you?";
        assertTrue(String.class.isInstance(greeting.get()));
    }

    @Test
    public void testPersona() {
        Supplier<Person> person = () -> new Person("Jose", 1_000_000);
        assertTrue(Person.class.isInstance(person.get()));
    }

}
