package com.ini.streams.explanation.interfaces.changes;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UniOperatorTest {
    private static final Logger LOG = LoggerFactory.getLogger(UniOperatorTest.class);

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

    @Test
    public void testAddPrefix1() {
        UniOperator<Integer> times = val -> val * 5;
        UniOperator<String> result = times.addPrefix(8); // 40

        // Breakpoint and check logs
        String strResult = result.doOperation("8 * 5 = ");
        assertEquals("8 * 5 = 40", strResult);
    }

    @Test
    public void testAdd2() {
        UniOperator<Integer> times = val -> {
            LOG.info("Executing the first operation.");
            return val + 6;
        };
        UniOperator<String> result = times.addPrefix(34); // 40

        // Put a breakpoint and check logs
        String strResult = result.doOperation("8 * 5 = ");
        // We have both execution logs.
        assertEquals("8 * 5 = 40", strResult);
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

    @Test
    public void testBefore() {
        UniOperator<Integer> times = val -> val * 7;
        UniOperator<Integer> add = val -> val + 5;

        UniOperator<Integer> resultOper = add.before(times);
        Integer result = resultOper.doOperation(10);
        Integer expected = 75;
        assertEquals(expected, result);
    }

    @Test
    public void testAfter() {
        UniOperator<Integer> times = val -> val * 7;
        UniOperator<Integer> add = val -> val + 5;

        UniOperator<Integer> resultOper = add.after(times);
        Integer result = resultOper.doOperation(10);
        Integer expected = 105;
        assertEquals(expected, result);
    }

    @Test
    public void testGetMyself() {
        UniOperator<String> myself = UniOperator.getMyself();

        assertEquals("Hola", myself.doOperation("Hola"));
    }

    @Test
    public void testExperiment() {
        UniOperator<Integer> myself = UniOperator.getMyself();
        String result = myself.before(val -> val * 10).after(val -> val + 50).addPrefix(100).getResult("a disaster = ");
        String mathResult = "1050";

        LOG.info(result);
        assertTrue(result.contains(mathResult));
    }

    @Test
    public void testAlmostTheSameExperiment() {
        UniOperator<Integer> myself = UniOperator.getMyself();
        String result = myself.after(val -> val * 10).before(val -> val + 50).addPrefix(100).getResult("a disaster = ");
        String mathResult = "1500";

        LOG.info(result);
        assertTrue(result.contains(mathResult));
    }
}
