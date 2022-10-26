package com.alan.services;

import com.alan.ConsoleLogger;
import com.alan.entity.Clan;
import java.util.concurrent.ConcurrentHashMap;

public class ClanService {

    private final ConcurrentHashMap<Long, Clan> clans = new ConcurrentHashMap<>();

    public void add(Clan clan) {
        long id = clan.getId();
        if (clans.containsKey(id))
            throw new IllegalStateException("Clan with id " + clan + "already exist");

        clans.put(id, clan);
    }

    public Clan get(long clanId) throws IllegalArgumentException {
        if (!clans.containsKey(clanId))
            throw new IllegalArgumentException("No clan with id " + clanId);
        return clans.get(clanId);
    }
}
