package by.bsu.audioservice.ajax.command;

import by.bsu.audioservice.ajax.logic.ShowBasketLogic;
import by.bsu.audioservice.entity.Basket;
import by.bsu.audioservice.entity.User;
import by.bsu.audioservice.entity.UserAccount;
import by.bsu.audioservice.exception.TechnicalException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by 7 on 07.09.2016.
 */
public class ShowBasketCommand implements Command {
    private static final String USER = "user";
    private static final String USER_ACCOUNT = "user_account";
    private static final String BASKET = "basket";
    private static final String TEXT = "text";
    private static final String EMPTY_STRING = "";

    private static final Logger LOGGER = LogManager.getLogger(ShowBasketCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, String requestData) throws IOException{
        LOGGER.info("Show basket command");
        PrintWriter out = response.getWriter();
        JSONObject object = new JSONObject();
        try{
            UserAccount account = (UserAccount) request.getSession().getAttribute(USER_ACCOUNT);
            String basket = ShowBasketLogic.show(account);
            out.println(basket);
            response.setStatus(HttpServletResponse.SC_OK);
        } catch (TechnicalException e) {
            LOGGER.error("Something was wrong", e);
            object.put(TEXT, EMPTY_STRING);
            out.println(object);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        } finally {
            out.flush();
            out.close();
        }
    }
}
