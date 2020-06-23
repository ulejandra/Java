package com.ini.streams.explanation.interfaces.estatic;

public class OperatorHelperStatic {

    private OperatorHelperStatic() {
    } // <--------------------

    public static double add(double num1, double num2) {
        return num1 + num2;
    }

    protected static double subtract(double num1, double num2) {
        return num1 - num2;
    }

    static double multiply(double num1, double num2) {
        return num1 * num2;
    }

    private static double divide(double num1, double num2) {
        return num1 / num2;
    }
}
