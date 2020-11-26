package com.ini.streams.explanation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

public class TerminalSearchOper {

    @Test
    public void findFirst() {
        int first = IntStream.range(1, 1000)
                .parallel()
                .filter(num -> num % 5 == 0)
                .findFirst().getAsInt(); // Solo el primero

        assertEquals(5, first);
    }

    @Test
    public void findAny() {
        int any = IntStream.range(1, 1000)
                .parallel()
                .filter(num -> num % 5 == 0)
                .findAny().getAsInt(); // cualquiera

        assertTrue(any % 5 == 0);
    }

    @Test
    public void noneMatch() {
        char[] characters = { '!', '$', '%', '&' };
        boolean noneMatch = Stream.iterate('a', sign -> ++sign).limit(10)
                .noneMatch(sign -> Arrays.binarySearch(characters, sign) >= 0);
        // que ninguno exista
        assertTrue(noneMatch);
    }

    @Test
    public void noneMatchFalse() {
        char[] characters = { '!', '$', '%', 'a' };
        boolean noneMatch = Stream.iterate('a', sign -> ++sign).limit(10)
                .noneMatch(sign -> Arrays.binarySearch(characters, sign) >= 0);
        // rayos, existe uno
        assertFalse(noneMatch);
    }

    @Test
    public void anyMatch() {
        char[] characters = { '!', '$', '%', 'j' };
        boolean anyMatch = Stream.iterate('a', sign -> ++sign).limit(10)
                .anyMatch(sign -> Arrays.binarySearch(characters, sign) >= 0);
        // alguno de ellos tiene que existir
        assertTrue(anyMatch);
    }

    @Test
    public void anyMatchFalse() {
        char[] characters = { 'y', 'w', 'm', 'z' };
        boolean anyMatch = Stream.iterate('a', sign -> ++sign).limit(10)
                .anyMatch(sign -> Arrays.binarySearch(characters, sign) >= 0);

        // Ninguno existe
        assertFalse(anyMatch);
    }

    @Test
    public void allMatch() {
        List<Character> base = Stream.iterate('a', sign -> ++sign).limit(10).collect(Collectors.toList());
        boolean allMatch = Stream.of('f', 'j', 'd', 'e').allMatch(sign -> base.contains(sign));

        assertTrue(allMatch);
    }

    @Test
    public void allMatchFalse() {
        char[] characters = { 'f', 'j', 'd', 'e' };
        boolean allMatch = Stream.iterate('a', sign -> ++sign).limit(10)
                .allMatch(sign -> Arrays.binarySearch(characters, sign) >= 0);

        assertFalse(allMatch);
    }
}
