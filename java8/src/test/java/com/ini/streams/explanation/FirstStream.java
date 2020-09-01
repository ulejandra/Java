package com.ini.streams.explanation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.Test;

public class FirstStream {

    @Test()
    public void forEachFromAsList() {
        Arrays.asList(1, 2, 3, 4, 5).forEach(System.out::println);
    }

    @Test()
    public void iterateLimit() {
        Stream.iterate(1, num -> num + 1).limit(10).forEach(System.out::println);
    }

    @Test()
    public void streamOf() {
        Stream.of(1, 2, 3, 4, 5).forEach(System.out::println);
    }

    @Test()
    public void count() {
        long count = Stream.of(1, 2, 3, 4, 5).count();
        assertEquals(5, count);
    }

    @Test()
    public void filter() {
        long count = Stream.iterate(1, num -> num + 1).limit(10).filter(num -> num % 2 == 0).count();
        assertEquals(5, count);
    }

    @Test()
    public void map() {
        Stream.iterate(1, num -> num + 1).limit(10).filter(num -> num % 2 == 0).map(Object::toString)
                .forEach(System.out::println);
    }

    @Test()
    public void max() {
        Optional<String> optMax = Stream.iterate(1, num -> num + 1).limit(10).map(
                Object::toString)
                .max(Comparator.naturalOrder());

        assertEquals("9", optMax.get());
    }

    @Test()
    public void maxError() {
        Optional<Integer> optMax = Stream.of(1).filter(num -> num % 2 == 0).max(Comparator.naturalOrder());

        assertFalse(optMax.isPresent());
        assertThrows(NullPointerException.class, () -> optMax.orElseThrow(NullPointerException::new));

    }

    @Test()
    public void min() {
        Optional<String> optMin = Stream.iterate(2, num -> num + 1).limit(10).map(Object::toString)
                .min(Comparator.naturalOrder());

        assertEquals("10", optMin.get());
    }

}
