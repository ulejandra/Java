package com.learning.design.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class User implements Observer {

    private Logger log = LoggerFactory.getLogger(User.class);

    private Observed subject;

    public User(Observed subject) {
        this.subject = subject;
    }

    @Override
    public void update() {
        log.info(subject.getData());
    }

}
