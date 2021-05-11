package com.learning.design.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author alejandra.ramirez
 *
 */
public abstract class Observed { // Sujeto
    private List<Observer> users;

    public Observed() {
        users = new ArrayList<>();
    }

    public void addObserver(Observer user) {
        Objects.requireNonNull(user);
        users.add(user);

    }

    public void deleteObserver(Observer user) {
        users.remove(user);
    }

    public void sendNotification() {
        users.forEach(user -> user.update());
    }

    public abstract void setChangeData(String Data);

    public abstract String getData();

}
