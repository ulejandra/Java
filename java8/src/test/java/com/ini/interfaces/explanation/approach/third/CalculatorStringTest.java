package com.ini.interfaces.explanation.approach.third;

import static com.ini.interfaces.explanation.approach.third.CalculatorString.OPERATION.DIVISION;
import static com.ini.interfaces.explanation.approach.third.CalculatorString.OPERATION.MULTIPLICATION;
import static com.ini.interfaces.explanation.approach.third.CalculatorString.OPERATION.SUBSTRACTION;
import static com.ini.interfaces.explanation.approach.third.CalculatorString.OPERATION.SUM;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorStringTest {

    @Test
    public void testSum() {
        String num1 = "2.1";
        String num2 = "3.1";
        String expected = SUM + "->" + num1 + " + " + num2;

        String actual = CalculatorString.getInstance().execute(SUM, num1, num2);
        assertEquals(expected, actual);
    }

    @Test
    public void testSubstraction() {
        String num1 = "2.1";
        String num2 = "3.1";
        String expected = SUBSTRACTION + "->" + num1 + " - " + num2;

        String actual = CalculatorString.getInstance().execute(SUBSTRACTION, num1, num2);
        assertEquals(expected, actual);
    }

    @Test
    public void testMultiplication() {
        String num1 = "2.1";
        String num2 = "3.1";
        String expected = MULTIPLICATION + "->" + num1 + " * " + num2;

        String actual = CalculatorString.getInstance().execute(MULTIPLICATION, num1, num2);
        assertEquals(expected, actual);
    }

    @Test
    public void testDivision() {
        String num1 = "2.1";
        String num2 = "3.1";
        String expected = DIVISION + "->" + num1 + " / " + num2;

        String actual = CalculatorString.getInstance().execute(DIVISION, num1, num2);
        assertEquals(expected, actual);
    }

}
