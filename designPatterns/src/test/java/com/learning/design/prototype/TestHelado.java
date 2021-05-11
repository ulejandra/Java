package com.learning.design.prototype;

import static org.junit.Assert.fail;

import java.util.logging.Logger;

import org.junit.Test;

public class TestHelado {

    private static final Logger log = Logger.getAnonymousLogger();

    @Test
    public void test() {
        Helado helado1 = new Helado();
        try {
            Helado helado2 = helado1.clone();
            helado2.getCono().setSabor("fresa");

            log.info("" + helado2);
        } catch (CloneNotSupportedException e) {
            log.severe("" + e);
            fail("Clone Exception");
        }
    }

}
