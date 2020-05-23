import org.junit.Before;
import org.junit.Test;
import java.util.Date;

import static junit.framework.TestCase.assertEquals;

public class DepositTest {
    private Deposit DepositTest;
    private Date currentDate;

    @Before
    public void setup(){
        currentDate = new Date();
        DepositTest = new Deposit(50.0, currentDate, Customer.SAVING);
    }

    @Test
    public void testDeposit(){
        String testAnswer = DepositTest.toString();
        assertEquals(testAnswer, "Deposit of: $50.00 Date: " + currentDate + " into Saving account.");
        //tests if the string is the same as expected result
    }
}
