package com.learning.design.builder;

public class Person {

    private String nombre;
    private int edad;
    private Postre postrecito;
    private Bebida bebida;

    public String getNombre() {
        return nombre;
    }

    public Person setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public int getEdad() {
        return edad;
    }

    public Person setEdad(int edad) {
        this.edad = edad;
        return this;
    }

    public Postre getPostrecito() {
        return postrecito;
    }

    public Person setPostrecito(Postre postrecito) {
        this.postrecito = postrecito;
        return this;
    }

    public Bebida getBebida() {
        return bebida;
    }

    public Person setBebida(Bebida bebida) {
        this.bebida = bebida;
        return this;
    }

}
