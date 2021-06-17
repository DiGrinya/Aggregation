package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SpecialDeposit extends Deposit implements Prolongable {
    public SpecialDeposit(BigDecimal depositAmount, int depositPeriod) {
        super(depositAmount,depositPeriod);
    }

    @Override
    public BigDecimal income() {
        BigDecimal sum = super.getAmount();

        BigDecimal income;
        for (int i = 0; i <= getPeriod(); i++) {
            sum = sum.add(sum.multiply(BigDecimal.valueOf(i).divide(BigDecimal.valueOf(100))));
        }
        income = sum.subtract(super.getAmount());


        return income.setScale(2, RoundingMode.HALF_DOWN);
    }

    @Override
    public boolean canToProlong() {

        return (super.getAmount().compareTo(BigDecimal.valueOf(1000))>0);
    }
}


