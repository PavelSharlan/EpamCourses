package test.by.bsu.find;

import by.bsu.gift.action.Finder;
import by.bsu.gift.action.WeightSorter;
import by.bsu.gift.entity.*;
import by.bsu.gift.exception.IncorrectValueException;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by 7 on 24.05.2016.
 */
public class SweetFinderTest {
    @Test
    public void findSweets(){
        ArrayList<Sweet> actual = new ArrayList<>();
        ArrayList<Sweet> expected = new ArrayList<>();
        ArrayList<Sweet> tmp = new ArrayList<>();
        Lollipop l1 = new Lollipop("A", 0.01, "Belarus", 0.006, "Sugary", Aroma.COCOA);
        Lollipop l2 = new Lollipop("B", 0.01, "Belarus", 0.007, "Sugary", Aroma.COCOA);
        Lollipop l3 = new Lollipop("C", 0.01, "Belarus", 0.008, "Sugary", Aroma.COCOA);
        LollipopAtWand l4 = new LollipopAtWand("DD", 0.03, "Russia", 0.01, "Sour", Aroma.COLA, "Cockerel");
        actual.add(l2);
        actual.add(l3);
        tmp.add(l1);
        tmp.add(l2);
        tmp.add(l3);
        tmp.add(l4);
        Gift gift = new Gift(tmp);
        try {
            expected = Finder.find(gift, 0.007, 0.008);
        } catch (IncorrectValueException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(expected, actual);
    }
}
