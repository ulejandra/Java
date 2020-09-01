package com.ini.optionals.explanation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.security.acl.NotOwnerException;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestOptional {

    private static final Logger LOG = LoggerFactory.getLogger(TestOptional.class);

    @Test
    public void testOrElse() {
        String petName = "Panter";
        String name = Optional.<Pet>empty().orElse(new Pet().setName(petName)).getName();

        assertEquals(petName, name);

    }

    @Test
    public void testOrElseGet() {
        String petName = "Panter";

        String name = Optional.<Pet>empty().orElseGet(() -> new Pet().setName(petName)).getName();

        assertEquals(petName, name);

    }

    @Test
    public void testOrElseThrow() {
        Optional<Pet> optPet = Optional.<Pet>empty();

        assertThrows(UnsupportedOperationException.class,
                () -> optPet.orElseThrow(() -> new UnsupportedOperationException())); // UnCheckedException

        assertThrows(NotOwnerException.class, () -> optPet.orElseThrow(() -> new NotOwnerException())); // CheckedException

    }

    @Test
    public void testIfPresent() {
        Optional.<Pet>empty().ifPresent(pet -> fail("why do I have a pet? o.O")); // Without pet

        String myPetName = "Rambo";
        Pet pet = new Pet().setName(myPetName);
        Person hector = new Person().setPet(pet);

        hector.getPet().ifPresent(myPet -> assertEquals(myPetName, myPet.getName())); // With pet
    }

    @Test
    public void testIsPresent() {
        Optional<Pet> pet = Optional.of(new Pet().setName("Panter"));

        if (pet.isPresent()) { // Prefer ifPresent, don't do this if you have a Consumer definition.
            LOG.info("Pet name: " + pet.get().getName());
        } else {
            fail();
        }
    }

    @Test
    public void testFilter() {
        Optional<Pet> pet = Optional.of(new Pet().setName("Panter"));

        assertFalse(pet.filter(searchingPet -> "Rambo".equals(searchingPet.getName())).isPresent());
        assertTrue(pet.filter(searchingPet -> "Panter".equals(searchingPet.getName())).isPresent());

    }

    @Test
    public void testEmpty() {
        Optional<Pet> petOpt = Optional.empty();

        assertThrows(NoSuchElementException.class, () -> petOpt.get());
        assertFalse(petOpt.isPresent());
    }

    @Test
    public void testOf() {
        Optional<Pet> petOpt = Optional.of(new Pet());

        assertTrue(petOpt.isPresent());
        assertThrows(NullPointerException.class, () -> Optional.of(null)); // Exception

    }

    @Test
    public void testOfNullable() {
        Optional<Pet> petOpt = Optional.ofNullable(null);

        assertFalse(petOpt.isPresent());
        assertThrows(NoSuchElementException.class, () -> petOpt.get());
    }

    @Test
    public void testOfMap() {
        Optional<Pet> petOpt = Optional.of(new Pet().setName("Panter"));
        String nombrePet = petOpt.map(pet -> pet.getName()).orElseGet(() -> "Rambo");

        assertEquals("Panter", nombrePet);

        Optional<Pet> petEmpty = Optional.ofNullable(null);
        nombrePet = petEmpty.map(pet -> pet.getName()).orElseGet(() -> "Rambo");

        assertEquals("Rambo", nombrePet);
    }

    @Test
    public void testOfFlatMap() {
        Optional<Person> optPerson = Optional.of(new Person().setPet(new Pet().setName("Rambo")));

        // We get the name from a Pet
        optPerson.flatMap(person -> person.getPet()).map(pet -> pet.getName()).orElseGet(() -> "Panter");
        // We get the name from an Optional of Pet
        optPerson.map(person -> person.getPet()).map(pet -> pet.get().getName()).orElseGet(() -> "Panter");

        Optional<Pet> petOpt = Optional.of(new Pet().setName("Rambo"));
        petOpt.flatMap(pet -> Optional.of(pet.getName())); // <- Create your own Optional
    }

}
