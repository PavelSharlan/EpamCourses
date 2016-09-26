package test.by.bsu.sort;

import by.bsu.gift.action.WeightSorter;
import by.bsu.gift.entity.Aroma;
import by.bsu.gift.entity.Gift;
import by.bsu.gift.entity.Lollipop;
import by.bsu.gift.entity.Sweet;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by 7 on 24.05.2016.
 */
public class SorterTest {
    @Test
    public void sortWeight(){
        Lollipop l1 = new Lollipop("A", 0.01, "Belarus", 0.005, "Sugary", Aroma.COCOA);
        Lollipop l2 = new Lollipop("B", 0.015, "Belarus", 0.005, "Sugary", Aroma.LEMON);
        Lollipop l3 = new Lollipop("C", 0.008, "Belarus", 0.005, "Sugary", Aroma.BARBERRY);
        ArrayList<Sweet> actual = new ArrayList<>();
        actual.add(l1);
        actual.add(l2);
        actual.add(l3);
        Gift gift = new Gift(actual);

        WeightSorter.sort(gift);
        actual = gift.getSweets();
        ArrayList<Sweet> expected = new ArrayList<>();
        expected.add(l3);
        expected.add(l1);
        expected.add(l2);
        Assert.assertEquals(expected, actual);
    }
}
