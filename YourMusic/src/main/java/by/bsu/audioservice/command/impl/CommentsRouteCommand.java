package by.bsu.audioservice.command.impl;

import by.bsu.audioservice.command.Command;
import by.bsu.audioservice.entity.Comment;
import by.bsu.audioservice.exception.TechnicalException;
import by.bsu.audioservice.logic.CommentsLogic;
import by.bsu.audioservice.manager.ConfigurationManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Class CommentsRouteCommand
 *
 * Created by 7 on 11.09.2016.
 */
public class CommentsRouteCommand implements Command {

    /** Field COMMENTS */
    private static final String COMMENTS = "comments";

    /** Field LOGGER */
    private static final Logger LOGGER = LogManager.getLogger(CommentsRouteCommand.class);

    /**
     * Method execute
     *
     * @param request of type HttpServletRequest
     * @return String
     */
    @Override
    public String execute(HttpServletRequest request) {
        LOGGER.info("Comments route command");
        String page = null;
        try {
            ArrayList<Comment> comments = CommentsLogic.takeComments();
            request.setAttribute(COMMENTS, comments);
            page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.COMMENTS_PAGE_PATH);
        } catch (TechnicalException e) {
            LOGGER.error("Something was wrong, redirect to error page!", e);
            page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.ERROR_PAGE_PATH);
        }
         return page;
    }
}
