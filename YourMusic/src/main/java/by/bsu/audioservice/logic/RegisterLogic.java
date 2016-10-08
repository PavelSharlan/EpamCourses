package by.bsu.audioservice.logic;

import by.bsu.audioservice.dao.impl.UserAccountDAO;
import by.bsu.audioservice.dao.impl.UserDAO;
import by.bsu.audioservice.entity.User;
import by.bsu.audioservice.entity.UserAccount;
import by.bsu.audioservice.exception.DAOException;
import by.bsu.audioservice.exception.LogicException;
import by.bsu.audioservice.exception.TechnicalException;
import by.bsu.audioservice.util.MD5Hash;

/**
 * Class RegisterLogic
 *
 * Created by 7 on 06.08.2016.
 */
public class RegisterLogic {
    /**
     * Method checkUserByEmail
     *
     * @param email of type String
     * @return User
     * @throws LogicException
     * @throws TechnicalException
     */
    public static User checkUserByEmail(String email) throws LogicException, TechnicalException {
        User user = null;
        try {
            user = UserDAO.getInstance().findUserByEmail(email);
            if (user != null) {
                throw new LogicException("There is a user with such email!");
            } else {
                return user;
            }
        } catch (DAOException e) {
            throw new TechnicalException("DAOException", e);
        }
    }

    /**
     * Method addUser
     *
     * @param user of type User
     * @throws TechnicalException
     */
    public static void addUser(User user) throws TechnicalException {
        String hashPass = MD5Hash.md5Custom(user.getPassword());
        user.setPassword(hashPass);
        try {
            UserDAO.getInstance().addUser(user);
        } catch (DAOException e) {
            throw new TechnicalException("DAOException", e);
        }
    }

    /**
     * Method addUserAccount
     *
     * @param account of type UserAccount
     * @throws TechnicalException
     */
    public static void addUserAccount(UserAccount account) throws TechnicalException {
        try {
            UserAccountDAO.getInstance().addUserAccount(account);
        } catch (DAOException e) {
            throw new TechnicalException("DAOException", e);
        }
    }
}
