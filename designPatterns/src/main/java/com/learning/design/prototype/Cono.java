package com.learning.design.prototype;

public class Cono implements Cloneable {

    private String sabor = "Chocolate";

    public Cono() {
    }

    public Cono(Cono cloneCono) {
        sabor = cloneCono.getSabor();
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    @Override
    protected Cono clone() throws CloneNotSupportedException {
        return (Cono) super.clone();
    }

}
