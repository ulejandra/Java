package com.ini.streams.explanation;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private String name;

    private List<Dish> dishes = new ArrayList<>();

    public List<Dish> getDishes() {
        return dishes;
    }

    public Restaurant setDishes(List<Dish> dishes) {
        this.dishes = dishes;
        return this;
    }

    public String getName() {
        return name;
    }

    public Restaurant setName(String name) {
        this.name = name;
        return this;
    }

}
