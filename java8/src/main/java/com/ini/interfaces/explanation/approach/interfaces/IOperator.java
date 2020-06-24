package com.ini.interfaces.explanation.approach.interfaces;

@FunctionalInterface
public interface IOperator<T> {

    T doOperation(T num1, T num2);
}
