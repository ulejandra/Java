package com.ini.streams.explanation;

import java.util.Random;

public class Person {
    private int id;

    public Person() {
        id = Math.abs(new Random().nextInt());
    }

    public int getId() {
        return id;
    }
}
