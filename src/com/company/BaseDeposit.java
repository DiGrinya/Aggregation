package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BaseDeposit extends Deposit {

    public BaseDeposit(BigDecimal depositAmount, int depositPeriod) {
        super(depositAmount,depositPeriod);
    }

    @Override
    public BigDecimal income() {
        BigDecimal sum = super.getAmount();
        BigDecimal per = BigDecimal.valueOf(0.05);
        BigDecimal income;
       // if (period <=0 || amount.compareTo(BigDecimal.ZERO)<0)
       //     throw new IllegalArgumentException();
        for (int i = 0; i < getPeriod(); i++) {
            sum = sum.add(sum.multiply(per));
        }
        income = sum.subtract(super.getAmount());

            return income.setScale(2, RoundingMode.HALF_DOWN);
        }
}
