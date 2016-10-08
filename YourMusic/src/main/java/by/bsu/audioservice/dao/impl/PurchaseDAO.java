package by.bsu.audioservice.dao.impl;

import by.bsu.audioservice.dao.AbstractPurchaseDAO;
import by.bsu.audioservice.entity.*;
import by.bsu.audioservice.exception.DAOException;
import by.bsu.audioservice.pool.ConnectionPool;
import by.bsu.audioservice.pool.ProxyConnection;
import by.bsu.audioservice.util.GenreUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Class PurchaseDAO
 *
 * Created by 7 on 07.09.2016.
 */
public class PurchaseDAO extends AbstractPurchaseDAO {
    /** Field PURCHASE_ID */
    private static final String PURCHASE_ID = "purchase_id";

    /** Field AUDIO_ID */
    private static final String AUDIO_ID = "audio_id";

    /** Field NAME */
    private static final String NAME = "name";

    /** Field SINGER */
    private static final String SINGER = "singer";

    /** Field URL */
    private static final String URL = "url";

    /** Field PRICE */
    private static final String PRICE = "price";

    /** Field Genre */
    private static final String GENRE = "genre";

    /** Field SQL_INSERT_PURCHASE_INTO_BASKET */
    private static final String SQL_INSERT_PURCHASE_INTO_BASKET =
            "INSERT INTO basket (fk_account_id, audio_id) VALUES (?, ?)";

    /** Field SQL_IS_BASKET_HAS_AUDIO */
    private static final String SQL_IS_BASKET_HAS_AUDIO = "SELECT purchase_id FROM basket WHERE basket.fk_account_id = ? " +
            "AND basket.audio_id = ?;";

    /** Field SQL_SELECT_BASKET_PRICE */
    private static final String SQL_SELECT_BASKET_PRICE = "SELECT sum(audios.price) as price FROM audios JOIN basket JOIN accounts " +
            "ON accounts.account_id = basket.fk_account_id AND basket.audio_id = audios.audio_id" +
            " WHERE accounts.account_id = ?;";

    /** Field SQL_SELECT_BASKET_BY_ACCOUNT_ID */
    private static final String SQL_SELECT_BASKET_BY_ACCOUNT_ID = "SELECT basket.purchase_id, basket.fk_account_id," +
            " basket.audio_id, audios.name, audios.singer, " +
            "audios.url, audios.price, genres.genre FROM audios JOIN basket JOIN genres JOIN audios_has_genre " +
            "ON basket.audio_id = audios.audio_id AND basket.audio_id = audios_has_genre.audio_id " +
            "AND audios_has_genre.genre_id = genres.genre_id AND basket.fk_account_id = ?;";

    /** Field SQL_DELETE_PURCHASE_BY_ID */
    private static final String SQL_DELETE_PURCHASE_BY_ID = "DELETE FROM basket WHERE purchase_id = ?;";

    /** Field SQL_DELETE_PURCHASES_FROM_BASKET_BY_ACCOUNT_ID */
    private static final String SQL_DELETE_PURCHASES_FROM_BASKET_BY_ACCOUNT_ID = "DELETE FROM BASKET WHERE basket.fk_account_id = ?;";

    /** Field SQL_SELECT_AUDIOS_ID_FROM_BASKET */
    private static final String SQL_SELECT_AUDIOS_ID_FROM_BASKET = "SELECT audios.audio_id FROM audios JOIN basket" +
            " JOIN accounts ON audios.audio_id = basket.audio_id AND basket.fk_account_id = accounts.account_id WHERE " +
            "accounts.account_id = ?;";

    /** Field instance */
    private static PurchaseDAO instance = PurchaseDAO.getInstance() ;

    /**
     * Instantiates a new PurchaseDAO
     */
    private PurchaseDAO(){
    }

    /**
     * Method getInstance
     *
     * @return PurchaseDAO
     */
    public static PurchaseDAO getInstance(){
        if (instance == null){
            instance = new PurchaseDAO();
        }
        return instance;
    }

    /**
     * Method addPurchaseToBasket
     *
     * @param purchase of type Purchase
     * @return boolean
     * @throws DAOException
     */
    @Override
    public boolean addPurchaseToBasket(Purchase purchase) throws DAOException {
        boolean flag = false;
        try(ProxyConnection cn = ConnectionPool.getInstance().takeConnection();
        PreparedStatement st = cn.prepareStatement(SQL_INSERT_PURCHASE_INTO_BASKET)){
            st.setLong(1, purchase.getUserAccount().getUserAccountId());
            st.setLong(2, purchase.getAudio().getAudioId());
            st.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            throw new DAOException("SQLException", e);
        }
        return flag;
    }

