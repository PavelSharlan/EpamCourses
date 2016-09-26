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
 * Created by 7 on 06.08.2016.
 */
public class LoginLogic {
    public static User findUserByEmailAndPassword(String email, String password) throws LogicException, TechnicalException {
        String hashPass = MD5Hash.md5Custom(password);
        User user = null;
        try{
            user = UserDAO.getInstance().findUserByLoginAndPassword(email, hashPass);
            if (user == null){
                throw new LogicException("Incorrect email or password!");
            }
        } catch (DAOException e) {
            throw new TechnicalException("DAOException", e);
        }
        return user;
    }

    public static UserAccount findUserAccountByUserID(Long id) throws LogicException, TechnicalException {
        UserAccount account = null;
        try {
            account = UserAccountDAO.getInstance().findUserAccountByUserId(id);
            if (account == null){
                throw new LogicException("There is no such account!");
            }
        } catch (DAOException e) {
            throw new TechnicalException("DAOException", e);
        }
        return account;
    }
    public static boolean isBanned(UserAccount account){
        return account.getEndDate() != null;
    }
}
