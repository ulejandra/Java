package com.learning.design.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Mensajeria {

    private static final Logger log = LoggerFactory.getLogger(Mensajeria.class);

    public void mensaje() {
        log.info("Dando señales de vida");
    }

    public void mensaje(String tengoAlgoQueDecir) {
        log.info(tengoAlgoQueDecir);
    }
}
