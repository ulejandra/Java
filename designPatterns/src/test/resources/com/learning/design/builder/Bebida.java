package com.learning.design.builder;

public abstract class Bebida {

    private String marca;

    public abstract static class Builder<T extends Builder<T>> {
        private String marca;

        public T setMarca(String marca) {
            this.marca = marca;
            return getSelf();
        }

        protected abstract T getSelf();

        public abstract Bebida build();
    }

    protected Bebida(Builder<?> builder) {
        marca = builder.marca;
    }

    public String getMarca() {
        return marca;
    }

}
