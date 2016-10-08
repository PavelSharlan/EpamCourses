import by.bsu.audioservice.valid.BalanceValidator;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 7 on 06.10.2016.
 */
public class ValidatorsTest {
    @Test
    public void balanceValid(){
        String balance = "1000";
        Assert.assertTrue(BalanceValidator.valid(balance) == false);
    }

    @Test
    public void userDataValid(){

    }
}
