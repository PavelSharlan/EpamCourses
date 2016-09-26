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
 * Created by 7 on 16.08.2016.
 */
public class EditUserSettingsCommand implements Command {
    private static final String USER = "user";
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String PHONE_NUMBER = "phone_number";
    private static final String EMAIL = "email";
    private static final Logger LOGGER = LogManager.getLogger(EditUserSettingsCommand.class);

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
            page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.USER_CABINET_PAGE_PATH);
            EditUserSettingsLogic.editSettings(currentUser, newUser);
        } catch (LogicException e) {
            LOGGER.error("Something was wrong with editing user's settings!");
            request.setAttribute("error", e.getMessage());
        } catch (TechnicalException e) {
            LOGGER.error("Something was wrong, redirect to error page!");
        }
        return page;
    }
}
