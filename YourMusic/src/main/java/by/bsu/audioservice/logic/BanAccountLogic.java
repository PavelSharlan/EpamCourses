package by.bsu.audioservice.logic;

import by.bsu.audioservice.dao.impl.UserAccountDAO;
import by.bsu.audioservice.exception.DAOException;
import by.bsu.audioservice.exception.TechnicalException;

/**
 * Class BanAccountLogic
 *
 * Created by 7 on 15.09.2016.
 */
public class BanAccountLogic {
    /**
     * Method ban
     *
     * @param accountId of type Long
     * @return boolean
     * @throws TechnicalException
     */
    public static boolean ban(Long accountId) throws TechnicalException {
        boolean flag = false;
        try {
            flag = UserAccountDAO.getInstance().banAccount(accountId);
        } catch (DAOException e) {
            throw new TechnicalException("DAOException", e);
        }
        return flag;
    }

    /**
     * Method unban
     *
     * @param accountId of type Long
     * @return boolean
     * @throws TechnicalException
     */
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
