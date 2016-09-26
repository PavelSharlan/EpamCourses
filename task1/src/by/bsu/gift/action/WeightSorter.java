package by.bsu.gift.action;

import by.bsu.gift.entity.Gift;
import by.bsu.gift.entity.Sweet;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by 7 on 22.05.2016.
 */
public class WeightSorter {
    public static void sort(Gift gift){
        ArrayList<Sweet> temp = gift.getSweets();
        temp.sort(Comparator.comparing(Sweet::getWeight));
        gift.setSweets(temp);

    }
}
