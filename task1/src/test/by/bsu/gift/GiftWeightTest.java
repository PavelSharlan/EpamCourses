package test.by.bsu.gift;

import by.bsu.gift.entity.Aroma;
import by.bsu.gift.entity.Gift;
import by.bsu.gift.entity.Lollipop;
import by.bsu.gift.entity.Sweet;
import org.junit.*;

import java.util.ArrayList;

/**
 * Created by 7 on 22.05.2016.
 */

public class GiftWeightTest {
    @Test
    public void testGiftByWeight(){
        Lollipop l1 = new Lollipop("Alyonka", 0.01, "Belarus", 0.005, "Sugary", Aroma.COCOA);
        Lollipop l2 = new Lollipop("Alyonka", 0.01, "Belarus", 0.005, "Sugary", Aroma.COCOA);
        Lollipop l3 = new Lollipop("Alyonka", 0.01, "Belarus", 0.005, "Sugary", Aroma.COCOA);
        ArrayList<Sweet> al = new ArrayList<>();
        al.add(l1);
        al.add(l2);
        al.add(l3);
        Gift gift = new Gift(al);
        double expected = l1.getWeight() + l2.getWeight() + l3.getWeight();
        double actual = gift.countWeight();
        Assert.assertEquals(expected, actual, 0);
    }
}
