package com.alan;

public class UserThread implements Runnable {

    private final Runnable runnable;
    private final long userId;

    public UserThread(long id, Runnable func) {
        this.runnable = func;
        userId = id;
    }

    @Override
    public void run() {
        ApplicationContext.addUser(userId);
        runnable.run();
    }
}
