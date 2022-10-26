package com.alan;

import com.alan.entity.Clan;
import com.alan.services.ClanService;
import com.alan.services.TaskService;
import com.alan.services.UserClanDonationService;

public class Main {

    public static void main(String[] args) {
        ClanService clanService = new ClanService();
        UserClanDonationService donationService = new UserClanDonationService(clanService);
        TaskService taskService = new TaskService(clanService);

        Clan clan = new Clan(1, "Clan 1");
        clanService.add(clan);

        for (int i = 0; i < 5; i++)
            new Thread(new UserThread(i, () -> donationService.donateGold(1, 100))).start();
        for (int i = 5; i < 10; i++) {
            int finalI = i;
            new Thread(new UserThread(i, () -> taskService.completeTask(1, finalI))).start();
        }
    }


}
