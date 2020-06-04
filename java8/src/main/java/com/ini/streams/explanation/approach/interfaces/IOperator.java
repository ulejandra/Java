package com.ini.streams.explanation.approach.interfaces;

@FunctionalInterface
public interface IOperator<T> {

    T doOperation(T num1, T num2);
}
