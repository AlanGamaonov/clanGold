package com.alan.services;

import com.alan.ConsoleLogger;
import com.alan.entity.Clan;

public class UserClanDonationService {

    private final ClanService clanService;

    public UserClanDonationService(ClanService clanService) {
        this.clanService = clanService;
    }

    public void donateGold(long clanId, int amount) {
        Clan clan = clanService.get(clanId);
        int oldGold = clan.getGold();
        clan.addGold(amount);
        ConsoleLogger.log("Donated " + amount + " gold to clan " + clan + ". Gold delta: " + oldGold + " -> " + clan.getGold());
    }
}
