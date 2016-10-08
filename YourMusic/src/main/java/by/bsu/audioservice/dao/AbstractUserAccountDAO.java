package by.bsu.audioservice.dao;

import by.bsu.audioservice.entity.UserAccount;
import by.bsu.audioservice.exception.DAOException;

import java.util.ArrayList;

/**
 * Class AbstractUserAccountDAO
 *
 * Created by 7 on 10.08.2016.
 */
public abstract class AbstractUserAccountDAO {
    /**
     * Find user account by user id
     *
     * @param id of type Long
     * @return UserAccount
     * @throws DAOException
     */
    public abstract UserAccount findUserAccountByUserId(Long id) throws DAOException;

    /**
     * Add user account
     *
     * @param account of type UserAccount
     * @return boolean
     * @throws DAOException
     */
    public abstract boolean addUserAccount(UserAccount account) throws DAOException;

    /**
     * Is account has audio
     *
     * @param accountId of type Long
     * @param audioId of type Long
     * @return boolean
     * @throws DAOException
     */
    public abstract boolean isAccountHasAudio(Long accountId, Long audioId) throws DAOException;

    /**
     * Add audio
     *
     * @param accountId of type Long
     * @param audioId   of type Long
     * @return boolean
     * @throws DAOException
     */
    public abstract boolean addAudio(Long accountId, Long audioId) throws DAOException;

    /**
     * Update balance
     *
     * @param accountId of type Long
     * @param balance of type Float
     * @return boolean
     * @throws DAOException
     */
    public abstract boolean updateBalance(Long accountId, Float balance) throws DAOException;

    /**
     * Delete audio from user account
     *
     * @param audioId of type Long
     * @param accountId of type Long
     * @return boolean
     * @throws DAOException
     */
    public abstract boolean deleteAudioFromUserAccount(Long audioId, Long accountId) throws DAOException;

    /**
     * Take all accounts
     *
     * @return ArrayList<UserAccount>
     * @throws DAOException
     */
    public abstract ArrayList<UserAccount> takeAllAccounts() throws DAOException;

    /**
     * Ban account
     *
     * @param accountId of type Long
     * @return boolean
     * @throws DAOException
     */
    public abstract boolean banAccount(Long accountId) throws DAOException;

    /**
     * Unban account
     *
     * @param accountId of type Long
     * @return boolean
     * @throws DAOException
     */
    public abstract boolean unbanAccount(Long accountId) throws DAOException;
}
