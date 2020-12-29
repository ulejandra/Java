package com.learning.design.builder;

public class Postre {

    private int cantidad;
    private String nombre;

    private Postre(Builder builder) {
        cantidad = builder.cantidad;
        nombre = builder.nombre;
    }

    public static class Builder {
        private final String nombre;
        private int cantidad;

        public Builder(String nombre) {
            this.nombre = nombre;
        }

        public Builder cantidad(int cantidad) {
            this.cantidad = cantidad;
            return this;
        }

        public Postre build() {
            return new Postre(this);
        }
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getNombre() {
        return nombre;
    }

}
