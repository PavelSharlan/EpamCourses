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
 * Created by 7 on 06.08.2016.
 */
public class RegisterCommand implements Command {
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String PHONE_NUMBER = "phone_number";

    private static final Logger LOGGER = LogManager.getLogger(RegisterCommand.class);
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
        }
        return  page;
    }
}
