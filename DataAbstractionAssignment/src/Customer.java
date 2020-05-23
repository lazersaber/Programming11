import java.util.Date;
import java.util.ArrayList;

public class Customer {
    private int accountNumber;
    private ArrayList<Deposit> deposits;
    private ArrayList<Withdraw> withdraws;
    private double checkBalance;
    private double savingBalance;
    private double savingRate;
    private String name;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private final int OVERDRAFT = -100;

    Customer(){
        this.name = "";
        this.accountNumber = 0;
        this.checkBalance = 0;
        this.savingBalance = 0;
        deposits = new ArrayList<>();
        withdraws = new ArrayList<>();
        //constructor
    }

    Customer(String name, int accountNumber, double checkDeposit, double savingDeposit){
        this.name = name;
        this.accountNumber = accountNumber;
        this.checkBalance = checkDeposit;
        this.savingBalance = savingDeposit;
        deposits = new ArrayList<>();
        withdraws = new ArrayList<>();
        //constructor
    }

    //Requires: amt, date, account
    //Modifies: this, will add amt to checkBalance or savingBalance
    //Effects: returns checkBalance if account is CHECKING, returns savingBalance if account is SAVING
    public double deposit(double amt, Date date, String account){

        if(CHECKING.equals(account)){
            checkBalance += amt;
            Deposit deposit = new Deposit(amt, date, account);
            deposits.add(deposit);
            return checkBalance;
        }
        // if account is not CHECKING then account is SAVING
        else {
            savingBalance += amt;
            Deposit deposit = new Deposit(amt, date, account);
            deposits.add(deposit);
            return savingBalance;
        }
    }


    //Requires: amt, date, account
    //Modifies: this, will subtract amt from checkBalance or savingBalance
    //Effects: returns checkBalance if account is CHECKING, returns savingBalance if account is SAVING, -1 if overdraft
    public double withdraw(double amt, Date date, String account){
        if(checkOverdraft(amt, account)){
            System.out.println("Overdraft: No withdrawal occurred.");
            return -1;
        }
        //There is no withdrawal because of overdraft

        if(CHECKING.equals(account)){
            checkBalance -= amt;
            Withdraw withdraw = new Withdraw(amt, date, account);
            withdraws.add(withdraw);
            return checkBalance;
        }
        // if account is not CHECKING then account is SAVING
        else {
            savingBalance -= amt;
            Withdraw withdraw = new Withdraw(amt, date, account);
            withdraws.add(withdraw);
            return savingBalance;
        }
    }

    //Requires: amt >= 0
    //account should be CHECKING/SAVING
    //Modifies: this
    //Effects: returns true if amt > checkingBalance/savingBalance
    private boolean checkOverdraft(double amt, String account){
        if (CHECKING.equals(account) && checkBalance < amt ){
            System.out.println("Overdraft");
            return true;
        }
        else if (SAVING.equals(account) && savingBalance < amt ){
            System.out.println("Overdraft");
            return true;
        }
        else{
            return false;
        }
    }

    //do not modify
    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }
    //do not modify
    public void displayWithdraws(){
        for(Withdraw w : withdraws){
            System.out.println(w);
        }
    }

}
