import com.accounts.Acc;
import com.accounts.AccTypes;
import com.entities.*;

public class main {
    public static void main(String[] args){
        // Running some examples
        System.out.println("=== Start ===");

        // Creating entities, mean, clients and banks
        Client paul = new Client("Paul",18);
        Client mary = new Client("Mary",180);
        Bank santa = new Bank("Santa");

        // New Accounts
        santa.newAcc(paul, AccTypes.CheckingAcc);
        santa.newAcc(paul, AccTypes.SavingAcc);
        santa.newAcc(mary, AccTypes.CheckingAcc);

        // Get info Accounts
        santa.getInfo(paul);
        santa.getInfo(mary);

        // Deposit
        santa.deposit(paul,55);
        santa.deposit(mary,100);

        // Withdraw
        santa.withdraw(paul,5);

        // Intern Transfer
        santa.internTransfer(mary,AccTypes.CheckingAcc,50,AccTypes.CheckingAcc,paul);

        // Get info Accounts
        santa.getInfo(paul);
        santa.getInfo(mary);

        // New Bank
        Bank twoel = new Bank("Twoel");

        // New Account
        twoel.newAcc(paul,AccTypes.CheckingAcc);

        // Extern transfer
        santa.externTransfer(mary,AccTypes.CheckingAcc, 50, twoel, AccTypes.CheckingAcc, paul);

        // Get info Account
        twoel.getInfo(paul);
        santa.getInfo(mary);
    }
}
