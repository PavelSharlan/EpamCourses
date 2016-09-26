package by.bsu.audioservice.logic;

import by.bsu.audioservice.dao.impl.UserDAO;
import by.bsu.audioservice.entity.User;
import by.bsu.audioservice.exception.DAOException;
import by.bsu.audioservice.exception.LogicException;
import by.bsu.audioservice.exception.TechnicalException;
import by.bsu.audioservice.util.MD5Hash;

/**
 * Created by 7 on 16.08.2016.
 */
public class ChangePasswordLogic {
    public static void change(User user, String password, String newPassword, String newPasswordAgain) throws LogicException, TechnicalException {
        String hashPass = MD5Hash.md5Custom(password);
        if (!user.getPassword().equals(hashPass)){
            throw new LogicException("Wrong password!");
        }
        if (!newPassword.equals(newPasswordAgain)){
            throw new LogicException("Passwords don't match!");
        }
        try {
            UserDAO.getInstance().changeUserPassword(user, MD5Hash.md5Custom(newPassword));
        } catch (DAOException e) {
            throw new TechnicalException("DAOException", e);
        }
    }
}
