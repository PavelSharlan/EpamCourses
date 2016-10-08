package by.bsu.audioservice.logic;

import by.bsu.audioservice.dao.impl.AudioDAO;
import by.bsu.audioservice.entity.Audio;
import by.bsu.audioservice.exception.DAOException;
import by.bsu.audioservice.exception.LogicException;
import by.bsu.audioservice.exception.TechnicalException;

/**
 * Class EditAudioInfoLogic
 *
 * Created by 7 on 12.09.2016.
 */
public class EditAudioInfoLogic {
    /**
     * Method takeAudio
     *
     * @param id of type Long
     * @return Audio
     * @throws TechnicalException
     */
    public static Audio takeAudio(Long id) throws TechnicalException {
        try {
            return AudioDAO.getInstance().takeAudioByAudioId(id);
        } catch (DAOException e) {
            throw new TechnicalException("DAOException", e);
        }
    }

    /**
     * Method edit
     *
     * @param currentAudio of type Audio
     * @param newAudio of type Audio
     * @throws LogicException
     * @throws TechnicalException
     */
    public static void edit(Audio currentAudio, Audio newAudio) throws LogicException, TechnicalException {
        if (!currentAudio.equals(newAudio)){
            try {
                AudioDAO.getInstance().editAudioInfo(newAudio);
            } catch (DAOException e) {
                throw new TechnicalException("DAOException", e);
            }
        } else {
            throw new LogicException("Old information about audio");
        }
    }
}
