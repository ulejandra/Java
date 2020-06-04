package com.ini.streams.explanation.approach.third;

import com.ini.streams.explanation.approach.interfaces.IOperator;

public class Calculator {

    private static Calculator calculator;

    enum OPERATION {
        SUM, SUBSTRACTION, MULTIPLICATION, DIVISION
    }

    private Calculator() {
    }

    public static Calculator getInstance() {
        if (calculator == null) {
            calculator = new Calculator();
        }
        return calculator;
    }

    public Double execute(OPERATION oper, Double number1, Double number2) {
        IOperator<Double> action = choseOperator(oper);
        // Poner un breakpoint y revisar que tiene la variable action.
        // Explicar que aun no se ha creado y ejecutado hasta que pasemos el breakpoint.
        // Solo es declarado de momento.
        Double result = action.doOperation(number1, number2);
        return result;
    }

    // It's clearer that num1 and number1 are not the same.
    // We can return and Interface and the implementations are lambdas.
    // Explain again the use of Generics.
    private IOperator<Double> choseOperator(OPERATION oper) {
        IOperator<Double> action;
        switch (oper) {
            case SUM:
                action = (num1, num2) -> num1 + num2;
                break;
            case SUBSTRACTION:
                action = (num1, num2) -> num1 - num2;
                break;
            case MULTIPLICATION:
                action = (num1, num2) -> num1 * num2;
                break;
            case DIVISION:
                action = (num1, num2) -> num1 / num2;
                break;
            default:
                throw new IllegalArgumentException(oper + " is not knowing.");
        }
        return action;
    }
}
