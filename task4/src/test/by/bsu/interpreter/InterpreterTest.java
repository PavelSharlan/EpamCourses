package test.by.bsu.interpreter;


import by.bsu.infhandling.interpreter.Client;
import by.bsu.infhandling.interpreter.Translator;
import org.junit.Test;
import org.junit.Assert;
/**
 * Created by 7 on 14.07.2016.
 */
public class InterpreterTest {
    @Test
    public void checkExpression(){
        Client interpreter = new Client(Translator.toReversePolishNotation("-8+5*(++9-7)"));
        Integer actual = (Integer)interpreter.calculate();
        Integer expected = 7;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkExpression2(){
        Client interpreter = new Client(Translator.toReversePolishNotation("--9+5/(++10-6)"));
        Integer actual = (Integer)interpreter.calculate();
        Integer expected = 9;
        Assert.assertEquals(expected, actual);
    }
}
