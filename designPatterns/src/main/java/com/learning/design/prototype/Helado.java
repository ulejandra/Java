package com.learning.design.prototype;

public class Helado implements Cloneable {

    private Cono cono = new Cono();

    public Helado() {
    }

    public Helado(Helado helado) {
        cono = new Cono(helado.getCono());
    }

    public static final Helado getInstance(Helado helado) {
        Helado myHelado = new Helado();
        myHelado.setCono(new Cono(helado.getCono()));

        return myHelado;
    }

    public Cono getCono() {
        return cono;
    }

    public void setCono(Cono cono) {
        this.cono = cono;
    }

    @Override
    protected Helado clone() throws CloneNotSupportedException {
        return (Helado) super.clone();
    }

}
