package by.bsu.audioservice.dao;

import by.bsu.audioservice.entity.Audio;
import by.bsu.audioservice.entity.Basket;
import by.bsu.audioservice.entity.Purchase;
import by.bsu.audioservice.entity.UserAccount;
import by.bsu.audioservice.exception.DAOException;

import java.util.ArrayList;

/**
 * Class AbstractPurchaseDAO
 *
 * Created by 7 on 07.09.2016.
 */
public abstract class AbstractPurchaseDAO {
    /**
     * Add purchase
     *
     * @param purchase of type Purchase
     * @return boolean
     * @throws DAOException
     */
    public abstract boolean addPurchaseToBasket(Purchase purchase) throws DAOException;

    /**
     * Is basket has audio
     *
     * @param accountId of type Long
     * @param audioId of type Long
     * @return boolean
     * @throws DAOException
     */
    public abstract boolean isBasketHasAudio(Long accountId, Long audioId) throws DAOException;

    /**
     * Get basket.
     *
     * @param account of type UserAccount
     * @return Basket
     * @throws DAOException
     */
    public abstract Basket getBasket(UserAccount account) throws DAOException;

    /**
     * Delete purchase by id
     *
     * @param id of type Long
     * @return boolean
     * @throws DAOException
     */
    public abstract boolean deletePurchaseById(Long id) throws DAOException;

    /**
     * Gets basket price.
     *
     * @param accountId of type Long
     * @return Float
     * @throws DAOException
     */
    public abstract Float getBasketPrice(Long accountId) throws DAOException;

    /**
     * Gets audios id from basket.
     *
     * @param accountId of type Long
     * @return ArrayList<Long>
     * @throws DAOException
     */
    public abstract ArrayList<Long> getAudiosIdFromBasket(Long accountId) throws DAOException;

    /**
     * Delete purchases from basket
     *
     * @param accountId of type Long
     * @return boolean
     * @throws DAOException
     */
    public abstract boolean deletePurchasesFromBasket(Long accountId) throws DAOException;
}
