package com.ini.interfaces.explanation.lambda.api.Function;

import java.util.function.Supplier;

public enum Transport implements Supplier<Boolean> {

    UBER(50.0), TAXI(30.0), SUBWAY(5.0), WALKING(0.0, true);

    private Double cost;
    private Boolean available;

    private Transport(Double cost) {
        this(cost, false);
    }

    private Transport(Double cost, Boolean available) {
        this.cost = cost;
        this.available = available;
    }

    public Double getCost() {
        return cost;
    }

    @Override
    public Boolean get() {
        return available;
    }

    public void setAvailable() {
        available = true;
    }

    public void setUnAvailable() {
        available = false;
    }

}
