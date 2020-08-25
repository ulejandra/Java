package com.ini.reference.method;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.junit.Test;

public class TestMethodReference {

    @Test
    public void testStaticMethod() {
        Predicate<Object> notNull = param -> Objects.nonNull(param);
        Predicate<Object> notNullM = Objects::nonNull;

        assertTrue(notNull.test(getClass()));
        assertFalse(notNull.test(null));

        assertTrue(notNullM.test(getClass()));
        assertFalse(notNullM.test(null));
    }

    @Test
    public void testStaticAttribute() {
        Consumer<String> print = str -> System.out.println(str);
        Consumer<String> printA = System.out::println;

        print.accept("Hola");
        printA.accept("Mundo");
    }

}
