package com.company;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        LongDeposit Bob = new LongDeposit(new BigDecimal(100), 37);
        SpecialDeposit Tom = new SpecialDeposit(new BigDecimal(1000), 2);
        BaseDeposit Carl = new BaseDeposit(new BigDecimal(1000), 3);
        BaseDeposit Bet = new BaseDeposit(new BigDecimal(2000), 5);
        SpecialDeposit Stew = new SpecialDeposit(new BigDecimal(3000), 12);
        LongDeposit Mark = new LongDeposit(new BigDecimal(4000), 10);
        BaseDeposit Lili = new BaseDeposit(new BigDecimal(1000), 3);
        LongDeposit Bred = new LongDeposit(new BigDecimal(3000), 4);
        SpecialDeposit Robert = new SpecialDeposit(new BigDecimal(1000), 4);
        BaseDeposit Scar = new BaseDeposit(new BigDecimal(3000), 6);


        Client privat = new Client();
        privat.addDeposit(Bob);
        privat.addDeposit(Tom);
        privat.addDeposit(Carl);
        privat.addDeposit(Bet);
        privat.addDeposit(Stew);
        privat.addDeposit(Mark);
        privat.addDeposit(Lili);
        privat.addDeposit(Bred);
        privat.addDeposit(Robert);
        privat.addDeposit(Scar);

        privat.sortDeposits();
        System.out.println("Bob = " + Bob.canToProlong());
        System.out.println(privat.countPossibleToProlongDeposit());

    }
}
