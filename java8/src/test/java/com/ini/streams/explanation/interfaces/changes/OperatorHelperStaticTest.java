package com.ini.streams.explanation.interfaces.changes;

import static org.junit.Assert.*;
import org.junit.Test;

public class OperatorHelperStaticTest {

    @Test
    public void testAdd() {
        double num1 = 1.2;
        double num2 = 2.2;
        double expected = 3.4;

        double actual = OperatorHelperStatic.add(num1, num2);
        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testSubtract() {
        double num1 = 1.2;
        double num2 = 2.2;
        double expected = -1;

        double actual = OperatorHelperStatic.subtract(num1, num2);
        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testMultiply() {
        double num1 = 1.2;
        double num2 = 2.2;
        double expected = 2.64;

        double actual = OperatorHelperStatic.multiply(num1, num2);
        assertEquals(expected, actual, 0);
    }

    @Test
    public void testDivide() {
        // This method is private

        // double num1 = 1.2;
        // double num2 = 2.2;
        // double expected = .54;
        //
        // double actual = OperatorHelperStatic.divide(num1, num2);
        // assertEquals(expected, actual, 0.006);
    }

}
