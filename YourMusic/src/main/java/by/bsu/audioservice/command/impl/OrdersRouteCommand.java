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
 * Created by 7 on 28.08.2016.
 */
public class OrdersRouteCommand implements Command {
    private static final String ORDERS = "orders";
    private static final Logger LOGGER = LogManager.getLogger(OrdersRouteCommand.class);
    @Override
    public String execute(HttpServletRequest request) {
        LOGGER.info("Orders route command.");
        try {
            ArrayList<Order> orders = OrderAudioLogic.getOrders();
            request.getSession().setAttribute(ORDERS, orders);
        } catch (TechnicalException e) {
            LOGGER.error("Something was wrong, redirect to error page.");
        }
        return ConfigurationManager.getInstance().getProperty(ConfigurationManager.ORDERS_PAGE_PATH);
    }
}
