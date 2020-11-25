package com.ini.streams.explanation;

import static org.junit.Assert.fail;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ini.z.mock.RestaurantsMock;

public class GroupingByHard {

    private static final Logger log = LoggerFactory.getLogger(GroupingBy.class);

    @Test
    public void testGroupingBy() {
        List<Restaurant> restaurants = RestaurantsMock.getMockRestaurants();

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

            log.info("MAP :: \n {}", sure);
        } catch (Exception e) {
            log.error("ERROR to get Map", e);
            fail();
        }


    }

    @Test
    public void testGroupingWithoutHelper() {
        List<Restaurant> restaurants = RestaurantsMock.getMockRestaurants();

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

            log.info("MAP Without Helper:: \n {}", sure);

        } catch (Exception e) {
            log.error("ERROR to get Map", e);
            fail();
        }

    }


    @Test
    public void testGroupingByHelper() {
        List<Restaurant> restaurants = RestaurantsMock.getMockRestaurants();

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
            log.info("MAP By Helper:: \n {}", sure);

        } catch (Exception e) {
            log.error("ERROR to get Map", e);
            fail();
        }

    }

    private static Stream<Helper> of(Restaurant restaurant) {
        return restaurant.getDishes().stream().map(dish -> new Helper(restaurant.getName(), dish));
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


