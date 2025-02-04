package com.learnreactivespring.learnreactivespring.service;

public class SleepUtility {
    public static void sleepSeconds(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
