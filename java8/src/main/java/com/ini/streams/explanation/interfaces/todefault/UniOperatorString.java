package com.ini.streams.explanation.interfaces.todefault;

public class UniOperatorString implements UniOperator<String> {

    private UniOperator<Integer> operator;
    private Integer val1;

    public UniOperatorString(UniOperator<Integer> operator, Integer val1) {
        this.operator = operator;
        this.val1 = val1;
    }

    @Override
    public String doOperation(String valStr) {
        return valStr + operator.doOperation(val1);
    }

}
