package by.bsu.audioservice.logic;

import by.bsu.audioservice.dao.impl.AudioDAO;
import by.bsu.audioservice.entity.Audio;
import by.bsu.audioservice.entity.Genre;
import by.bsu.audioservice.exception.DAOException;
import by.bsu.audioservice.exception.TechnicalException;

import java.util.ArrayList;

/**
 * Class SortAudioByGenreLogic
 *
 * Created by 7 on 26.08.2016.
 */
public class SortAudioByGenreLogic {
    /**
     * Method getAudiosByGenre
     *
     * @param genre of type String
     * @return ArrayList<Audio>
     * @throws TechnicalException
     */
    public static ArrayList<Audio> getAudiosByGenre(String genre) throws TechnicalException {
        ArrayList<Audio> audios = null;
        try {
            if (genre.toUpperCase().equals(Genre.POP.toString()) || genre.toUpperCase().equals(Genre.ROCK.toString())) {
                audios = AudioDAO.getInstance().takeAudiosByGenre(genre);
            } else{
                if (genre.toUpperCase().equals(Genre.HIP_HOP.toString())){
                    genre = replaceUnderline(genre);
                    audios = AudioDAO.getInstance().takeAudiosByGenre(genre);
                } else {
                    audios = AudioDAO.getInstance().takeAllDemoAudio();
                }
            }
        } catch (DAOException e){
            throw new TechnicalException("DAOException", e);
        }
        return audios;
    }

    /**
     * Method replaceUnderline
     *
     * @param str of type String
     * @return String
     */
    private static String replaceUnderline(String str){
        return str.replace('_', '-');
    }

}
