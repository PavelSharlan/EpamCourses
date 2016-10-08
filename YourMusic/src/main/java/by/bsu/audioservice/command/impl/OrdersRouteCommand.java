package by.bsu.audioservice.command.impl;

import by.bsu.audioservice.command.Command;
import by.bsu.audioservice.entity.Order;
import by.bsu.audioservice.exception.TechnicalException;
import by.bsu.audioservice.logic.OrderAudioLogic;
import by.bsu.audioservice.manager.ConfigurationManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Class OrdersRouteCommand
 *
 * Created by 7 on 28.08.2016.
 */
public class OrdersRouteCommand implements Command {
    /** Field ORDERS */
    private static final String ORDERS = "orders";

    /** Field LOGGER */
    private static final Logger LOGGER = LogManager.getLogger(OrdersRouteCommand.class);

    /**
     * Method execute
     *
     * @param request of type HttpServletRequest
     * @return String
     */
    @Override
    public String execute(HttpServletRequest request) {
        LOGGER.info("Orders route command.");
        String page = null;
        try {
            ArrayList<Order> orders = OrderAudioLogic.getOrders();
            request.getSession().setAttribute(ORDERS, orders);
            page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.ORDERS_PAGE_PATH);
        } catch (TechnicalException e) {
            LOGGER.error("Something was wrong, redirect to error page.");
            page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.ERROR_PAGE_PATH);
        }
        return page;
    }
}
