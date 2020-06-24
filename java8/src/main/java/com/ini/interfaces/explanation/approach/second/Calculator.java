package com.ini.interfaces.explanation.approach.second;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ini.interfaces.explanation.approach.interfaces.Operator;

public class Calculator {

    private static Logger LOG = LoggerFactory.getLogger(Calculator.class);
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

    /**
     * double operacion(double num1, double num2);
     */
    public double execute(OPERATION oper, double number1, double number2) {
        Operator action;
        switch (oper) {
            case SUM:
                action = new Operator() {

                    @Override
                    public double doOperation(double num1, double num2) {
                        return num1 + num2;
                    }
                };
                break;
            case SUBSTRACTION:
                action = (double num1, double num2) -> {
                    return num1 - num2;
                };
                break;
            case MULTIPLICATION:
                action = (num1, num2) -> num1 * num2;
                break;
            case DIVISION:
                action = (num1, num2) -> {
                    LOG.info("We are using lambdas =P !");
                    return num1 / num2;
                };
                break;
            default:
                throw new IllegalArgumentException(oper + " is not knowing.");
        }

        return action.doOperation(number1, number2);
    }
}
