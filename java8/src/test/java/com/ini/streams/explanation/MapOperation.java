package com.ini.streams.explanation;

import java.util.stream.Stream;

import org.junit.Test;

public class MapOperation {

    @Test()
    public void map() {
        Stream.iterate(1, num -> num + 1).limit(10).filter(num -> num % 2 == 0).map(Object::toString)
                .forEach(System.out::println);
    }

}
