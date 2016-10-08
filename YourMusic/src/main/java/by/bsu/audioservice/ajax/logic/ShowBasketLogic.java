package by.bsu.audioservice.ajax.logic;

import by.bsu.audioservice.dao.impl.PurchaseDAO;
import by.bsu.audioservice.entity.Basket;
import by.bsu.audioservice.entity.Purchase;
import by.bsu.audioservice.entity.UserAccount;
import by.bsu.audioservice.exception.DAOException;
import by.bsu.audioservice.exception.TechnicalException;
import org.json.simple.JSONObject;

import java.util.ArrayList;

/**
 * ShowBasketLogic
 *
 * Created by 7 on 08.09.2016.
 */
public class ShowBasketLogic {

    /** Field PURCHASES */
    private static final String PURCHASES = "purchases";

    /**
     * Method show ...
     *
     * @param account of type UserAccount
     * @return String
     * @throws TechnicalException
     */
    public static String show(UserAccount account) throws TechnicalException {
        Basket basket = null;
        JSONObject json = null;
        try {
            basket = PurchaseDAO.getInstance().getBasket(account);
            ArrayList<Purchase> purchases = basket.getPurchases();
            json = new JSONObject();
            json.put(PURCHASES, purchases);
        } catch (DAOException e) {
            throw new TechnicalException("DAOException", e);
        }
        return json.toJSONString();
    }
}
