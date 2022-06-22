package com.accounts;

public class SavingAcc extends Acc{
    private double interestRate;
    public SavingAcc(){
        super.setAccType(AccTypes.SavingAcc);
        this.interestRate = 0.1;
    }

    public void savingReturn(){
        this.deposit(this.getBalance()*(1+this.interestRate));
    }

}
