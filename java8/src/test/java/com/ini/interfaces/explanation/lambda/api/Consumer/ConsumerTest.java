package com.ini.interfaces.explanation.lambda.api.Consumer;

import static org.junit.Assert.assertEquals;

import java.util.function.Consumer;

import org.junit.Test;

public class ConsumerTest {
    private String greeting = "Hello ";
    private String bye = "Bye ";

    @Test
    public void testAccept() {
        Consumer<String> myConsumer = name -> greeting = greeting + name;
        myConsumer.accept("Jose");
        assertEquals("Hello Jose", greeting);
    }

    @Test
    public void testAndThen() {
        Consumer<String> myConsumer = name -> greeting = greeting + name;
        myConsumer.andThen(name -> bye = bye + name).accept("Maoly");
        assertEquals("Hello Maoly", greeting);
        assertEquals("Bye Maoly", bye);
    }

}
