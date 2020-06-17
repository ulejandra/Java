package com.ini.streams.explanation.interfaces.changes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestUniOperatorPrefix {

    private static final Logger LOG = LoggerFactory.getLogger(TestUniOperatorPrefix.class);

    @Test
    public void testWithoutLambdas() { // old style
        UniOperator<Integer> times = new UniOperatorInteger();
        UniOperator<String> result = new UniOperatorString(times, 8);

        String strResult = result.doOperation("8 * 5 = "); // 40
        assertEquals("8 * 5 = 40", strResult);
    }

    @Test
    public void testWithoutLambdasPrefix() { // old style with prefix method
        UniOperator<Integer> times = new UniOperatorInteger();
        UniOperator<String> result = times.addPrefix(8);

        String strResult = result.doOperation("8 * 5 = "); // 40
        assertEquals("8 * 5 = 40", strResult);
    }

    @Test
    public void testAddPrefix1() {
        UniOperator<Integer> times = val -> val * 5;
        UniOperator<String> result = times.addPrefix(8); // 40

        String strResult = result.doOperation("8 * 5 = ");
        assertEquals("8 * 5 = 40", strResult);
    }

    @Test
    public void testAddPrefix2() {
        UniOperator<Integer> times = val -> {
            LOG.info("Executing the first operation.");
            return val + 6;
        };
        UniOperator<String> result = times.addPrefix(34); // 40

        // Put a breakpoint and check logs
        String strResult = result.doOperation("34 + 6 = ");
        // We have both execution logs.
        assertEquals("34 + 6 = 40", strResult);
    }

    @Test
    public void testStopWithOperations() {
        UniOperator<Integer> times = val -> {
            LOG.info("Executing the first operation.");
            return val + 6;
        };
        UniOperator<String> result = times.addPrefix(34); // 40

        // Breakpoint.
        result.stop();
        // Check Logs, anything happened.
        // We only have created "Creating UniOperatorString..."
        // And "We are stopping."
    }

}
