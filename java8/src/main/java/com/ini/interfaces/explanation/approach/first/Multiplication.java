package com.ini.interfaces.explanation.approach.first;

import com.ini.interfaces.explanation.approach.interfaces.Operator;

public class Multiplication implements Operator {

    @Override
    public double doOperation(double num1, double num2) {
        return num1 * num2;
    }

}
