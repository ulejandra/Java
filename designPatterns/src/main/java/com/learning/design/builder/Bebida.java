package com.learning.design.builder;

// abstract example
public abstract class Bebida {
    private String marca;

    public abstract static class Builder<T extends Builder<T>> {
        private String marca;

        public T marca(String marca) {
            this.marca = marca;
            return self();
        }

        public abstract Bebida build();

        public abstract T self();
    }

    protected Bebida(Builder<?> builder) {
        this.marca = builder.marca;
    }

    public String getMarca() {
        return marca;
    }

}
