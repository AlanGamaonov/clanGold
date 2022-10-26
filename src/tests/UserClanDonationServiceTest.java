package tests;

import com.alan.UserThread;
import com.alan.entity.Clan;
import com.alan.services.ClanService;
import com.alan.services.UserClanDonationService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserClanDonationServiceTest {

    ClanService clanService = new ClanService();
    UserClanDonationService donationService;

    //Для TaskService решил тесты не писать, так как суть в нём точно такая же

    @BeforeAll
    void setUp() {
        clanService.add(new Clan(0, "TestClan0"));
        clanService.add(new Clan(1, "TestClan1"));
        donationService = new UserClanDonationService(clanService);
    }

    @Test
    void testParallelDonation() {
        for (int i = 0; i < 200; i++) {
            int finalI = i;
            new Thread(new UserThread(finalI, () -> donationService.donateGold(finalI / 100, 100))).start();
        }
        Clan clan0 = clanService.get(0);
        assertEquals(100 * 100, clan0.getGold());

        Clan clan1 = clanService.get(1);
        assertEquals(100 * 100, clan1.getGold());
    }
}