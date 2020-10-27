package com.ini.streams.explanation;

import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ini.streams.explanation.Dish.TYPE;

public class GroupingByHard {

    private static final Logger LOG = LoggerFactory.getLogger(GroupingBy.class);

    @Test
    public void testGroupingBy() {
        List<Restaurant> restaurants = Mock.getMockRestaurants();

        try {
            Map<String, Optional<Stream<Dish>>> map =
                    restaurants
                    .stream()
                    .collect(
                            Collectors.groupingBy
                            (
                                    Restaurant::getName, // restaurant
                                    Collectors.mapping(  // restaurant
                                            restaurant -> restaurant.getDishes().stream(),
                                            Collectors.<Stream<Dish>>reducing(Stream::concat))
                            )
                    );


            Map<String, Map<Dish.TYPE, Long>> sure =
                    map.entrySet()
                    .stream()
                    .flatMap(entry-> entry.getValue().get()
                            .collect(
                                    Collectors.groupingBy(
                                            dish -> entry.getKey(), // Dish
                                            Collectors.groupingBy(  // Dish
                                                    Dish::getType,
                                                    Collectors.counting()
                                            )
                                    )
                            ).entrySet().stream()
                    ).collect(
                            Collectors.toMap(Entry::getKey, Entry::getValue)
                    );

            LOG.info("MAP :: \n {}", sure);
        } catch (Exception e) {
            LOG.error("ERROR to get Map", e);
            fail();
        }


    }

    @Test
    public void testGroupingWithoutHelper() {
        List<Restaurant> restaurants = Mock.getMockRestaurants();

        try {
            Map<String, Map<Dish.TYPE, Long>> sure =
                    restaurants
                    .stream()
                    .flatMap( // it needs an stream.
                            restaurant -> restaurant.getDishes().stream()
                            .collect(
                                    Collectors.groupingBy(
                                            dish -> restaurant.getName(), // Dish
                                            Collectors.groupingBy( // Dish
                                                    Dish::getType,
                                                    Collectors.counting()
                                            )
                                    )
                            ).entrySet().stream() // flatMap's stream
                    ).collect(
                            Collectors.toMap(Entry::getKey, Entry::getValue)
                    );

            LOG.info("MAP Without Helper:: \n {}", sure);

        } catch (Exception e) {
            LOG.error("ERROR to get Map", e);
            fail();
        }

    }


    @Test
    public void testGroupingByHelper() {
        List<Restaurant> restaurants = Mock.getMockRestaurants();

        try {
            Map<String, Map<Dish.TYPE, Long>> sure =
            restaurants
            .stream()
            .flatMap(GroupingByHard::of)
            .collect(
                    Collectors.groupingBy(
                            Helper::getName,    // Helper
                            Collectors.groupingBy( // Helper
                                    Helper::getType,
                                    Collectors.counting()
                            )
                    )
            );
            LOG.info("MAP By Helper:: \n {}", sure);

        } catch (Exception e) {
            LOG.error("ERROR to get Map", e);
            fail();
        }

    }

    private static Stream<Helper> of(Restaurant restaurant) {
        List<Helper> helpers = restaurant.getDishes().stream().map(dish -> new Helper(restaurant.getName(), dish))
                .collect(Collectors.toList());

        return helpers.stream();
    }

}

class Helper {
    private String name;
    private Dish.TYPE type;

    public Helper(String name, Dish dish) {
        this.name = name;
        this.type = dish.getType();
    }

    public String getName() {
        return name;
    }

    public Dish.TYPE getType() {
        return type;
    }
}

class Mock {
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
