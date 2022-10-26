package com.alan;

import java.time.ZonedDateTime;

public class ConsoleLogger {

    //Вывод вида:
    //2022-10-26T19:27:20.750137400+03:00[Europe/Moscow] [UserClanDonationService/donateGold]: User(3) Donated 100 gold to clan Clan{id=1, name='Clan 1'}. Gold delta: 300 -> 400
    public static void log(String message) {
        StackWalker sw = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);
        String method = sw.
                walk(stream -> stream.skip(1).findFirst().get()).
                getMethodName();

        String callerClass = sw.getCallerClass().getSimpleName();
        System.out.println(
                ZonedDateTime.now()
                        + " [" + callerClass + '/' + method + "]: "
                        + "User(" + ApplicationContext.getUserId()  + ") "
                        + message);
    }


}
