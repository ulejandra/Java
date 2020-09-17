package com.ini.streams.explanation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.stream.Stream;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MidOperation {
    private static final Logger LOG = LoggerFactory.getLogger(MidOperation.class);

    @Test
    public void limit() {
        long count = Stream.iterate(1, num -> num + 1).limit(5).count();
        assertEquals(5, count);
    }

    @Test
    public void filter() {
        long count = Stream.iterate(1, num -> num + 1).limit(10).filter(num -> num % 2 == 0).count();
        assertEquals(5, count);
    }

    @Test
    public void skipBefore() {
        long count = Stream.iterate(1, num -> num + 1).skip(5).limit(8).count();
        assertEquals(8, count);
    }

    @Test
    public void skipAfter() {
        long count = Stream.iterate(1, num -> num + 1).limit(8).skip(5).count();
        assertEquals(3, count);
    }

    @Test
    public void peek() {
        long count = Stream.iterate(1, num -> num + 1).skip(5).limit(8).map(Object::toString).peek(LOG::info).count();
        assertEquals(8, count);
    }

    @Test
    public void onClose() {
        Stream<Integer> strmInteger = Stream.iterate(1, num -> num + 1).limit(5).onClose(() -> LOG.info("Bye OnClose"));
        assertEquals(5, strmInteger.count());
        strmInteger.close();
        assertThrows(IllegalStateException.class, () -> strmInteger.count());
    }

    @Test
    public void parallel() {
        Stream.iterate(1, num -> num + 1).parallel().limit(15).forEach(num -> LOG.info("parallel num = " + num));
    }

    @Test
    public void sortedNum() {
        Stream.of(4, 500, 2, 5, 0, 1, 11, 34, 6).sorted().map(
                Object::toString)
                .forEach(num -> LOG.info("sorted num = " + num));
    }

    @Test
    public void sortedComparableClass() {
        Stream.of(4, 500, 2, 5, 0, 1, 11, 34, 6).map(Object::toString)
                .sorted()
                .forEach(num -> LOG.info("sorted str = " + num));
    }

    @Test
    public void sortedNotComparableClass() {
        assertThrows(ClassCastException.class,
                () -> Stream.generate(Person::new).limit(5).sorted().forEach(num -> LOG.info("bad sorted = " + num)));
    }

    @Test
    public void sortedComparator() {
        Stream.generate(Person::new).limit(5).sorted((per1, per2) -> per1.getId()
                - per2.getId())
                .forEach(person -> LOG.info("comparator id = " + person.getId()));
    }

    @Test
    public void sortedComparatorEnumByAllFields() {
        Stream.generate(Person::new).limit(20)
        .sorted(PersonComparators.BY_ID.thenComparing(PersonComparators.BY_AGE).thenComparing(PersonComparators.BY_NAME))
        .forEach(person -> System.out.println(person));
    }

}
