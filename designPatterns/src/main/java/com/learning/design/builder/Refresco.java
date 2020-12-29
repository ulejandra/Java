package com.learning.design.builder;

public class Refresco extends Bebida {

    private String sabor;

    public static class Builder extends Bebida.Builder<Builder> {
        private String sabor;

        public Builder sabor(String sabor) {
            this.sabor = sabor;
            return self();
        }

        @Override
        public Bebida build() {
            return new Refresco(this);
        }

        @Override
        public Builder self() {
            return this;
        }

    }

    private Refresco(Builder builder) {
        super(builder);
        this.sabor = builder.sabor;

    }

    public String getSabor() {
        return sabor;
    }

}
