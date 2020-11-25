package com.ini.streams.explanation;

/**
 * @author alejandra.ramirez
 *
 */
public class Dish {
    public enum TYPE {
        FISH,
        MEET,
        OTHER
    }

    private TYPE type;
    private String name;
    private int calories;

    public Dish(TYPE type, String name) {
        this(type, name, 100);
    }

    public Dish(TYPE type, String name, int calories) {
        this.type = type;
        this.name = name;
        this.calories = calories;
    }

    public TYPE getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    @Override
    public String toString() {
        return "Dish [type=" + type + ", name=" + name + "]";
    }
}

enum CaloricLevel {

    DIET,
    NORMAL,
    FAT

}