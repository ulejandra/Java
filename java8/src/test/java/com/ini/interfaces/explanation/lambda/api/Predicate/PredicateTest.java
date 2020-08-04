package com.ini.interfaces.explanation.lambda.api.Predicate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.function.Predicate;

import org.junit.Test;

public class PredicateTest {

    @Test
    public void testTest() {
        Predicate<Integer> adult = age -> age >= 18;

        assertTrue(adult.test(34));
        assertFalse(adult.test(17));
    }

    @Test
    public void testNegate() {
        Predicate<Integer> adult = age -> age >= 18;
        Predicate<Integer> child = adult.negate();

        assertTrue(adult.test(34));
        assertFalse(child.test(34));
        assertTrue(child.test(4));
        assertFalse(adult.test(4));
    }

    @Test
    public void testAnd() {
        Predicate<Integer> midAgeBegin = age -> age >= 18;
        Predicate<Integer> workingAge = midAgeBegin.and(age -> age < 65);

        assertTrue(workingAge.test(34));
        assertFalse(workingAge.test(17));
        assertFalse(workingAge.test(65));
    }

    @Test
    public void testOr() {
        Predicate<Integer> child = age -> age < 18;
        Predicate<Integer> freeIceCream = child.or(age -> age >= 65);

        assertTrue(freeIceCream.test(17));
        assertFalse(freeIceCream.test(34));
        assertTrue(freeIceCream.test(65));

    }

}
