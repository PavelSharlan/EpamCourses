package by.bsu.audioservice.logic;

import by.bsu.audioservice.dao.impl.AudioDAO;
import by.bsu.audioservice.entity.Audio;
import by.bsu.audioservice.exception.DAOException;
import by.bsu.audioservice.exception.TechnicalException;

import java.util.ArrayList;

/**
 * Created by 7 on 19.08.2016.
 */
public class ShowAllAudioLogic {
    public static ArrayList<Audio> getAllDemoAudios() throws TechnicalException {
        try {
            return AudioDAO.getInstance().takeAllDemoAudio();
        } catch (DAOException e) {
            throw new TechnicalException("DAOException", e);
        }
    }
    public static ArrayList<Audio> getAllAudios() throws TechnicalException {
        try{
            return AudioDAO.getInstance().takeAllAudios();
        } catch (DAOException e) {
            throw new TechnicalException("DAOException", e);
        }
    }
}
