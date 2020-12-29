package com.learning.design.builder;

// Maoly example
public class PostreBuilder {
    private Postrecito postre = new Postrecito();

    public PostreBuilder setCantidad(int cantidad) {
        postre.setCantidad(cantidad);
        return this;
    }

    public PostreBuilder setNombre(String nombre) {
        postre.setNombre(nombre);
        return this;
    }

    public Postrecito build() {
        return postre;
    }

}

class Postrecito {
    private int cantidad;
    private String nombre;

    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
