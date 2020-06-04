package com.ini.streams.explanation.approach.third;

import static com.ini.streams.explanation.approach.third.Calculator.OPERATION.DIVISION;
import static com.ini.streams.explanation.approach.third.Calculator.OPERATION.MULTIPLICATION;
import static com.ini.streams.explanation.approach.third.Calculator.OPERATION.SUBSTRACTION;
import static com.ini.streams.explanation.approach.third.Calculator.OPERATION.SUM;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest {

    @Test
    public void testSum() {
        Double num1 = 2.1;
        Double num2 = 3.1;
        Double expected = 5.2;

        Double actual = Calculator.getInstance().execute(SUM, num1, num2);
        assertEquals(expected, actual, 0);
    }

    @Test
    public void testSubstraction() {
        Double num1 = 2.1;
        Double num2 = 3.1;
        Double expected = -1.0;

        Double actual = Calculator.getInstance().execute(SUBSTRACTION, num1, num2);
        assertEquals(expected, actual, 0);
    }

    @Test
    public void testMultiplication() {
        Double num1 = 2.1;
        Double num2 = 3.1;
        Double expected = 6.51;

        Double actual = Calculator.getInstance().execute(MULTIPLICATION, num1, num2);
        assertEquals(expected, actual, 0.3);
    }

    @Test
    public void testDivision() {
        Double num1 = 2.1;
        Double num2 = 3.1;
        Double expected = .67;

        Double actual = Calculator.getInstance().execute(DIVISION, num1, num2);
        assertEquals(expected, actual, .3);
    }

}
