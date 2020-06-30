package com.ini.interfaces.explanation.interfaces.todefault;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestUniOperatorWithDifficultMode {
    private static final Logger LOG = LoggerFactory.getLogger(TestUniOperatorWithDifficultMode.class);

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
        String result =
                myself // 1 000
                        .before(val -> val * 10) // doOperation( (val -> val * 10).doOperation(100) )
                        .after(val -> val
                                + 50) // ( val -> val + 50 ) .doOperation(doOperation(100))
                        .addPrefix(100) // "a disaster = " + doOperation(100);
                        .getResult("a disaster = "); // "My result is " + doOperation("a disaster = ");
        String mathResult = "1050";

        LOG.info(result); // My result is a disaster = 1050
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
