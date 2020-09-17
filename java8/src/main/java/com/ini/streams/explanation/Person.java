package com.ini.streams.explanation;

import java.util.Random;

public class Person {
    private int id;
    private int age;
    private String name;

    private String[] names = new String[] { "Pedro", "Juan", "Alejandra", "Maoly", "Jose", "Rodrigo" };

    public Person() {
        id = Math.abs(new Random().nextInt(10));
        age = Math.abs(new Random().nextInt(6));
        name = names[new Random().nextInt(names.length)];
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", age=" + age + ", name=" + name + "]";
    }
}
