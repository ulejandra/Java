package com.ini.streams.explanation;

import java.util.Comparator;

public enum PersonComparators implements Comparator<Person> {
    BY_ID((p1, p2) -> p1.getId() - p2.getId()),
    BY_AGE((p1, p2) -> p1.getAge() - p2.getAge()),
    BY_NAME((p1, p2) -> p1.getName().compareTo(p2.getName())),;

    // All enums needs private constructor (optional)
    private Comparator<Person> comparator;

    private PersonComparators(Comparator<Person> comparator) {
        this.comparator = comparator;
    }

    @Override
    public int compare(Person p1, Person p2) {
        return comparator.compare(p1, p2);
    }

}
