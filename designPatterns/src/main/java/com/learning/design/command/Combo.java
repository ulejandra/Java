package com.learning.design.command;

public class Combo implements Mostrando {

    Mostrando mostrando;

    public Combo(String orden) {
        try {
            mostrando = TIPO_COMBO.valueOf(orden);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Esa orden no esta en el menu: " + orden);
        }
    }

    @Override
    public String prepararComida() {
        return mostrando.prepararComida();
    }

}
