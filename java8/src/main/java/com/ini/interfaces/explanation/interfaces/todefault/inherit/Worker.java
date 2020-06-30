package com.ini.interfaces.explanation.interfaces.todefault.inherit;

public class Worker implements ILazy, IWorking {

    @Override
    public boolean isStopping() {
        boolean islazy = ILazy.super.isStopping();
        boolean isWorking = IWorking.super.isStopping();

        return islazy && isWorking;
    }

    @Override
    public String getMessage() {
        return "I'm an undecided person.";
    }

}
