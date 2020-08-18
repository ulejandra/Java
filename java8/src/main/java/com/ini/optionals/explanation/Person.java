package com.ini.optionals.explanation;

import java.util.Optional;

public class Person {

    private Optional<Pet> pet;

    public Optional<Pet> getPet() {
        return pet;
    }

    public Person setPet(Pet myPet) {
        this.pet = Optional.of(myPet);
        return this;
    }

}
