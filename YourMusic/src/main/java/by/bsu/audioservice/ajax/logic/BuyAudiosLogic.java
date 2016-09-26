package by.bsu.audioservice.ajax.logic;

import by.bsu.audioservice.dao.impl.PurchaseDAO;
import by.bsu.audioservice.dao.impl.UserAccountDAO;
import by.bsu.audioservice.entity.UserAccount;
import by.bsu.audioservice.exception.DAOException;
import by.bsu.audioservice.exception.TechnicalException;

import java.util.ArrayList;

/**
 * Created by 7 on 09.09.2016.
 */
public class BuyAudiosLogic {
    public static boolean buy(UserAccount account) throws TechnicalException {
        boolean flag = false;
        try {
            Float balance = account.getBalance();
            Long accountId = account.getUserAccountId();
            Float basketPrice = PurchaseDAO.getInstance().getBasketPrice(accountId);
            if (balance >= basketPrice & basketPrice != 0){
                balance = balance - basketPrice;
                account.setBalance(balance);
                ArrayList<Long> audiosId = PurchaseDAO.getInstance().getAudiosIdFromBasket(accountId);
                for (Long i: audiosId){
                    UserAccountDAO.getInstance().addAudio(accountId, i);
                }
                UserAccountDAO.getInstance().updateBalance(accountId, balance);
                PurchaseDAO.getInstance().deletePurchasesFromBasket(accountId);
                flag = true;
            }
        } catch (DAOException e) {
            throw new TechnicalException("DAOException", e);
        }
        return flag;
    }
}
