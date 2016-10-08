package test.by.bsu.amount;

import by.bsu.parsing.builder.CandiesStAXBuilder;
import by.bsu.parsing.entity.GlazedCandy;
import by.bsu.parsing.entity.Lollipop;
import by.bsu.parsing.main.Main;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;

/**
 * Created by 7 on 22.06.2016.
 */
public class CandiesAmountTest {
    @Testф
    public void checkAmount(){
        CandiesStAXBuilder stAXBuilder = new CandiesStAXBuilder();
        stAXBuilder.buildListsCandies(Main.FILE_XML);
        int expected = 6;
        ArrayList<Lollipop> lollipops = stAXBuilder.getLollipops();
        ArrayList<GlazedCandy> glazedCandies = stAXBuilder.getGlazedCandies();
        int actual = lollipops.size() + glazedCandies.size();
        Assert.assertEquals(expected, actual);
    }
}
