package by.bsu.audioservice.logic;

import by.bsu.audioservice.dao.impl.OrderDAO;
import by.bsu.audioservice.entity.Order;
import by.bsu.audioservice.exception.DAOException;
import by.bsu.audioservice.exception.TechnicalException;

import java.util.ArrayList;

/**
 * Created by 7 on 27.08.2016.
 */
public class OrderAudioLogic {
    public static void makeOrder(String singer, String audioName, String login) throws TechnicalException {
        Order order = new Order(singer, audioName, login);
        try {
            OrderDAO.getInstance().makeOrder(order);
        } catch (DAOException e) {
            throw new TechnicalException("DAOException", e);
        }
    }
    public static ArrayList<Order> getOrders() throws TechnicalException {
        try{
            return OrderDAO.getInstance().getOrders();
        } catch (DAOException e) {
            throw new TechnicalException("DAOException", e);
        }
    }
}
