package by.bsu.audioservice.ajax.logic;

import by.bsu.audioservice.dao.impl.OrderDAO;
import by.bsu.audioservice.entity.Order;
import by.bsu.audioservice.exception.DAOException;
import by.bsu.audioservice.exception.TechnicalException;
import org.json.simple.JSONObject;

import java.util.ArrayList;

/**
 * Created by 7 on 06.09.2016.
 */
public class UpdateOrdersLogic {

    /** Field ORDERS */
    private static final String ORDERS = "orders";

    /**
     * Method updateOrders
     *
     * @return String
     * @throws TechnicalException
     */
    public static String updateOrders() throws TechnicalException {
        ArrayList<Order> orders = null;
        JSONObject object = null;
        try{
            orders = OrderDAO.getInstance().getOrders();
            object = new JSONObject();
            object.put(ORDERS, orders);
        } catch (DAOException e) {
            throw new TechnicalException("DAOException");
        }
        return object.toJSONString();
    }
}
