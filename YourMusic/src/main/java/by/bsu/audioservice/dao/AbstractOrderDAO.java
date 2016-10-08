package by.bsu.audioservice.dao;

import by.bsu.audioservice.entity.Order;
import by.bsu.audioservice.exception.DAOException;

import java.util.ArrayList;

/**
 * Class AbstractOrderDAO
 * <p>
 * Created by 7 on 27.08.2016.
 */
public abstract class AbstractOrderDAO {

    /**
     * Make order
     *
     * @param order of type Order
     * @return boolean
     * @throws DAOException
     */
    public abstract boolean makeOrder(Order order) throws DAOException;

    /**
     * Gets orders.
     *
     * @return ArrayList<Order>
     * @throws DAOException
     */
    public abstract ArrayList<Order> getOrders() throws DAOException;

    /**
     * Delete id
     *
     * @param orderId of type Long
     * @return boolean
     * @throws DAOException
     */
    public abstract boolean deleteOrderById(Long orderId) throws DAOException;
}
