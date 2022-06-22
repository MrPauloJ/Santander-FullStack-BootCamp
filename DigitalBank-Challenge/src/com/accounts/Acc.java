package com.accounts;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Acc {
    private double balance;
    private AccTypes accType;
    private static AtomicInteger increment = new AtomicInteger(0);
    private int accNumber;

    Acc(){
        this.balance=0;
        this.accNumber = increment.incrementAndGet();
    }

    public AccTypes getAccType(){
        return this.accType;
    }

    public void setAccType(AccTypes accType){
        this.accType = accType;
    }

    public void withdraw(double value){
        if(this.balance>=value) balance-=value;
        else System.out.println("Insufficient Balance");
    }

    public void deposit(double value){
        if(value>0) this.balance+=value;
        else System.out.println("Your value must be positive");
    }

    public void transfer(double value, Acc accTransfer){
        if(value>0){
            this.balance-=value;
            accTransfer.deposit(value);
        }else System.out.println("Your value must be positive");
    }

    public int getAccNumber(){
        return this.accNumber;
    }

    public double getBalance() {
        return this.balance;
    }
}
