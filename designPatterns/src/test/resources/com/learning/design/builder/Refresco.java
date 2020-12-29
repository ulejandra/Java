package com.learning.design.builder;

public class Refresco extends Bebida {

    private String sabor;

    private Refresco(Builder builder) {
        super(builder);
        sabor = builder.sabor;
    }

    public static class Builder extends Bebida.Builder<Builder> {
        private String sabor;

        public Builder setSabor(String sabor) {
            this.sabor = sabor;
            return getSelf();
        }

        @Override
        protected Builder getSelf() {
            return this;
        }

        @Override
        public Bebida build() {
            return new Refresco(this);
        }

    }

    public String getSabor() {
        return sabor;
    }

}
