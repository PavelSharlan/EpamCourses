package by.bsu.audioservice.dao;

import by.bsu.audioservice.entity.Audio;
import by.bsu.audioservice.entity.Basket;
import by.bsu.audioservice.entity.Purchase;
import by.bsu.audioservice.entity.UserAccount;
import by.bsu.audioservice.exception.DAOException;

import java.util.ArrayList;

/**
 * Created by 7 on 07.09.2016.
 */
public abstract class AbstractPurchaseDAO {
    public abstract boolean addPurchaseToBasket(Purchase purchase) throws DAOException;
    public abstract boolean isBasketHasAudio(Long accountId, Long audioId) throws DAOException;
    public abstract Basket getBasket(UserAccount account) throws DAOException;
    public abstract boolean deletePurchaseById(Long id) throws DAOException;
    public abstract Float getBasketPrice(Long accountId) throws DAOException;
    public abstract ArrayList<Long> getAudiosIdFromBasket(Long accountId) throws DAOException;
    public abstract boolean deletePurchasesFromBasket(Long accountId) throws DAOException;
}
