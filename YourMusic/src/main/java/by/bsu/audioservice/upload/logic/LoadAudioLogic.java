package by.bsu.audioservice.upload.logic;

import by.bsu.audioservice.dao.impl.AudioDAO;
import by.bsu.audioservice.entity.Audio;
import by.bsu.audioservice.entity.Genre;
import by.bsu.audioservice.exception.DAOException;
import by.bsu.audioservice.exception.LogicException;
import by.bsu.audioservice.exception.TechnicalException;
import by.bsu.audioservice.valid.AudioDataValidator;

/**
 * Created by 7 on 02.09.2016.
 */
public class LoadAudioLogic {
    public static void loadAudio(String singer, String name, String audioUrl, String price, String genreStr, String demoUrl) throws TechnicalException, LogicException {
        Audio audio = null;
        if (AudioDataValidator.isCorrectPrice(price) & AudioDataValidator.isCorrectGenre(genreStr)){
            audio = new Audio(singer, name, audioUrl, new Float(price), Genre.valueOf(genreStr.toUpperCase()));
            try {
                if (!AudioDAO.getInstance().isExist(singer, name)) {
                    AudioDAO.getInstance().addAudio(audio);
                    Long audioId = AudioDAO.getInstance().takeAudioIdByURL(audioUrl);
                    audio.setAudioId(audioId);
                    Genre genre = Genre.valueOf(genreStr.toUpperCase());
                    Long genreId = AudioDAO.getInstance().takeGenreIdByGenre(genre);
                    AudioDAO.getInstance().addGenreToNewAudio(genreId, audioId);
                    AudioDAO.getInstance().addDemoAudio(audio, demoUrl);
                } else {
                    throw new LogicException("There is such audio on site!");
                }
            } catch (DAOException e) {
                throw new TechnicalException("DAOException", e);
            }
        }
    }
}
