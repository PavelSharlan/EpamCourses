package by.bsu.audioservice.command.impl;

import by.bsu.audioservice.command.Command;
import by.bsu.audioservice.entity.Role;
import by.bsu.audioservice.entity.User;
import by.bsu.audioservice.exception.LogicException;
import by.bsu.audioservice.exception.TechnicalException;
import by.bsu.audioservice.logic.EditUserSettingsLogic;
import by.bsu.audioservice.manager.ConfigurationManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * Class EditUserSettingsCommand
 *
 * Created by 7 on 16.08.2016.
 */
public class EditUserSettingsCommand implements Command {
    /** Field USER */
    private static final String USER = "user";

    /** Field FIRST_NAME */
    private static final String FIRST_NAME = "first_name";

    /** Field LAST_NAME */
    private static final String LAST_NAME = "last_name";

    /** Field PHONE_NUMBER */
    private static final String PHONE_NUMBER = "phone_number";

    /** Field EMAIL */
    private static final String EMAIL = "email";

    /** Field ERROR */
    private static final String ERROR = "error";

    /** Field LOGGER */
    private static final Logger LOGGER = LogManager.getLogger(EditUserSettingsCommand.class);

    /**
     * Method execute
     *
     * @param request of type HttpServletRequest
     * @return String
     */
    @Override
    public String execute(HttpServletRequest request) {
        LOGGER.info("Edit user's settings command.");
        String page = null;
        try {
            String firstName = request.getParameter(FIRST_NAME);
            String lastName = request.getParameter(LAST_NAME);
            String phone = request.getParameter(PHONE_NUMBER);
            String email = request.getParameter(EMAIL);
            User currentUser = (User)request.getSession().getAttribute(USER);
            User newUser = new User(currentUser.getUserId(), firstName, lastName, email, currentUser.getPassword(), phone, Role.USER);
            EditUserSettingsLogic.editSettings(currentUser, newUser);
            request.getSession().setAttribute(USER, newUser);
            page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.USER_SETTINGS_PATH);
        } catch (LogicException e) {
            LOGGER.error("Something was wrong with editing user's settings!");
            request.setAttribute(ERROR, e.getMessage());
        } catch (TechnicalException e) {
            LOGGER.error("Something was wrong, redirect to error page!");
            page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.ERROR_PAGE_PATH);
        }
        return page;
    }
}
