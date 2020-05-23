import java.text.NumberFormat;
import java.util.Date;

public class Deposit {
    private double amount;
    private Date date;
    private String account;

    Deposit(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    public String toString(){
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        String answer = "Deposit of: " + currencyFormat.format(amount) +
                " Date: " + date + " into " + account + " account.";
        return answer;
        //returns deposit object in string format
    }
}
