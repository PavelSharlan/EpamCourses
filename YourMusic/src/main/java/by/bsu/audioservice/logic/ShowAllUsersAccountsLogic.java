package by.bsu.audioservice.logic;

import by.bsu.audioservice.dao.impl.UserAccountDAO;
import by.bsu.audioservice.entity.UserAccount;
import by.bsu.audioservice.exception.DAOException;
import by.bsu.audioservice.exception.TechnicalException;

import java.util.ArrayList;

/**
 * Class ShowAllUsersAccountsLogic
 *
 * Created by 7 on 10.09.2016.
 */
public class ShowAllUsersAccountsLogic {
    /**
     * Method show
     *
     * @return ArrayList<UserAccount>
     * @throws TechnicalException
     */
    public static ArrayList<UserAccount> show() throws TechnicalException {
        try {
            return UserAccountDAO.getInstance().takeAllAccounts();
        } catch (DAOException e) {
            throw new TechnicalException("DAOException", e);
        }
    }
}
