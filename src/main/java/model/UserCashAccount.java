package model;

import java.math.BigDecimal;

public class UserCashAccount {
    public static double cashBalance = 20000;

    public static void processOperation(String type, String amount) {
        int cashAmount = Integer.parseInt(amount);

        if(type.equals("withdraw")){
            cashBalance -= cashAmount;
        } else {
            cashBalance += cashAmount;
        }
    }
}
