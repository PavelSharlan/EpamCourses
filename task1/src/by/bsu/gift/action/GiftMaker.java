package by.bsu.gift.action;

import by.bsu.gift.entity.Gift;
import by.bsu.gift.exception.IncorrectValueException;
import by.bsu.gift.store.Storage;

/**
 * Created by 7 on 22.05.2016.
 */
public class GiftMaker {
    public static Gift make(Storage storage, int count) throws IncorrectValueException {
        return new Gift(storage.takeSweets(count));
    }
}
