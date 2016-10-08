package by.bsu.audioservice.command.impl;

import by.bsu.audioservice.command.Command;
import by.bsu.audioservice.entity.User;
import by.bsu.audioservice.exception.LogicException;
import by.bsu.audioservice.exception.TechnicalException;
import by.bsu.audioservice.logic.ChangePasswordLogic;
import by.bsu.audioservice.manager.ConfigurationManager;
import by.bsu.audioservice.util.MD5Hash;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * Class ChangePasswordCommand
 *
 * Created by 7 on 16.08.2016.
 */
public class ChangePasswordCommand implements Command {
    /** Field USER */
    private static final String USER = "user";

    /** Field OLD_PASSWORD */
    private static final String OLD_PASSWORD = "old_password";

    /** Field NEW_PASSWORD_FIRST */
    private static final String NEW_PASSWORD_FIRST = "new_password1";

    /** Field NEW_PASSWORD_SECOND */
    private static final String NEW_PASSWORD_SECOND = "new_password2";

    /** Field PASSWORD_ERROR */
    private static final String PASSWORD_ERROR = "password_error";

    /** Field LOGGER */
    private static final Logger LOGGER = LogManager.getLogger(ChangePasswordCommand.class);

    /**
     * Method execute
     *
     * @param request of type HttpServletRequest
     * @return String
     */
    @Override
    public String execute(HttpServletRequest request) {
        LOGGER.info("Change password command");
        String page = null;
        String password = request.getParameter(OLD_PASSWORD).trim();
        String newPasswordFirst = request.getParameter(NEW_PASSWORD_FIRST).trim();
        String newPasswordSecond = request.getParameter(NEW_PASSWORD_SECOND).trim();
        User user = (User)request.getSession().getAttribute(USER);
        try {
            ChangePasswordLogic.change(user, password, newPasswordFirst, newPasswordSecond);
            user.setPassword(MD5Hash.md5Custom(newPasswordFirst));
            request.getSession().setAttribute(USER, user);
            page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.USER_CABINET_PAGE_PATH);
        } catch (LogicException e) {
            LOGGER.error("Something was wrong wis changing password!", e);
            request.setAttribute(PASSWORD_ERROR, e.getMessage());
            page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.USER_SETTINGS_PATH);
        } catch (TechnicalException e) {
            LOGGER.error("Something was wrong, redirect to error page!", e);
            page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.ERROR_PAGE_PATH);
        }
        return page;
    }
}
