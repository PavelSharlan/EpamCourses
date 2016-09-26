package by.bsu.audioservice.dao;

import by.bsu.audioservice.entity.User;
import by.bsu.audioservice.exception.DAOException;

import java.util.ArrayList;

/**
 * Created by 7 on 24.07.2016.
 */
public abstract class AbstractUserDAO {
    public abstract User findUserByLoginAndPassword(String login, String password) throws DAOException;
    public abstract User findUserByEmail(String login) throws DAOException;
    public abstract boolean addUser(User user) throws DAOException;
    public abstract User findUserByUserID(Long id) throws DAOException;
    public abstract boolean editUserSettings(User user) throws DAOException;
    public abstract boolean changeUserPassword(User user, String newPassword) throws DAOException;
    public abstract ArrayList<User> takeAllUsers() throws DAOException;

}
