package by.bsu.audioservice.dao;

import by.bsu.audioservice.entity.User;
import by.bsu.audioservice.exception.DAOException;

import java.util.ArrayList;

/**
 * Class AbstractUserDAO
 * <p>
 * Created by 7 on 24.07.2016.
 */
public abstract class AbstractUserDAO {
    /**
     * Find user by login and password
     *
     * @param login of type String
     * @param password of type String
     * @return User
     * @throws DAOException
     */
    public abstract User findUserByLoginAndPassword(String login, String password) throws DAOException;

    /**
     * Find user by email
     *
     * @param login of type String
     * @return User
     * @throws DAOException
     */
    public abstract User findUserByEmail(String login) throws DAOException;

    /**
     * Add user
     *
     * @param user of type User
     * @return boolean
     * @throws DAOException
     */
    public abstract boolean addUser(User user) throws DAOException;

    /**
     * Find user by user id
     *
     * @param id of type Long
     * @return User
     * @throws DAOException
     */
    public abstract User findUserByUserID(Long id) throws DAOException;

    /**
     * Edit user settings
     *
     * @param user of type User
     * @return boolean
     * @throws DAOException
     */
    public abstract boolean editUserSettings(User user) throws DAOException;

    /**
     * Change user password
     *
     * @param user of type User
     * @param newPassword of type String
     * @return boolean
     * @throws DAOException
     */
    public abstract boolean changeUserPassword(User user, String newPassword) throws DAOException;

    /**
     * Take all users
     *
     * @return ArrayList<User>
     * @throws DAOException
     */
    public abstract ArrayList<User> takeAllUsers() throws DAOException;

}
