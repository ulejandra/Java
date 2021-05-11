package com.learning.design.iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.junit.Test;

public class TestIterator {


    @Test
    public void testIterator() {

        Collection<String> col = new ArrayList<>();
        Iterator<String> iter = col.iterator();

        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

    }

}
