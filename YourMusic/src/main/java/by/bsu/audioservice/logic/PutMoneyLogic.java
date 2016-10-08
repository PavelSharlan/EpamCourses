package by.bsu.audioservice.logic;

import by.bsu.audioservice.dao.impl.UserAccountDAO;
import by.bsu.audioservice.exception.DAOException;
import by.bsu.audioservice.exception.TechnicalException;

/**
 * Class PutMoneyLogic
 *
 * Created by 7 on 13.09.2016.
 */
public class PutMoneyLogic {
    /**
     * Method put
     *
     * @param accountId of type Long
     * @param money of type Float
     * @throws TechnicalException
     */
    public static void put(Long accountId, Float money) throws TechnicalException {
        try {
            UserAccountDAO.getInstance().updateBalance(accountId, money);
        } catch (DAOException e) {
            throw new TechnicalException("DAOException", e);
        }
    }
}

