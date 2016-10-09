package by.bsu.audioservice.logic;

import by.bsu.audioservice.dao.impl.UserDAO;
import by.bsu.audioservice.entity.User;
import by.bsu.audioservice.exception.DAOException;
import by.bsu.audioservice.exception.LogicException;
import by.bsu.audioservice.exception.TechnicalException;
import by.bsu.audioservice.util.MD5Hash;
import by.bsu.audioservice.valid.PasswordValidator;

/**
 * Class ChangePasswordLogic
 *
 * Created by 7 on 16.08.2016.
 */
public class ChangePasswordLogic {
    /**
     * Method change
     *
     * @param user of type User
     * @param password of type String
     * @param newPassword of type String
     * @param newPasswordAgain of type String
     * @throws LogicException
     * @throws TechnicalException
     */
    public static void change(User user, String password, String newPassword, String newPasswordAgain) throws LogicException, TechnicalException {
        String hashPass = MD5Hash.md5Custom(password);
        if (PasswordValidator.validate(password) && PasswordValidator.validate(newPassword)
                && PasswordValidator.validate(newPasswordAgain)){
            throw new LogicException("Incorrect password!");
        }
        if (!user.getPassword().equals(hashPass)){
            throw new LogicException("Wrong password!");
        }
        if (!newPassword.equals(newPasswordAgain)){
            throw new LogicException("Passwords don't match!");
        }
        if (!newPassword.equals(password)){
            throw new LogicException("Old and new password are not the same!");
        }
        try {
            UserDAO.getInstance().changeUserPassword(user, MD5Hash.md5Custom(newPassword));
        } catch (DAOException e) {
            throw new TechnicalException("DAOException", e);
        }
    }
}
