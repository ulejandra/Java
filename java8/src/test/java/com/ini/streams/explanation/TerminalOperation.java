package com.ini.streams.explanation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TerminalOperation {

    private static final Logger LOG = LoggerFactory.getLogger(TerminalOperation.class);

    @Test
    public void count() {
        long count = Stream.of(1, 2, 3, 4, 5).count();
        assertEquals(5, count);
    }

    @Test
    public void max() {
        Optional<String> optMax = Stream.iterate(1, num -> num + 1).limit(10)
                .map(Object::toString)
                .max(Comparator.naturalOrder());

        assertEquals("9", optMax.get());
    }

    @Test
    public void maxError() {
        Optional<Integer> optMax = Stream.of(1).filter(num -> num % 2 == 0).max(Comparator.naturalOrder());

        assertFalse(optMax.isPresent());
        assertThrows(NullPointerException.class, () -> optMax.orElseThrow(NullPointerException::new));

    }

    @Test
    public void min() {
        Optional<String> optMin = Stream.iterate(2, num -> num + 1).limit(10).map(Object::toString)
                .min(Comparator.naturalOrder());

        assertEquals("10", optMin.get());
    }

    @Test
    public void forEachOrdered() {
        String without = "without:: ";
        String with = "with:: ";
        
        Stream.iterate(2, num -> ++num)
        .limit(100)
        .parallel()
        .map(Object::toString)
        .map(without::concat)
        .forEach(LOG::info);

        Stream.iterate(2, num -> ++num)
        .limit(100)
        .parallel()
        .map(Object::toString)
        .map(with::concat)
        .forEachOrdered(LOG::info);
    }

    @Test
    public void collector() {
        List<Integer> nums = Stream.iterate(1, num -> ++num).limit(10).collect(Collectors.toList());
        assertEquals(10, nums.size());
    }

    @Test
    public void collectJoining() {
        String string = Stream.iterate(1, num -> ++num).limit(10).map(Object::toString)
                .parallel()
                .collect(Collectors.joining(", "));
        LOG.info(string);
    }

    @Test
    public void collectToCollection() {
        Set<Integer> setValues = Stream.iterate(1, num -> ++num).limit(10).parallel().map(num -> num % 2)
                .collect(Collectors.toCollection(HashSet::new));

        assertEquals(2, setValues.size());
    }
}
