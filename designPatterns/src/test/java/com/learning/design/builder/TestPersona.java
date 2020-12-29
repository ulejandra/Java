package com.learning.design.builder;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestPersona {

    @Test
    public void testPersona() {
        Object persona = new Persona().setNombre("Jose").setEdad(30);

        assertTrue(Persona.class.isInstance(persona));
    }

    @Test
    public void testPostre() {
        Object postre = new PostreBuilder().setCantidad(2).setNombre("Helado").build();

        assertTrue(Postrecito.class.isInstance(postre));

        Postrecito postrecito = new Postrecito(); // ??????????
        postrecito.setCantidad(0); // y el builder ??
    }

    @Test
    public void testPostrecito() {
        Object postre = new Postre.Builder("mantecados").cantidad(3).build();

        assertTrue(Postre.class.isInstance(postre));
    }

    @Test
    public void testBebida() {
        Bebida bebida = new Refresco.Builder().sabor("orange").marca("Crush").build();
        bebida = new Refresco.Builder().marca("Crush").sabor("orange").build();

        assertTrue(Refresco.class.isInstance(bebida));
    }
}
