package com.entities;
import com.accounts.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Bank {
    private final String name;
    private HashMap<Client, ArrayList<Acc>> clientAccs = new HashMap<>();

    public Bank(String name){
        this.name = name;
    }

    public Acc getAccount(Client client, AccTypes accType){
        if(this.clientAccs.containsKey(client)){
            for(Acc a : this.clientAccs.get(client)) if (a.getAccType()==accType) return a;
        }
        return null;
    }
    private boolean checkMax(Client client, AccTypes accTypes){
        if(this.clientAccs.containsKey(client)){
            if(this.clientAccs.get(client).size()==2) return true;
            else{
                for(Acc a : this.clientAccs.get(client)){
                    if(a.getAccType().equals(AccTypes.CheckingAcc) && accTypes==AccTypes.CheckingAcc) return true;
                    else if(a.getAccType().equals(AccTypes.SavingAcc) && accTypes==AccTypes.SavingAcc) return true;
                    else return false;
                }
                return false;
            }
        }else return false;
    }
    public void newAcc(Client client, AccTypes accType){
        if(this.checkMax(client, accType)) System.out.println("Sorry. No more accounts for you.");
        else {
            switch (accType) {
                case SavingAcc:
                    Acc savingAcc = new SavingAcc();
                    this.addClientAcc(client, savingAcc);
                    System.out.println("Saving for you");
                    break;
                case CheckingAcc:
                    Acc checkingAcc = new CheckingAcc();
                    this.addClientAcc(client, checkingAcc);
                    System.out.println("Good choice");
                    break;
            }
        }
    }

    private void addClientAcc(Client client, Acc acc){
        ArrayList<Acc> accs = new ArrayList<>();
        if(this.clientAccs.containsKey(client)){
            accs = this.clientAccs.get(client);
            accs.add(acc);
            this.clientAccs.put(client, accs);
        }else{
            accs.add(acc);
            this.clientAccs.put(client, accs);
        }
    }

    public String getName(){
        return this.name;
    }

    public void getInfo(Client client){
        if(this.clientAccs.containsKey(client)){
            for(Acc a : this.clientAccs.get(client)){
                System.out.println("---------------------------------------------------");
                System.out.println("Registered account:");
                System.out.println("Bank: "+this.name);
                System.out.println("Client: "+client.getName());
                System.out.println("Number:"+ a.getAccNumber());
                System.out.println("Type:"+ a.getAccType());
                System.out.println("Balance:"+a.getBalance());
                System.out.println("");
            }
        }else System.out.println("No Account found");
    }

    private boolean uniqueAcc(Client client){
        if(this.clientAccs.containsKey(client) && this.clientAccs.get(client).size()==1 ) return true;
            else return false;
    }

    public void deposit(Client client, double value){
        if(uniqueAcc(client)) this.clientAccs.get(client).get(0).deposit(value);
        else{
            System.out.println("===== Multiples accounts found ! =====");
            System.out.println("Your deposit will be in your Checking Account");
            for(Acc a : this.clientAccs.get(client)) if(a.getAccType()==AccTypes.CheckingAcc) a.deposit(value);
        }
    }

    public void deposit(Client client, double value, AccTypes accType){
        if(uniqueAcc(client)) this.clientAccs.get(client).get(0).deposit(value);
        else{
            for(Acc a : this.clientAccs.get(client)) if(a.getAccType()==accType) a.deposit(value);
        }
    }

    public void withdraw(Client client, double value){
        if(uniqueAcc(client)) this.clientAccs.get(client).get(0).deposit(value);
        else{
            System.out.println("===== Multiples accounts found ! =====");
            System.out.println("Your withdraw will be in your Checking Account");
            for(Acc a : this.clientAccs.get(client)) if(a.getAccType()==AccTypes.CheckingAcc) a.withdraw(value);
        }
    }

    public void withdraw(Client client, double value, AccTypes accType){
        if(uniqueAcc(client)) this.clientAccs.get(client).get(0).deposit(value);
        else{
            for(Acc a : this.clientAccs.get(client)) if(a.getAccType()==accType) a.withdraw(value);
        }
    }

    public void internTransfer(Client sender, AccTypes myTypeAcc, double value, AccTypes theirTypeAcc,Client receiver){
        if(this.clientAccs.containsKey(sender) && this.clientAccs.containsKey(receiver)) {
            for (Acc a : this.clientAccs.get(sender)) {
                for(Acc b: this.clientAccs.get(receiver)){
                    if(a.getAccType() == myTypeAcc && b.getAccType()==theirTypeAcc) {
                        a.withdraw(value);
                        b.deposit(value);
                    }else System.out.println("Fix the Account type");
                }
            }
        }else{
            System.out.println("Client not found");
        }
    }

    public void externTransfer(Client sender, AccTypes myTypeAcc, double value, Bank bank, AccTypes theirTypeAcc,Client receiver){
        if(this.clientAccs.containsKey(sender) && bank.getClientAccs().containsKey(receiver)) {
            for (Acc a : this.clientAccs.get(sender)) {
                for(Acc b: bank.getClientAccs().get(receiver)){
                    if(a.getAccType() == myTypeAcc && b.getAccType()==theirTypeAcc) {
                        a.withdraw(value);
                        b.deposit(value);
                    }else System.out.println("Fix the Account type");
                }
            }
        }else{
            System.out.println("Client not found");
        }
    }

    public HashMap<Client, ArrayList<Acc>> getClientAccs(){
        return this.clientAccs;
    }
}
