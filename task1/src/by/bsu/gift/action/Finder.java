package by.bsu.gift.action;

import by.bsu.gift.entity.Gift;
import by.bsu.gift.entity.Sweet;
import by.bsu.gift.exception.IncorrectValueException;

import java.util.ArrayList;

/**
 * Created by 7 on 22.05.2016.
 */
public class Finder {
    public static ArrayList<Sweet> find(Gift gift, double minSugarContent, double maxSugarContent) throws IncorrectValueException {
        if (minSugarContent < 0 || maxSugarContent < 0 || maxSugarContent < minSugarContent){
            throw new IncorrectValueException("Incorrect arguments!");
        }
        ArrayList<Sweet> result = new ArrayList<>();
        ArrayList<Sweet> tmp = gift.getSweets();
        for(Sweet sweet: tmp){
            if(sweet.getSugar() >= minSugarContent && maxSugarContent >= sweet.getSugar()){
                result.add(sweet);
            }
        }
        return result;
    }
}
