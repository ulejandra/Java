package com.ini.interfaces.explanation.approach.first;

import com.ini.interfaces.explanation.approach.interfaces.Operator;

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

    public double execute(OPERATION oper, double number1, double number2) {
        Operator action;
        switch (oper) {
            case SUM:
                action = new Sum();
                break;
            case SUBSTRACTION:
                action = new Substraction();
                break;
            case MULTIPLICATION:
                action = new Multiplication();
                break;
            case DIVISION:
                action = new Division();
                break;
            default:
                throw new IllegalArgumentException(oper + " is not knowing.");
        }

        return action.doOperation(number1, number2);
    }
}
