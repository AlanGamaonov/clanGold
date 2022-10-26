package com.alan;

import java.util.concurrent.ConcurrentHashMap;

public class ApplicationContext {

    private static final ConcurrentHashMap<Long, UserContext> threadUserContextMap = new ConcurrentHashMap<>();

    public static void addUser(long userId) {
        threadUserContextMap.put(Thread.currentThread().getId(), new UserContext(userId));
    }

    public static long getUserId() {
        long threadId = Thread.currentThread().getId();
        if (threadUserContextMap.containsKey(threadId))
            return threadUserContextMap.get(threadId).userId;
        else throw new IllegalStateException("No user context");
    }

    private static class UserContext {
        private final long userId;

        public UserContext(long id) {
            userId = id;
        }

        public long getUserId() {
            return userId;
        }
    }

}
