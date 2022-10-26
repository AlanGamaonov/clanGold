package com.alan.services;

import com.alan.ConsoleLogger;
import com.alan.entity.Clan;

public class TaskService {

    private final ClanService clanService;

    public TaskService(ClanService clanService) {
        this.clanService = clanService;
    }

    public void completeTask(long clanId, long taskId) {
        Clan clan = clanService.get(clanId);
        int oldGold = clan.getGold();

        //Тут какой-нибудь репозиторий задач и т.д., но это, я считаю, лишнее в рамках текущей задачи
        int amount = 1000;
        clan.addGold(amount);
        ConsoleLogger.log("Completed task Task{id=" + taskId + ", reward=" + amount + "} for clan " + clan + ". Gold delta: " + oldGold + " -> " + clan.getGold());
    }
}
