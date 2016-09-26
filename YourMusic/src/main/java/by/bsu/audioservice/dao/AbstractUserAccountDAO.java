package by.bsu.audioservice.dao;

import by.bsu.audioservice.entity.UserAccount;
import by.bsu.audioservice.exception.DAOException;

import java.util.ArrayList;

/**
 * Created by 7 on 10.08.2016.
 */
public abstract class AbstractUserAccountDAO {
    public abstract UserAccount findUserAccountByUserId(Long id) throws DAOException;
    public abstract boolean addUserAccount(UserAccount account) throws DAOException;
    public abstract boolean isAccountHasAudio(Long accountId, Long audioId) throws DAOException;
    public abstract boolean addAudio(Long accountId, Long audioId) throws DAOException;
    public abstract boolean updateBalance(Long accountId, Float balance) throws DAOException;
    public abstract boolean deleteAudioFromUserAccount(Long audioId, Long accountId) throws DAOException;
    public abstract ArrayList<UserAccount> takeAllAccounts() throws DAOException;
    public abstract boolean banAccount(Long accountId) throws DAOException;
    public abstract boolean unbanAccount(Long accountId) throws DAOException;
}
