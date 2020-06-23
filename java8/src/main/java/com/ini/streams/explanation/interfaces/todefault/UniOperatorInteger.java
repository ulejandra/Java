package com.ini.streams.explanation.interfaces.todefault;

public class UniOperatorInteger implements UniOperator<Integer> {

    @Override
    public Integer doOperation(Integer val1) {
        return val1 * 5;
    }

    @Override
    public UniOperator<String> addPrefix(Integer val1) {
        return new UniOperatorString(this, val1);
    }

}
