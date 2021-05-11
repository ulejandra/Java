package com.learning.design.observer;

public class NewChannel extends Observed {

    private String currentNews;

    // Setter
    public void setChangeData(String currentNews) {
        this.currentNews = currentNews;
        sendNotification();
    }

    // Getter
    public String getData() {
        return currentNews;
    }

}