    /**
     * Method isBasketHasAudio
     *
     * @param accountId of type Long
     * @param audioId of type Long
     * @return boolean
     * @throws DAOException
     */
    @Override
    public boolean isBasketHasAudio(Long accountId, Long audioId) throws DAOException {
        boolean flag = false;
        try(ProxyConnection cn = ConnectionPool.getInstance().takeConnection();
        PreparedStatement st = cn.prepareStatement(SQL_IS_BASKET_HAS_AUDIO)){
            st.setLong(1, accountId);
            st.setLong(2, audioId);
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                flag = true;
            }
        } catch (SQLException e) {
            throw new DAOException("SQLException", e);
        }
        return flag;
    }

    /**
     * Method getBasket
     *
     * @param account of type UserAccount
     * @return Basket
     * @throws DAOException
     */
    @Override
    public Basket getBasket(UserAccount account) throws DAOException {
        Basket basket = null;
        try(ProxyConnection cn = ConnectionPool.getInstance().takeConnection();
        PreparedStatement st = cn.prepareStatement(SQL_SELECT_BASKET_BY_ACCOUNT_ID)){
            st.setLong(1, account.getUserAccountId());
            ResultSet rs = st.executeQuery();
            ArrayList<Purchase> purchases = new ArrayList<Purchase>();
            while(rs.next()){
                String singer = rs.getString(SINGER);
                String name = rs.getString(NAME);
                String genreStr = rs.getString(GENRE);
                Genre genre = GenreUtil.getGenreFromString(genreStr);
                String url = rs.getString(URL);
                Float price = rs.getFloat(PRICE);
                Long id = rs.getLong(AUDIO_ID);
                Audio audio = new Audio(id, singer, name, url, price, genre);
                Purchase purchase = new Purchase(rs.getLong(PURCHASE_ID), account, audio);
                purchases.add(purchase);
            }
            basket = new Basket(account.getUserAccountId(), purchases);
        } catch (SQLException e) {
            throw new DAOException("SQLException", e);
        }
        return basket;
    }

    /**
     * Method deletePurchaseById
     *
     * @param id of type Long
     * @return boolean
     * @throws DAOException
     */
    @Override
    public boolean deletePurchaseById(Long id) throws DAOException {
        boolean flag = false;
        try(ProxyConnection cn = ConnectionPool.getInstance().takeConnection();
        PreparedStatement st = cn.prepareStatement(SQL_DELETE_PURCHASE_BY_ID)){
            st.setLong(1, id);
            st.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            throw new DAOException("SQLException", e);
        }
        return flag;
    }

    /**
     * Method getBasketPrice
     *
     * @param accountId of type Long
     * @return Float
     * @throws DAOException
     */
    @Override
    public Float getBasketPrice(Long accountId) throws DAOException {
        Float price = null;
        try(ProxyConnection cn = ConnectionPool.getInstance().takeConnection();
        PreparedStatement st = cn.prepareStatement(SQL_SELECT_BASKET_PRICE)){
            st.setLong(1, accountId);
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                price = rs.getFloat(PRICE);
            }
        } catch (SQLException e) {
            throw new DAOException("SQLException", e);
        }
        return price;
    }

    /**
     * Method getAudiosIdFromBasket
     *
     * @param accountId of type Long
     * @return ArrayList<Long>
     * @throws DAOException
     */
    @Override
    public ArrayList<Long> getAudiosIdFromBasket(Long accountId) throws DAOException {
        ArrayList<Long> audiosId = new ArrayList<Long>();
        try(ProxyConnection cn = ConnectionPool.getInstance().takeConnection();
        PreparedStatement st = cn.prepareStatement(SQL_SELECT_AUDIOS_ID_FROM_BASKET)){
            st.setLong(1, accountId);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                audiosId.add(rs.getLong(AUDIO_ID));
            }
        } catch (SQLException e) {
            throw new DAOException("SQLException", e);
        }
        return audiosId;
    }

    /**
     * Method deletePurchasesFromBasket
     *
     * @param accountId of type Long
     * @return boolean
     * @throws DAOException
     */
    @Override
    public boolean deletePurchasesFromBasket(Long accountId) throws DAOException {
        boolean flag = false;
        try(ProxyConnection cn = ConnectionPool.getInstance().takeConnection();
        PreparedStatement st = cn.prepareStatement(SQL_DELETE_PURCHASES_FROM_BASKET_BY_ACCOUNT_ID)){
            st.setLong(1, accountId);
            st.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            throw new DAOException("SQLException", e);
        }
        return flag;
    }
}
