package com.learning.design.builder;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CreandoPostrecito {

    @Test
    public void testPostrecito() {

        Postre postrecito = new Postre.Builder("mantecada").cantidad(4).build();
        Person maoly = new Person().setNombre("Maoly").setEdad(15).setPostrecito(postrecito);

        assertEquals(4, maoly.getPostrecito().getCantidad());
    }

    @Test
    public void testBebida() {
        Bebida bebida = new Refresco.Builder().setMarca("CocaCola").setSabor("naranja").build();
        Person jose = new Person().setNombre("Jose").setEdad(36).setBebida(bebida);

        assertEquals("CocaCola", jose.getBebida().getMarca());
    }
}
