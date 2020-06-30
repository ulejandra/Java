package com.ini.interfaces.explanation.interfaces.todefault.inherit;

public interface ILazy {

    default boolean isStopping() {
        return true;
    }

}
