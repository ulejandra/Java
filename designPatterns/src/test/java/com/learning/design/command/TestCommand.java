package com.learning.design.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class TestCommand {

    @Test
    public void commandHamburguesa() {
        assertEquals("Hamburguesa", new Mesero().recibirPedido("hamburguesa").prepararComida());
    }

    @Test
    public void commandPizza() {
        assertThrows(IllegalArgumentException.class, () -> new Mesero().recibirPedido("pizza"));
    }

    @Test
    public void commandCombo() {
        assertEquals("refresco", new Mesero().recibirPedido("CAJITA_TRISTE").prepararComida());
    }
}
