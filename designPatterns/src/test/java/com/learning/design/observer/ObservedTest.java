package com.learning.design.observer;

import org.junit.Test;

public class ObservedTest {

    @Test
    public void test() {
        Observed newsChannel = new NewChannel();

        Observer user1 = new User(newsChannel);
        Observer user2 = new User(newsChannel);
        Observer user3 = new UserVIP(newsChannel);
        Observer user4 = new UserVIP(newsChannel);
        Observer user5 = new UserVIP(newsChannel);

        newsChannel.addObserver(user5);
        newsChannel.addObserver(user4);
        newsChannel.addObserver(user3);
        newsChannel.addObserver(user2);
        newsChannel.addObserver(user1);

        newsChannel.setChangeData("Los Saludo!");

        newsChannel.deleteObserver(user3);
        newsChannel.setChangeData("Erik nos dejo :'(!");

    }

}
