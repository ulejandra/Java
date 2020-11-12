package com.ini.streams.explanation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MapOperation {

    private final static Logger log = LoggerFactory.getLogger(MapOperation.class);

    @Test()
    public void map() {
        Stream.iterate(1, num -> num + 1)
            .limit(10)
            .filter(num -> num % 2 == 0)
            .map(Object::toString)
                .forEach(log::info);
    }

    @Test()
    public void mapToLong() {
        List<String> list = Arrays.asList("25", "225", "22501", "2020", "1501");
        list
            .stream()
            .mapToLong(Long::parseLong)
                .filter(num -> num % 5 == 0)
                .forEach(num -> log.info("Long {}", num));
    }

    @Test()
    public void mapToInt() {
        List<String> list = Arrays.asList("3", "20", "12", "24", "50");

        list
            .stream()
                .mapToInt(Integer::parseInt)
            .filter(num -> num % 3 == 0)
                .forEach(num -> log.info("Int {}", num));
    }

    @Test()
    public void mapToDouble() {
        List<String> list = Arrays.asList("10.50", "6.548", "92.12", "3.1416", "15.24");

        list
            .stream()
            .mapToDouble(Double::parseDouble)
                .filter(num -> num * num * 2 > 450)
                .forEach(num -> log.info("Double {}", num));
    }

}
