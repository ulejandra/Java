package com.learning.design.command;

public class Mesero {

    private Mostrando mostrando;

    public Mesero recibirPedido(String orden) {
        switch (orden) {
            case "hamburguesa":
                mostrando = new Hamburguesa();
                break;
            case "papas":
                mostrando = new Papas();
                break;
            // case "feliz":
            // mostrando = TIPO_COMBO.CAJITA_FELIZ;
            // break;
            // case "triste":
            // mostrando = TIPO_COMBO.CAJITA_TRISTE;
            // break;
            // case "dieta":
            // mostrando = TIPO_COMBO.DIETA;
            // break;
            default:
                mostrando = new Combo(orden);
                break;
        }
        return this;
    }

    public String prepararComida() {
        return mostrando.prepararComida();
    }

}
