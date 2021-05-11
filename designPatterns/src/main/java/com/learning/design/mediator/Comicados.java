package com.learning.design.mediator;

public interface Comicados {

    void recibir(String usr, String msg);

    void enviar(String para, String msg);

    String getNombre();
}
