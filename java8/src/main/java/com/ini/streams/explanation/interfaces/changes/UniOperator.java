package com.ini.streams.explanation.interfaces.changes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@FunctionalInterface
public interface UniOperator<T> {

    Logger LOG = LoggerFactory.getLogger(UniOperator.class); // public static final

    T doOperation(T val1); // We must always create this lambda.

    default void stop() { // Only public.

        // Next line is incorrect because it's final
        // LOG = LoggerFactory.getLogger(IOperator.class);

        LOG.info("We are stopping.");
    }

    default String getResult(T val1) {
        return "My result is " + doOperation(val1);
    }

    default UniOperator<String> addPrefix(T val1) {
        LOG.info("addPrefix({})", val1);

        return prefix -> {
            T resultOper = doOperation(val1);
            String result = prefix + resultOper;
            LOG.info("\n\t\t{} "
                    + "\n\t\t= <prefix> + doOperation(val1) "
                    + "\n\t\t= <{}> + doOperation( {} )", 
                    result, prefix, val1);
            return result;
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
