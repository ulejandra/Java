package com.ini.interfaces.explanation.lambda.api.Supplier;

import java.util.function.Supplier;

public enum Transport implements Supplier<Integer> {

    UBER {

        @Override
        public Integer get() {
            return 5; // time
        }

    },

    TAXI {
        @Override
        public Integer get() {
            return 7;
        }

    },

    SUBWAY {
        @Override
        public Integer get() {
            return 20;
        }

    },
    WALKING {
        @Override
        public Integer get() {
            return 40;
        }

    };

    public static Transport getTransport(double money) {
        Transport myTransport;
        if (money >= 50) {
            myTransport = UBER;
        } else if (money >= 30) {
            myTransport = TAXI;
        } else if (money >= 5) {
            myTransport = SUBWAY;
        } else {
            myTransport = WALKING;
        }
        return myTransport;
    }
}
