package com.ini.streams.explanation;

import static org.junit.Assert.assertEquals;

import java.util.OptionalInt;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

import com.ini.reference.method.Person;

public class ReduceOperation {

    @Test
    public void reduce() { 
        OptionalInt result =
                IntStream
                .rangeClosed(1, 10)
                .filter(num -> num % 2 == 0)
                .reduce(Integer::sum);

        assertEquals(30, result.getAsInt());
    }

    @Test
    public void identityReduce() {
        double result =
                DoubleStream
                .iterate(2.1, num -> num + .5)
                .limit(10)
                .filter(num -> num % 2 == 0)
                        .reduce(20, Double::max); 

        assertEquals(20, result, 0);
    }

    @Test
    public void reduceAccumulatorJoke() {
        int minAge = Stream.of(
                new Person("Maoly", 15),
                new Person("Alejandra", 34),
                new Person("Rodrigo", 29),
                new Person("Jose", 36)
                )
        .reduce(
                0, 
                (seed, person) -> Integer.min(seed, person.getAge()), 
                Integer::min);

        assertEquals(0, minAge); // XD
    }
    
    @Test
    public void reduceAccumulator() {
        int minAge = Stream.of(
                new Person("Maoly", 15),
                new Person("Alejandra", 34),
                new Person("Rodrigo", 29),
                new Person("Jose", 36)
                )
                .reduce(
                        120, 
                        (seed, person) -> Integer.min(seed, person.getAge()), 
                        Integer::min);
        
        assertEquals(15, minAge); // XD
    }
}
