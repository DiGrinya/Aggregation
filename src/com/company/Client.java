package com.company;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Client implements Iterable <Deposit> {

    private Deposit [] deposits;


    public Client(){
        deposits = new Deposit[10];
    }

    public boolean addDeposit (Deposit deposite){
        for (int i = 0; i < deposits.length ; i++) {
            if (deposits[i]==null) {
                deposits[i] = deposite;
                return true;
            }
        }  return false;
    }

    public BigDecimal totalIncome(){

        BigDecimal totalIncome = BigDecimal.ZERO;
        for (int i = 0; i < deposits.length ; i++) {
            if ( deposits[i] == null) continue;
            totalIncome = totalIncome.add(deposits[i].income());
        }
        return totalIncome;
    }

    public BigDecimal maxIncome(){
        BigDecimal maxIncome = BigDecimal.ZERO;
        for (int i = 0; i < deposits.length ; i++) {
            if ( deposits[i] == null) continue;
            if (maxIncome.compareTo(deposits[i].income())<1){
                maxIncome = deposits[i].income();
            }
        }
        return maxIncome;
    }

    public BigDecimal getIncomeByNumber(int number) {
        if (deposits[number]==null) return BigDecimal.ZERO;
        return deposits[number].income();
    }

    public void sortDeposits () {

       Arrays.sort(deposits, Comparator.nullsFirst(Comparator.reverseOrder()));

    }

    public int countPossibleToProlongDeposit() {

        int clientAmount  = 0;
        for (int i = 0; i < deposits.length; i++) {
            if (deposits[i] == null) continue;
            if (deposits[i] instanceof BaseDeposit) {
                continue;
            }
            Prolongable prolongable = (Prolongable) deposits[i];
            if (prolongable.canToProlong()) {
                clientAmount ++;
            }
        }
        return clientAmount ;
    }


    @Override
    public Iterator<Deposit> iterator() {
        Iterator<Deposit> it = new Iterator<Deposit>() {

            private int currentIndex = 0;


            @Override
            public boolean hasNext() {
                return currentIndex < deposits.length && deposits[currentIndex] != null;
            }

            @Override
            public Deposit next() {
                if (currentIndex < deposits.length) {
                    return deposits[currentIndex++];
                }
                throw new NoSuchElementException();
            }
        };
        return it;
    }
}
