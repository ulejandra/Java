package com.ini.streams.explanation.approach.first;

import com.ini.streams.explanation.approach.interfaces.Operator;

public class Substraction implements Operator {

    @Override
    public double doOperation(double num1, double num2) {
        return num1 - num2;
    }

}
