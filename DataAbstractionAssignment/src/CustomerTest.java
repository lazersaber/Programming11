import org.junit.Before;
import org.junit.Test;
import java.util.Date;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CustomerTest {
    private Date date;

    @Before
    public void setup() {
        date = new Date();
    }

    @Test
    public void DepositTest(){
        System.out.println("Deposit Test:");
        Customer testCustomer = new Customer("Brandon", 1, 0.0, 0.0);
        //creates customer

        assertTrue(0.0 == testCustomer.deposit(0.0, date, Customer.CHECKING));
        //tests if balance is empty before first checking deposit
        double amt = 50.0;
        double balance = testCustomer.deposit(amt, date, Customer.CHECKING);
        //checks if balance is equal to deposit amount
        assertEquals(amt, balance);
        //tests if balance is not equal to 0
        assertFalse(0.0 == testCustomer.deposit(0.0, date, Customer.CHECKING));

        assertTrue(0.0 == testCustomer.deposit(0.0, date, Customer.SAVING));
        //tests if balance is empty before first savings deposit
        amt = 50.0;
        balance = testCustomer.deposit(amt, date, Customer.SAVING);
        //checks if balance is equal to deposit amount
        assertEquals(amt, balance);
        //tests if savings balance is not equal to 0
        assertFalse(0.0 == testCustomer.deposit(0.0, date, Customer.SAVING));

    }

    @Test
    public void testWithdraw() {
        System.out.println("Withdraw Test:");
        Customer testCustomer = new Customer("Brandon", 1, 0.0, 0.0);
        //creates customer

        //if amt is lower than 0 and not above checkBalance which will make withdraw return -1
        assertEquals(-1.0, testCustomer.withdraw(1.0, date, Customer.SAVING));

        //returns -1 if overdraft is true
        assertEquals(-1.0, testCustomer.withdraw(1000.0, date, Customer.CHECKING));

        //return -1 if account is not CHECKING/SAVING
        assertEquals(-1.0, testCustomer.withdraw(1.0, date, "ERROR"));

        testCustomer = new Customer("Brandon", 1, 20, 20);

        //tests if checkBalance equal to 10 if withdrawing and CHECKING account
        assertEquals(10.0, testCustomer.withdraw(10.0, date, Customer.CHECKING));

        //tests if savingBalance equal to 10 if withdrawing and SAVING account
        assertEquals(10.0, testCustomer.withdraw(10.0, date, Customer.SAVING));
    }

    @Test
    public void displayTests() {
        //tests displayDeposits() and displayWithdraws()
        Customer testCustomer = new Customer("Brandon", 1, 0.0, 0.0);
        testCustomer.deposit(10.0, new Date(), Customer.SAVING);
        testCustomer.withdraw(5.0, new Date(), Customer.SAVING);

        testCustomer.deposit(13.0, new Date(), Customer.SAVING);
        testCustomer.withdraw(6.5, new Date(), Customer.SAVING);

        testCustomer.deposit(24.0, new Date(), Customer.CHECKING);
        testCustomer.withdraw(12.0, new Date(), Customer.CHECKING);

        testCustomer.deposit(16.5, new Date(), Customer.SAVING);
        testCustomer.withdraw(7.0, new Date(), Customer.SAVING);

        testCustomer.deposit(10.0, new Date(), Customer.SAVING);
        testCustomer.withdraw(1.0, new Date(), Customer.SAVING);

        testCustomer.displayDeposits();
        testCustomer.displayWithdraws();
    }
}
