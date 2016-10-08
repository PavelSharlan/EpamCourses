package by.bsu.audioservice.ajax.command.impl;

import by.bsu.audioservice.ajax.command.Command;
import by.bsu.audioservice.ajax.logic.SendCommentLogic;
import by.bsu.audioservice.entity.User;
import by.bsu.audioservice.exception.TechnicalException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Class SendCommentCommand
 *
 * Created by 7 on 11.09.2016.
 */
public class SendCommentCommand implements Command {
    /**Field USER*/
    private static final String USER = "user";

    /**Field LOGGER*/
    private static final Logger LOGGER = LogManager.getLogger(SendCommentCommand.class);

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
        LOGGER.info("Send comment command");
        PrintWriter out = response.getWriter();
        JSONObject object = new JSONObject();
        try{
            User user = (User) request.getSession().getAttribute(USER);
            String comment = SendCommentLogic.sendComment(requestData, user);
            out.println(comment);
            response.setStatus(HttpServletResponse.SC_OK);
        } catch (TechnicalException e) {
            LOGGER.error("Something was wrong", e);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        } finally {
            out.flush();
            out.close();
        }
    }
}
