package by.bsu.audioservice.logic;

import by.bsu.audioservice.dao.impl.UserAccountDAO;
import by.bsu.audioservice.exception.DAOException;
import by.bsu.audioservice.exception.TechnicalException;

/**
 * Created by 7 on 15.09.2016.
 */
public class BanAccountLogic {
    public static boolean ban(Long accountId) throws TechnicalException {
        boolean flag = false;
        try {
            flag = UserAccountDAO.getInstance().banAccount(accountId);
        } catch (DAOException e) {
            throw new TechnicalException("DAOException", e);
        }
        return flag;
    }
    public static boolean unban(Long accountId) throws TechnicalException {
        boolean flag = false;
        try {
            flag = UserAccountDAO.getInstance().unbanAccount(accountId);
        } catch (DAOException e) {
            throw new TechnicalException("DAOException", e);
        }
        return flag;
    }
}
