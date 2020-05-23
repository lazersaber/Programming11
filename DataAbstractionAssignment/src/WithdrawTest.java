import org.junit.Before;
import org.junit.Test;
import java.util.Date;

import static junit.framework.TestCase.assertEquals;

public class WithdrawTest {
    private Withdraw WithdrawTest;
    private Date currentDate;

    @Before
    public void setup(){
        currentDate = new Date();
        WithdrawTest = new Withdraw(50.0, currentDate, Customer.CHECKING);
    }

    @Test
    public void testWithdraw(){
        String testAnswer = WithdrawTest.toString();
        assertEquals(testAnswer, "Withdrawal of: $50.00 Date: " + currentDate + " into Checking account.");
        //tests if the string is the same as expected result
    }
}
