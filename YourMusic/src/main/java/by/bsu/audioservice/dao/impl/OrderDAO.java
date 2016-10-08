package by.bsu.audioservice.dao.impl;

import by.bsu.audioservice.dao.AbstractOrderDAO;
import by.bsu.audioservice.entity.Order;
import by.bsu.audioservice.exception.DAOException;
import by.bsu.audioservice.pool.ConnectionPool;
import by.bsu.audioservice.pool.ProxyConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Class OrderDAO
 *
 * Created by 7 on 27.08.2016.
 */
public class OrderDAO extends AbstractOrderDAO {
    /** Field SQL_INSERT_ORDER */
    private static final String SQL_INSERT_ORDER = "INSERT INTO orders (singer, audio_name, user_login) VALUES (?, ?, ?);";

    /** Field SQL_SELECT_ALL_ORDERS */
    private static final String SQL_SELECT_ALL_ORDERS = "SELECT order_id, singer, audio_name, user_login FROM audio_service.orders;";

    /** Field SQL_DELETE_ORDER */
    private static final String SQL_DELETE_ORDER = "DELETE from orders WHERE orders.order_id = ?;";

    /** Field ORDER_ID */
    private static final String ORDER_ID = "order_id";

    /** Field SINGER */
    private static final String SINGER = "singer";

    /** Field AUDIO_NAME */
    private static final String AUDIO_NAME = "audio_name";

    /** Field USER_LOGIN */
    private static final String USER_LOGIN = "user_login";

    /** Field instance */
    private static OrderDAO instance = OrderDAO.getInstance();

    /**
     * Instantiates a new OrderDAO
     */
    private OrderDAO(){
    }

    /**
     * Method getInstance
     *
     * @return OrderDAO
     */
    public static OrderDAO getInstance(){
        if (instance == null){
            instance = new OrderDAO();
        }
        return instance;
    }

    /**
     * Method makeOrder
     *
     * @param order of type Order
     * @return boolean
     * @throws DAOException
     */
    @Override
    public boolean makeOrder(Order order) throws DAOException {
        boolean flag = false;
        try(ProxyConnection cn = ConnectionPool.getInstance().takeConnection();
        PreparedStatement st = cn.prepareStatement(SQL_INSERT_ORDER)){
            st.setString(1, order.getSinger());
            st.setString(2, order.getAudioName());
            st.setString(3, order.getUserLogin());
            st.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            throw new DAOException("SQLException", e);
        }
        return flag;
    }

    /**
     * Method getOrders
     *
     * @return ArrayList<Order>
     * @throws DAOException
     */
    @Override
    public ArrayList<Order> getOrders() throws DAOException {
        ArrayList<Order> orders = new ArrayList<Order>();
        try(ProxyConnection cn = ConnectionPool.getInstance().takeConnection();
        PreparedStatement st = cn.prepareStatement(SQL_SELECT_ALL_ORDERS)) {
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                String singer = rs.getString(SINGER);
                String audioName = rs.getString(AUDIO_NAME);
                String userLogin = rs.getString(USER_LOGIN);
                Long id = rs.getLong(ORDER_ID);
                orders.add(new Order(id, singer, audioName, userLogin));
            }
        } catch (SQLException e) {
            throw new DAOException("SQLException", e);
        }
        return orders;
    }

    /**
     * Method deleteOrderById
     *
     * @param orderId of type Long
     * @return boolean
     * @throws DAOException
     */
    @Override
    public boolean deleteOrderById(Long orderId) throws DAOException {
        boolean flag = false;
        try(ProxyConnection cn = ConnectionPool.getInstance().takeConnection();
        PreparedStatement st = cn.prepareStatement(SQL_DELETE_ORDER)) {
            st.setLong(1, orderId);
            st.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            throw new DAOException("SQLException", e);
        }
        return flag;
    }
}
