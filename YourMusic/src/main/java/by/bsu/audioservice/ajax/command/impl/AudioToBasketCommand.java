package by.bsu.audioservice.ajax.command.impl;


import by.bsu.audioservice.ajax.command.Command;
import by.bsu.audioservice.ajax.logic.AudioToBasketLogic;
import by.bsu.audioservice.entity.UserAccount;
import by.bsu.audioservice.exception.LogicException;
import by.bsu.audioservice.exception.TechnicalException;
import by.bsu.audioservice.manager.ConfigurationManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Class AudioToBasketCommand
 *
 * Created by 7 on 06.09.2016.
 */
public class AudioToBasketCommand implements Command {
    /** Field USER_ACCOUNT*/
    private static final String USER_ACCOUNT = "user_account";

    /** Field TEXT */
    private static final String TEXT = "text";

    /** Field LOGGER */
    private static final Logger LOGGER = LogManager.getLogger(AudioToBasketCommand.class);

    /** Field MESSAGE_SUCCESS_ADD_AUDIO */
    public static final String MESSAGE_SUCCESS_ADD_AUDIO = "Audio added";

    /**
     * Method execute ...
     *
     * @param request of type HttpServletRequest
     * @param response of type HttpServletResponse
     * @param requestData of type String
     * @throws IOException when
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, String requestData) throws IOException {
        LOGGER.info("Add audio to basket command");
        PrintWriter out = response.getWriter();
        JSONObject object = new JSONObject();
        try{
            UserAccount account = (UserAccount) request.getSession().getAttribute(USER_ACCOUNT);
            AudioToBasketLogic.add(requestData, account);
            object.put(TEXT, MESSAGE_SUCCESS_ADD_AUDIO);
            out.println(object);
            response.setStatus(HttpServletResponse.SC_OK);
        } catch (TechnicalException e) {
            LOGGER.error("Something was wrong", e);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        } catch (LogicException e) {
            LOGGER.error("LogicException", e);
            object.put(TEXT, e.getMessage());
            out.println(object);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        } finally {
            out.flush();
            out.close();
        }
    }
}
