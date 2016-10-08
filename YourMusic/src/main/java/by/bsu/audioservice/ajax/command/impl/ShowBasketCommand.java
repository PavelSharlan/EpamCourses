package by.bsu.audioservice.ajax.command.impl;

import by.bsu.audioservice.ajax.command.Command;
import by.bsu.audioservice.ajax.logic.ShowBasketLogic;
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
 * Class ShowBasketCommand
 *
 * Created by 7 on 07.09.2016.
 */
public class ShowBasketCommand implements Command {
    /** Field USER_ACCOUNT */
    private static final String USER_ACCOUNT = "user_account";

    /** Field TEXT */
    private static final String TEXT = "text";

    /** Field EMPTY_STRING */
    private static final String EMPTY_STRING = "";

    /** Field LOGGER */
    private static final Logger LOGGER = LogManager.getLogger(ShowBasketCommand.class);

    /**
     * Method execute ...
     *
     * @param request of type HttpServletRequest
     * @param response of type HttpServletResponse
     * @param requestData of type String
     * @throws IOException when
     */
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
