package com.ini.streams.explanation.interfaces.changes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@FunctionalInterface
public interface UniOperator<T> {

    Logger LOG = LoggerFactory.getLogger(UniOperator.class); // public static final

    T doOperation(T num1);

    default void stop() { // Ask them for private, default or protected methods.
        // this is incorrect because it's final
        // LOG = LoggerFactory.getLogger(IOperator.class);

        LOG.info("We are stopping.");
    }

    default String getResult(T val1) {
        return "My result is " + doOperation(val1);
    }

    default UniOperator<String> addPrefix(T val1) {
        LOG.info("Creating UniOperatorString with value = {}", val1);
        return prefix -> {
            LOG.info("Executing prefix = <{}> and value = {} ", prefix, val1);
            return prefix + doOperation(val1);
        };
    }

    default UniOperator<T> before(UniOperator<T> operation) {
        return val1 -> doOperation(operation.doOperation(val1));
    }

    default UniOperator<T> after(UniOperator<T> operation) {
        return val1 -> operation.doOperation(doOperation(val1));
    }

    static <T> UniOperator<T> getMyself() {
        return val1 -> val1;
    }
}
