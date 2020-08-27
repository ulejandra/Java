package com.ini.reference.method;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

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

    @Test
    public void testObjectMethod() {
        Predicate<String> isEmpty = str -> str == null || str.isEmpty();
        Predicate<String> isEmpty2 = Objects::isNull;
        Predicate<String> isEmpty3 = isEmpty2.or(String::isEmpty);

        assertFalse(isEmpty.test("Hector"));
        assertTrue(isEmpty.test(""));

        assertTrue(isEmpty.test(null));

        assertFalse(isEmpty3.test("Hector"));
        assertTrue(isEmpty3.test(""));
        assertTrue(isEmpty3.test(null));
    }

    @Test
    public void testObjectMethod2() {
        BiPredicate<String, String> objContains = (str1, str2) -> str1.contains(str2);
        BiPredicate<String, String> objContains2 = String::contains;

        assertTrue(objContains.test("HOLA", "OLA"));
        assertFalse(objContains.test("HOLA", "Maoly"));

        assertTrue(objContains2.test("HOLA", "OLA"));
        assertFalse(objContains2.test("HOLA", "Maoly"));
    }

    @Test
    public void testNewObject() {
        Supplier<Person> person = () -> new Person();
        Supplier<Person> person2 = Person::new;

        assertTrue(Person.class.isInstance(person.get()));
        assertTrue(Person.class.isInstance(person2.get()));

        Function<String, Person> function = name -> new Person(name);
        Function<String, Person> function2 = Person::new;

        assertTrue(Person.class.isInstance(function.apply("Jose")));
        assertTrue(Person.class.isInstance(function2.apply("Jose")));

        BiFunction<String, Integer, Person> function3 = (name, age) -> new Person(name, age);
        BiFunction<String, Integer, Person> function31 = Person::new;

        assertTrue(Person.class.isInstance(function3.apply("Hector", 30)));
        assertTrue(Person.class.isInstance(function31.apply("Hector", 30)));

    }
}
