package com.ini.streams.explanation;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ini.streams.explanation.Dish.TYPE;

public class GroupingBy {

    private Logger logger = LoggerFactory.getLogger(GroupingBy.class);

    @Test
    public void testEasyGroupingBy() {
        List<Dish> dishes = getMockDishes();

        Map<Dish.TYPE, List<Dish>> dishesCollect = dishes
                .stream()
                .collect(
                        Collectors.groupingBy(Dish::getType));
        
        dishesCollect.forEach((type, list) -> logger.info(type + " = " + list + "\n"));
    }

    @Test
    public void testCaloricLevelGroupingBy() {
        List<Dish> dishes = getMockDishes();

        Map<CaloricLevel, List<Dish>> dishesCollect = dishes
                .stream()
                .collect(
                        Collectors.groupingBy(this::getCaloricLevel));
        
        dishesCollect.forEach((type, list) -> logger.info(type + " = " + list + "\n"));
    }

    @Test
    public void testTypeCaloricLevelGroupingBy() {
        List<Dish> dishes = getMockDishes();

        Map<Dish.TYPE, Map<CaloricLevel, List<Dish>>> dishesCollect = dishes
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Dish::getType, 
                                Collectors.groupingBy(this::getCaloricLevel)));
        
        dishesCollect.forEach((type, map) -> logger.info(type + " = " + map + "\n"));
    }

    @Test
    public void testTypeCountGroupingBy() {
        List<Dish> dishes = getMockDishes();

        Map<Dish.TYPE, Long> dishesCollect = dishes
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Dish::getType, 
                                Collectors.counting()));
        
        dishesCollect.forEach((type, count) -> logger.info(type + " = " + count + "\n"));
    }

    @Test
    public void testTypeCountSetter() {
        List<Dish> dishes = getMockDishes();

        Map<Dish.TYPE, Set<CaloricLevel>> dishesCollect = dishes
                .stream()
                .collect(
                    Collectors.groupingBy(
                            Dish::getType, 
                            Collectors.mapping(
                                    this::getCaloricLevel, 
                                    Collectors.toSet())));
        
        dishesCollect.forEach((type, count) -> logger.info(type + " = " + count + "\n"));
    }

    private CaloricLevel getCaloricLevel(Dish dish) {
        CaloricLevel level;
        if (dish.getCalories() <= 400) {
            level = CaloricLevel.DIET;
        } else if (dish.getCalories() <= 700) {
            level = CaloricLevel.NORMAL;
        } else {
            level = CaloricLevel.FAT;
        }
        return level;
    }
    
    private List<Dish> getMockDishes() {
        return Arrays.asList(new Dish(TYPE.MEET, "chicken", 500), new Dish(TYPE.OTHER, "rice", 700),
                new Dish(TYPE.FISH, "salmon", 200), new Dish(TYPE.MEET, "steak", 800),
                new Dish(TYPE.OTHER, "fries", 1_000), new Dish(TYPE.FISH, "prawns", 300),
                new Dish(TYPE.OTHER, "fruit", 100), new Dish(TYPE.MEET, "pork", 800));
    }
}
