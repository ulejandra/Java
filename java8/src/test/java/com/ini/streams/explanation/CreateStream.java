package com.ini.streams.explanation;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.Test;

public class CreateStream {

    @Test
    public void forEachFromAsList() {
        Arrays.asList(1, 2, 3, 4, 5).forEach(System.out::println);
    }

    @Test
    public void iterateLimit() {
        Stream.iterate(1, num -> num + 1).limit(10).forEach(System.out::println);
    }

    @Test
    public void streamOf() {
        Stream.of(1, 2, 3, 4, 5).forEach(System.out::println);
    }

    @Test
    public void generate() {
        Stream.generate(Person::new).limit(10).forEach(System.out::println);
    }

}
