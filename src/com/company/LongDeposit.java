package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LongDeposit extends Deposit implements Prolongable{
    public LongDeposit(BigDecimal depositAmount, int depositPeriod) {
        super(depositAmount, depositPeriod);
    }

    @Override
    public BigDecimal income() {
            BigDecimal sum = super.getAmount();
            BigDecimal per = BigDecimal.valueOf(0.15);
            BigDecimal income;
            if (getPeriod()<7) return BigDecimal.ZERO;
            for (int i = 6; i < getPeriod(); i++) {
                sum = sum.add(sum.multiply(per));
            }
            income = sum.subtract(super.getAmount());

            return income.setScale(2, RoundingMode.HALF_DOWN);
        }

    @Override
    public boolean canToProlong() {
        return (getPeriod()<36);
    }
}

