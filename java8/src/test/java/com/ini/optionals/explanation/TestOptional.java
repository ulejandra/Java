package com.ini.optionals.explanation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.security.acl.NotOwnerException;
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
        try {
            Optional.<Pet>empty().orElseThrow(() -> new UnsupportedOperationException()).getName();
            fail();
        } catch (UnsupportedOperationException e) { // UnCheckedException
            // Expected
        } catch (Exception e) {
            fail();
        }

        try {
            Optional.<Pet>empty().orElseThrow(() -> new NotOwnerException()).getName();
            fail();
        } catch (NotOwnerException e) { // CheckedException
            // Expected
        } catch (Exception e) {
            fail();
        }

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

}
