package by.bsu.audioservice.logic;

import by.bsu.audioservice.dao.impl.AudioDAO;
import by.bsu.audioservice.entity.Audio;
import by.bsu.audioservice.entity.UserAccount;
import by.bsu.audioservice.exception.DAOException;
import by.bsu.audioservice.exception.TechnicalException;

import java.util.ArrayList;

/**
 * Class ShowUserAudioLogic
 *
 * Created by 7 on 18.08.2016.
 */
public class ShowUserAudioLogic {
    /**
     * Method getUserAccountAudios
     *
     * @param userAccount of type UserAccount
     * @return ArrayList<Audio>
     * @throws TechnicalException
     */
    public static ArrayList<Audio> getUserAccountAudios(UserAccount userAccount) throws TechnicalException {
        try {
            return AudioDAO.getInstance().takeUserAccountAudios(userAccount);
        } catch (DAOException e) {
            throw new TechnicalException("DAOException", e);
        }
    }
}
