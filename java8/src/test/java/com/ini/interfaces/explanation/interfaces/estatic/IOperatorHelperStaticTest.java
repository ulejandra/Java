package com.ini.interfaces.explanation.interfaces.estatic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IOperatorHelperStaticTest {

    @Test
    public void testAdd() {
        double num1 = 1.2;
        double num2 = 2.2;
        double expected = 3.4;

        double actual = IOperatorHelperStatic.add(num1, num2);
        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testSubtract() {
        double num1 = 1.2;
        double num2 = 2.2;
        double expected = -1;

        double actual = IOperatorHelperStatic.subtract(num1, num2);
        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testMultiply() {
        double num1 = 1.2;
        double num2 = 2.2;
        double expected = 2.64;

        double actual = IOperatorHelperStatic.multiply(num1, num2);
        assertEquals(expected, actual, 0);
    }

    @Test
    public void testDivide() {
        double num1 = 1.2;
        double num2 = 2.2;
        double expected = .54;

        double actual = IOperatorHelperStatic.divide(num1, num2);
        assertEquals(expected, actual, 0.006);
    }

}
