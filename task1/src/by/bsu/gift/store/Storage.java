package by.bsu.gift.store;

import by.bsu.gift.entity.Sweet;
import by.bsu.gift.exception.IncorrectValueException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by 7 on 19.05.2016.
 */
public class Storage {
    private ArrayList<Sweet> sweets;

    public Storage(ArrayList<Sweet> sweets) {
        this.sweets = sweets;
    }

    public ArrayList<Sweet> getSweets() {
        return sweets;
    }

    public ArrayList<Sweet> takeSweets(int sweetCount) throws IncorrectValueException {
        if (sweetCount <= 0){
            throw new IncorrectValueException("Incorrect sweets value!");
        }
        if (sweetCount < sweets.size()){
            ArrayList<Sweet> gift = new ArrayList<>();
            for (int i = 0; i < sweetCount; i++){
                gift.add(sweets.get(i));
            }
            for (int i = 0; i < sweetCount; i++){
                sweets.remove(gift.get(i));
            }
            return gift;
        } else {
            throw new IncorrectValueException("Requested value is much more than capacity of the storage!");
        }
    }

    public boolean isEmpty(){
        return sweets.isEmpty();
    }
}
