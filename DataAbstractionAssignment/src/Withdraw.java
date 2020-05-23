import java.text.NumberFormat;
import java.util.Date;

public class Withdraw {
    private double amount;
    private Date date;
    private String account;

    Withdraw(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    public String toString(){
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        String answer = "Withdrawal of: " + currencyFormat.format(amount) +
                " Date: " + date + " into " + account + " account.";
        return answer;
        //returns withdraw object in string format

    }
}
