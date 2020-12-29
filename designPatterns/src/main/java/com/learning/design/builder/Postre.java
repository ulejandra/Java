package com.learning.design.builder;

// Rodrigo example
public class Postre {

    private final int cantidad;
    private final String nombre;

    private Postre(Builder builder) {
        this.cantidad = builder.cantidad;
        this.nombre = builder.nombre;
    }

    public static class Builder {
        private int cantidad;
        private final String nombre; // requerido

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
