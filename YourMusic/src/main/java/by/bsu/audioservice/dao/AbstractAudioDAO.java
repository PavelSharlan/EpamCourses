package by.bsu.audioservice.dao;

import by.bsu.audioservice.entity.Audio;
import by.bsu.audioservice.entity.Genre;
import by.bsu.audioservice.entity.User;
import by.bsu.audioservice.entity.UserAccount;
import by.bsu.audioservice.exception.DAOException;

import java.util.ArrayList;

/**
 * Created by 7 on 18.08.2016.
 */
public abstract class AbstractAudioDAO {
    public abstract ArrayList<Audio> takeUserAccountAudios(UserAccount userAccount) throws DAOException;
    public abstract ArrayList<Audio> takeAllDemoAudio() throws DAOException;
    public abstract ArrayList<Audio> takeAudiosByGenre(String genreStr) throws DAOException;
    public abstract ArrayList<Audio> takeAllAudios() throws DAOException;
    public abstract boolean addAudio(Audio audio) throws DAOException;
    public abstract boolean addDemoAudio(Audio audio, String demoURL) throws DAOException;
    public abstract Long takeAudioIdByURL(String url) throws DAOException;
    public abstract Audio takeAudioByURL(String url) throws DAOException;
    public abstract Long takeGenreIdByGenre(Genre genre) throws DAOException;
    public abstract boolean editAudioInfo(Audio audio) throws DAOException;
    public abstract boolean addGenreToNewAudio(Long genreId, Long audioId) throws DAOException;
    public abstract boolean isExist(String singer, String name) throws DAOException;
    public abstract Audio takeAudioByAudioId(Long id) throws DAOException;
}
