package com.ini.streams.explanation;

import static org.junit.Assert.assertEquals;

import java.util.stream.Stream;

import org.junit.Test;

public class MidOperation {

    @Test()
    public void filter() {
        long count = Stream.iterate(1, num -> num + 1).limit(10).filter(num -> num % 2 == 0).count();
        assertEquals(5, count);
    }

}
