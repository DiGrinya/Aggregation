package com.company;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Deposit implements Comparable<Deposit>{
    public final BigDecimal amount;
    public final int period;

    public Deposit(BigDecimal depositAmount, int depositPeriod) {
        this.amount = depositAmount;
        this.period = depositPeriod;

    }

    public BigDecimal getAmount() {
        return amount;
    }

    public int getPeriod() {
        return period;
    }

    public abstract BigDecimal income();

    private BigDecimal sumAmount(){
        return income().add(amount);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deposit deposit = (Deposit) o;
        return period == deposit.period && Objects.equals(amount, deposit.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, period);
    }

    @Override
    public int compareTo (Deposit obj){
       if (obj != null){
            return this.sumAmount().compareTo(obj.sumAmount());
       }
        return 1;
    }

    @Override
    public String toString() {
        return "Deposit " + sumAmount();
    }


}
