package com.alan.entity;

public class Clan {
    private final long id;
    private final String name;
    private volatile int gold;

    public Clan(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Clan(long id, String name, int initGold) {
        this(id, name);
        this.gold = initGold;
    }

    public long getId() {
        return id;
    }

    public synchronized int getGold() {
        return gold;
    }

    public synchronized void addGold(int amount) {
        gold += amount;
    }

    @Override
    public String toString() {
        return "Clan{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
