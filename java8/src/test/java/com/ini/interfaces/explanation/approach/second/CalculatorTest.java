package com.ini.interfaces.explanation.approach.second;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ini.interfaces.explanation.approach.second.Calculator.OPERATION;

public class CalculatorTest {

    @Test
    public void testSum() {
        double num1 = 2.1;
        double num2 = 3.1;
        double expected = 5.2;

        double actual = Calculator.getInstance().execute(OPERATION.SUM, num1, num2);
        assertEquals(expected, actual, 0);
    }

    @Test
    public void testSubstraction() {
        double num1 = 2.1;
        double num2 = 3.1;
        double expected = -1;

        double actual = Calculator.getInstance().execute(OPERATION.SUBSTRACTION, num1, num2);
        assertEquals(expected, actual, 0);
    }

    @Test
    public void testMultiplication() {
        double num1 = 2.1;
        double num2 = 3.1;
        double expected = 6.51;

        double actual = Calculator.getInstance().execute(OPERATION.MULTIPLICATION, num1, num2);
        assertEquals(expected, actual, 0.3);
    }

    @Test
    public void testDivision() {
        double num1 = 2.1;
        double num2 = 3.1;
        double expected = .67;

        double actual = Calculator.getInstance().execute(OPERATION.DIVISION, num1, num2);
        assertEquals(expected, actual, .3);
    }

}
