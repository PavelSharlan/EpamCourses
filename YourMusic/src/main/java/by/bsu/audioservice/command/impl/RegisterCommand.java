package by.bsu.audioservice.command.impl;

import by.bsu.audioservice.command.Command;
import by.bsu.audioservice.entity.Role;
import by.bsu.audioservice.entity.User;
import by.bsu.audioservice.entity.UserAccount;
import by.bsu.audioservice.exception.LogicException;
import by.bsu.audioservice.exception.TechnicalException;
import by.bsu.audioservice.logic.RegisterLogic;
import by.bsu.audioservice.manager.ConfigurationManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class RegisterCommand
 *
 * Created by 7 on 06.08.2016.
 */
public class RegisterCommand implements Command {
    /** Field EMAIL */
    private static final String EMAIL = "email";

    /** Field PASSWORD */
    private static final String PASSWORD = "password";

    /** Field FIRST_NAME */
    private static final String FIRST_NAME = "first_name";

    /** Field LAST_NAME */
    private static final String LAST_NAME = "last_name";

    /** Field PHONE_NUMBER */
    private static final String PHONE_NUMBER = "phone_number";

    /** Field LOGGER */
    private static final Logger LOGGER = LogManager.getLogger(RegisterCommand.class);

    /**
     * Method execute
     *
     * @param request of type HttpServletRequest
     * @return String
     */
    @Override
    public String execute(HttpServletRequest request) {
        LOGGER.info("Register command.");
        String page = null;
        String email = request.getParameter(EMAIL);
        String password = request.getParameter(PASSWORD);
        String firstName = request.getParameter(FIRST_NAME);
        String lastName = request.getParameter(LAST_NAME);
        String phoneNumber = request.getParameter(PHONE_NUMBER);
        Role role = Role.USER;
        UserAccount account = null;
        try{
            RegisterLogic.checkUserByEmail(email);
            User user = new User(firstName, lastName, email, password, phoneNumber, role);
            RegisterLogic.addUser(user);
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            account = new UserAccount(user, format.format(date).toString(), 0f);
            RegisterLogic.addUserAccount(account);
            page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.LOGIN_PAGE_PATH);
        } catch (LogicException e) {
            request.setAttribute("error", "There is a user with the same login!");
            page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.LOGIN_PAGE_PATH);
        }catch (TechnicalException e) {
            LOGGER.error("Something was wrong, redirect to error page.");
            page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.ERROR_PAGE_PATH);
        }
        return  page;
    }
}
