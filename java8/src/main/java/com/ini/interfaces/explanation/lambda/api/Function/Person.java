package com.ini.interfaces.explanation.lambda.api.Function;

import java.util.function.Consumer;

public class Person {

    private String name;
    private Double money;
    private Transport transport;

    public Person(String name, Double money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public Double getMoney() {
        return money;
    }

    private void substractMoney(Double minus) {
        money -= minus;
    }

    public Transport getTransport() {
        transport = null;
        Consumer<Double> uberTransport = miMoney -> {
            if (Transport.UBER.get() && miMoney >= Transport.UBER.getCost()) {
                transport = Transport.UBER;
            }
        };
        Consumer<Double> taxiTransport = miMoney -> {
            if (transport == null && Transport.TAXI.get() && miMoney >= Transport.TAXI.getCost()) {
                transport = Transport.TAXI;
            }
        };
        Consumer<Double> subwayTransport = miMoney -> {
            if (transport == null && Transport.SUBWAY.get() && miMoney >= Transport.SUBWAY.getCost()) {
                transport = Transport.SUBWAY;
            }
        };
        Consumer<Double> walkingTransport = miMoney -> {
            if (transport == null) {
                transport = Transport.WALKING;
            }
        };

        Consumer<Double> myTransport = uberTransport.andThen(taxiTransport).andThen(subwayTransport)
                .andThen(walkingTransport);

        myTransport.accept(getMoney());
        substractMoney(transport.getCost());
        return transport;
    }

}
