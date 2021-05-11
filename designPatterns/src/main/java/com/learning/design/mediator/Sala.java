package com.learning.design.mediator;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Sala implements Mediando {

    private Map<String, Comicados> participantes = new HashMap<>();

    @Override
    public void chismear(String de, String para, String msg) {
        participantes.get(para).recibir(de, msg);
    }

    @Override
    public Mediando subscribir(Comicados usr) {
        if (Objects.nonNull(usr) && Objects.nonNull(usr.getNombre())) {
            participantes.put(usr.getNombre(), usr);
        }
        return this;
    }

}
