package com.ini.streams.explanation.interfaces.todefault;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestUniOperator {

    @Test
    public void testDoOperation() {
        UniOperator<Integer> times = val -> val * 2;
        Integer expected;

        expected = 20;
        assertEquals(expected, times.doOperation(10));

        expected = 40;
        assertEquals(expected, times.doOperation(20));
    }

    @Test
    public void testStopWithoutOperations() {
        UniOperator<Integer> times = val -> val * 3;

        times.stop(); // <--- At this point, twoTimes has meaning.
    }

    @Test
    public void testGetResult() {
        UniOperator<Integer> times = val -> val * 4;

        String strResult = times.getResult(5);
        String result = "20";
        assertTrue(strResult.contains(result));
    }

}
