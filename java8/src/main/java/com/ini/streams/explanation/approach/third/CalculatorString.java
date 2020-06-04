package com.ini.streams.explanation.approach.third;

import com.ini.streams.explanation.approach.interfaces.IOperator;

public class CalculatorString {

    private static CalculatorString calculator;

    enum OPERATION {
        SUM, SUBSTRACTION, MULTIPLICATION, DIVISION
    }

    private CalculatorString() {
    }

    public static CalculatorString getInstance() {
        if (calculator == null) {
            calculator = new CalculatorString();
        }
        return calculator;
    }

    public String execute(OPERATION oper, String number1, String number2) {
        IOperator<String> action = choseOperator(oper);
        String result = action.doOperation(number1, number2);

        return result;
    }

    /**
     * <p>
     * Explicar el cambio entre Calculator de Double a String.
     * </p>
     * <p>
     * Observar que no hay que crear clases para Double y para String. Nada similar
     * si estuvieramos en el paquete com.ini.streams.explanation.approach.first
     * </p>
     * <p>
     * Entendimiento de Generics y lambdas.
     * </p>
     */
    private IOperator<String> choseOperator(OPERATION oper) {
        IOperator<String> action;
        switch (oper) {
            case SUM:
                action = (num1, num2) -> oper.name() + "->" + num1 + " + " + num2;
                break;
            case SUBSTRACTION:
                action = (num1, num2) -> oper.name() + "->" + num1 + " - " + num2;
                break;
            case MULTIPLICATION:
                action = (num1, num2) -> oper.name() + "->" + num1 + " * " + num2;
                break;
            case DIVISION:
                action = (num1, num2) -> oper.name() + "->" + num1 + " / " + num2;
                break;
            default:
                throw new IllegalArgumentException(oper + " is not knowing.");
        }
        return action;
    }
}
