package by.bsu.audioservice.logic;

import by.bsu.audioservice.dao.impl.UserDAO;
import by.bsu.audioservice.entity.User;
import by.bsu.audioservice.exception.DAOException;
import by.bsu.audioservice.exception.LogicException;
import by.bsu.audioservice.exception.TechnicalException;
import by.bsu.audioservice.valid.UserDataValidator;

/**
 * Class EditUserSettingsLogic
 *
 * Created by 7 on 16.08.2016.
 */
public class EditUserSettingsLogic {
    /**
     * Method editSettings
     *
     * @param currentUser of type User
     * @param newUser of type User
     * @throws LogicException
     * @throws TechnicalException
     */
    public static void editSettings(User currentUser, User newUser) throws LogicException, TechnicalException {
        if (UserDataValidator.validate(newUser)) {
            if (!isOldData(currentUser, newUser)) {
                try {
                    UserDAO.getInstance().editUserSettings(newUser);
                } catch (DAOException e) {
                    throw new TechnicalException("DAOException", e);
                }
            }
        }
    }

    /**
     * Method isOldData
     *
     * @param currentUser of type User
     * @param newUser of type User
     * @return
     */
    private static boolean isOldData(User currentUser, User newUser){
        boolean flag = false;
        if (currentUser.getEmail().equals(newUser.getEmail()) && currentUser.getFirstName().equals(newUser.getFirstName()) &&
                currentUser.getSecondName().equals(newUser.getSecondName()) && currentUser.getPhoneNumber().equals(newUser.getPhoneNumber())){
            flag = true;
        }
        return flag;
    }
}
