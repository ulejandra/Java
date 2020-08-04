package com.ini.interfaces.explanation.lambda.api.Predicate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.function.BiPredicate;

import org.junit.Test;

public class BiPredicateTest {

    @Test
    public void testTest() {
        BiPredicate<Comparable<String>, String> checker = greaterEqual();

        assertTrue(checker.test("MAOLY", "MAOLY"));
        assertTrue(checker.test("MAOLY", "HECTOR"));
        assertFalse(checker.test("JOSE", "MAOLY"));
        assertFalse(checker.test(null, "MAOLY"));
        assertFalse(checker.test("MAOLY", null));
        assertTrue(checker.test(null, null));

    }

    @Test
    public void testNegate() {
        BiPredicate<Comparable<Integer>, Integer> checker = greaterEqual();
        BiPredicate<Comparable<Integer>, Integer> notChecker = checker.negate();

        assertFalse(checker.test(1, 2));
        assertTrue(checker.test(3, 2));

        assertFalse(notChecker.test(1, 1));
        assertTrue(notChecker.test(2, 3));
        assertTrue(notChecker.test(null, 4));
        assertTrue(notChecker.test(5, null));
        assertFalse(notChecker.test(null, null));
    }

    private <T> BiPredicate<Comparable<T>, T> greaterEqual() {
        return (value1, value2) -> value1 == value2
                || value1 != null && value2 != null && value1.compareTo(value2) >= 0;
    }

}
