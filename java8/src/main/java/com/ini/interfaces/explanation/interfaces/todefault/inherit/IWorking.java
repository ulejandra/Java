package com.ini.interfaces.explanation.interfaces.todefault.inherit;

@FunctionalInterface
public interface IWorking {

    String getMessage();

    default boolean isStopping() {
        return false;
    }
}
