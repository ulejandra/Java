package com.ini.z.mock;

import java.util.Arrays;
import java.util.List;

import com.ini.streams.explanation.Dish;
import com.ini.streams.explanation.Dish.TYPE;
import com.ini.streams.explanation.Restaurant;

public class RestaurantsMock {
    public static List<Restaurant> getMockRestaurants() {
        Restaurant rLaVid = new Restaurant().setName("La Vid").setDishes(getMockDishes());

        Restaurant rItalliannis = new Restaurant().setName("Italliannis").setDishes(getMockDishesItal());

        Restaurant rCasaTonio = new Restaurant().setName("Casa Tonio").setDishes(getMockDishesCasaTonio());

        return Arrays.asList(rLaVid, rItalliannis, rCasaTonio);
    }

    private static List<Dish> getMockDishes() {
        return Arrays.asList(new Dish(TYPE.MEET, "chicken", 500), new Dish(TYPE.OTHER, "rice", 700),
                new Dish(TYPE.FISH, "salmon", 200), new Dish(TYPE.MEET, "steak", 800),
                new Dish(TYPE.OTHER, "fries", 1_000), new Dish(TYPE.FISH, "prawns", 300),
                new Dish(TYPE.OTHER, "fruit", 100), new Dish(TYPE.MEET, "pork", 800));
    }

    private static List<Dish> getMockDishesItal() {
        return Arrays.asList(new Dish(TYPE.MEET, "chicken", 500), new Dish(TYPE.OTHER, "pasta", 700),
                new Dish(TYPE.FISH, "lassagna", 200), new Dish(TYPE.MEET, "fetuccini", 800),
                new Dish(TYPE.MEET, "fruit", 800));
    }

    private static List<Dish> getMockDishesCasaTonio() {
        return Arrays.asList(new Dish(TYPE.MEET, "quesadilla", 500), new Dish(TYPE.OTHER, "sope", 700),
                new Dish(TYPE.FISH, "pozole", 200), new Dish(TYPE.MEET, "fruit", 800),
                new Dish(TYPE.MEET, "chicken", 800));
    }
}
