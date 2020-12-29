package com.learning.design.singleton;

import java.io.Serializable;

public class Instance implements Serializable {

    private static transient final Instance myInstance = new Instance();

    private Instance() {
    }

    public static Instance getInstance() {
        return myInstance;
    }

}

