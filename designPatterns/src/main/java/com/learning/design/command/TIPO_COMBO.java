package com.learning.design.command;

public enum TIPO_COMBO implements Mostrando {
    CAJITA_FELIZ {
        @Override
        public String prepararComida() {
            return new Hamburguesa().prepararComida() + new Papas().prepararComida();
        }
    },
    CAJITA_TRISTE {
        @Override
        public String prepararComida() {
            return "refresco";
        }

    },
    DIETA {
        @Override
        public String prepararComida() {
            return "Sin comida";
        }
    }
}
