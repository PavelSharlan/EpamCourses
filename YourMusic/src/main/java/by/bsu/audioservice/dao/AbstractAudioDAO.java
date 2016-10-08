package by.bsu.audioservice.dao;

import by.bsu.audioservice.entity.Audio;
import by.bsu.audioservice.entity.Genre;
import by.bsu.audioservice.entity.User;
import by.bsu.audioservice.entity.UserAccount;
import by.bsu.audioservice.exception.DAOException;

import java.util.ArrayList;

/**
 * Class AbstractAudioDAO
 *
 * Created by 7 on 18.08.2016.
 */
public abstract class AbstractAudioDAO {
    /**
     * Method takeUserAccountAudios
     *
     * @param userAccount of type UserAccount
     * @return ArrayList<Audio>
     * @throws DAOException the dao exception
     */
    public abstract ArrayList<Audio> takeUserAccountAudios(UserAccount userAccount) throws DAOException;

    /**
     * Method takeAllDemoAudio
     *
     * @return ArrayList<Audio>
     * @throws DAOException the dao exception
     */
    public abstract ArrayList<Audio> takeAllDemoAudio() throws DAOException;

    /**
     * Take audios by genre
     *
     * @param genreStr of type String
     * @return ArrayList<Audio>
     * @throws DAOException
     */
    public abstract ArrayList<Audio> takeAudiosByGenre(String genreStr) throws DAOException;

    /**
     * Take all audios
     *
     * @return ArrayList<Audio>
     * @throws DAOException the dao exception
     */
    public abstract ArrayList<Audio> takeAllAudios() throws DAOException;

    /**
     * Add audio
     *
     * @param audio of type Audio
     * @return boolean
     * @throws DAOException the dao exception
     */
    public abstract boolean addAudio(Audio audio) throws DAOException;

    /**
     * Add demo audio
     *
     * @param audio of type Audio
     * @param demoURL of type String
     * @return boolean
     * @throws DAOException
     */
    public abstract boolean addDemoAudio(Audio audio, String demoURL) throws DAOException;

    /**
     * Take audioId by url
     *
     * @param url of type String
     * @return Long
     * @throws DAOException
     */
    public abstract Long takeAudioIdByURL(String url) throws DAOException;

    /**
     * Take audio by url
     *
     * @param url of type String
     * @return Audio
     * @throws DAOException
     */
    public abstract Audio takeAudioByURL(String url) throws DAOException;

    /**
     * Take genreId by genre
     *
     * @param genre of type Genre
     * @return Long
     * @throws DAOException
     */
    public abstract Long takeGenreIdByGenre(Genre genre) throws DAOException;

    /**
     * Edit audio info
     *
     * @param audio of type Audio
     * @return boolean
     * @throws DAOException
     */
    public abstract boolean editAudioInfo(Audio audio) throws DAOException;

    /**
     * Add genre to new audio
     *
     * @param genreId of type Long
     * @param audioId of type Long
     * @return boolean
     * @throws DAOException
     */
    public abstract boolean addGenreToNewAudio(Long genreId, Long audioId) throws DAOException;

    /**
     * Is audio exist
     *
     * @param singer of type String
     * @param name   of type String
     * @return boolean
     * @throws DAOException
     */
    public abstract boolean isExist(String singer, String name) throws DAOException;

    /**
     * Take audio by audioId
     *
     * @param id of type Long
     * @return Audio
     * @throws DAOException
     */
    public abstract Audio takeAudioByAudioId(Long id) throws DAOException;
}
