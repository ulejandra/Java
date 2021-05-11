package com.learning.design.mediator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Usuario implements Comicados {

    private Logger log = LoggerFactory.getLogger(Usuario.class);

    private Mediando mediando;
    private final String nombre;

    public Usuario(String nombre, Mediando mediando) {
        this.nombre = nombre;
        this.mediando = mediando;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void recibir(String usr, String msg) {
        log.info("Para {} de {} te digo: {}", nombre, usr, msg);
    }

    @Override
    public void enviar(String para, String msg) {
        mediando.chismear(nombre, para, msg);
    }

}
