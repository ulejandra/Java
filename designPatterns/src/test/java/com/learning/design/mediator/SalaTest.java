package com.learning.design.mediator;

import org.junit.Test;

public class SalaTest {

    @Test
    public void test() {
        Sala sala = new Sala();
        Usuario maoly = new Usuario("maoly", sala);
        Usuario erik = new Usuario("erik", sala);
        Usuario pedro = new Usuario("pedro", sala);
        Usuario jose = new Usuario("jose", sala);
        Usuario alegria = new Usuario("alegria", sala);

        sala.subscribir(alegria).subscribir(jose).subscribir(pedro).subscribir(erik).subscribir(maoly);

        maoly.enviar("erik", "hola");

    }

}
