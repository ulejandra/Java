package com.learning.design.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserVIP implements Observer {

    private Logger log = LoggerFactory.getLogger(UserVIP.class);

    private Observed subject;

    public UserVIP(Observed subject) {
        this.subject = subject;
    }

    @Override
    public void update() {
        log.info("VIP {}", subject.getData());

    }

}
