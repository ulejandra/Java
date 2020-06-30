package com.ini.interfaces.explanation.interfaces.todefault.inherit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class WorkerTest {

    @Test
    public void stopWorker() {
        assertFalse("I'm an undecided person.", new Worker().isStopping());
    }

    @Test
    public void stopLazy() {
        ILazy lazy = new ILazy() {
        };
        assertTrue("We are stopping. Noooooooooooooooo, I want to be working...", lazy.isStopping());
    }

    @Test
    public void stopWorking() {
        IWorking worker = () -> "I'm workaholic !";

        assertFalse("We are stopping. Yuhu !!! We need to rest !", worker.isStopping());
    }

}
