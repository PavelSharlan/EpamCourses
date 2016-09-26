package by.bsu.audioservice.dao;

import by.bsu.audioservice.entity.Order;
import by.bsu.audioservice.exception.DAOException;

import java.util.ArrayList;

/**
 * Created by 7 on 27.08.2016.
 */
public abstract class AbstractOrderDAO {
    public abstract boolean makeOrder(Order order) throws DAOException;
    public abstract ArrayList<Order> getOrders() throws DAOException;
    public abstract boolean deleteId(Long orderId) throws DAOException;
}
