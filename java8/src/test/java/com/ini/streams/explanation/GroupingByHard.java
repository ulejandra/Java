package com.ini.streams.explanation;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.Test;

import com.ini.streams.explanation.Dish.TYPE;

public class GroupingByHard {

    @Test
    public void testGroupingBy() {
        Restaurant rLaVid =
                new Restaurant()
                .setName("La Vid")
                .setDishes(getMockDishes());

        Restaurant rItalliannis =
                new Restaurant()
                .setName("Italliannis")
                .setDishes(getMockDishesItal());

        Restaurant rCasaTonio =
                new Restaurant()
                .setName("Casa Tonio")
                .setDishes(getMockDishesCasaTonio());

        List<Restaurant> restaurants= Arrays.asList(rLaVid,rItalliannis, rCasaTonio);


        Function<Restaurant, List<Dish.TYPE>> functionDishType =
                restaurant -> restaurant.getDishes().stream()
                              .map(Dish::getType).collect(Collectors.toList());

        // Map<String, Map<Dish.TYPE, Long>> pruebaNuclear =
         restaurants.stream()
            .collect(
                    Collectors.groupingBy
                        (Restaurant::getName,
                        Collectors.groupingBy(
                                functionDishType, // Function
                                Collectors.counting() // Collectors
                                )));
//        Map<String, Map<Dish.TYPE, Long>> pruebaNuclear = restaurants.stream()
//                .collect(
//                        Collectors.groupingBy
//                        (Restaurant::getName,
//                                Collectors.groupingBy(
//                                        functionDishType, // Function
//                                        Collectors.counting() // Collectors
//                                        )));

        // Map <DishName, ListRestaurants>

    }

    private List<Dish> getMockDishes() {
        return Arrays.asList(new Dish(TYPE.MEET, "chicken", 500), new Dish(TYPE.OTHER, "rice", 700),
                new Dish(TYPE.FISH, "salmon", 200), new Dish(TYPE.MEET, "steak", 800),
                new Dish(TYPE.OTHER, "fries", 1_000), new Dish(TYPE.FISH, "prawns", 300),
                new Dish(TYPE.OTHER, "fruit", 100), new Dish(TYPE.MEET, "pork", 800));
    }
    private List<Dish> getMockDishesItal() {
        return Arrays.asList(new Dish(TYPE.MEET, "chicken", 500), new Dish(TYPE.OTHER, "pasta", 700),
                new Dish(TYPE.FISH, "lassagna", 200), new Dish(TYPE.MEET, "fetuccini", 800),
                new Dish(TYPE.MEET, "fruit", 800));
    }
    private List<Dish> getMockDishesCasaTonio() {
        return Arrays.asList(new Dish(TYPE.MEET, "quesadilla", 500), new Dish(TYPE.OTHER, "sope", 700),
                new Dish(TYPE.FISH, "pozole", 200), new Dish(TYPE.MEET, "fruit", 800),
                new Dish(TYPE.MEET, "chicken", 800));
    }
}
