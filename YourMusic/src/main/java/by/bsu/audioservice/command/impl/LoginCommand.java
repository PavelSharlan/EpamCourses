package by.bsu.audioservice.command.impl;

import by.bsu.audioservice.command.Command;
import by.bsu.audioservice.entity.Audio;
import by.bsu.audioservice.entity.User;
import by.bsu.audioservice.entity.UserAccount;
import by.bsu.audioservice.exception.LogicException;
import by.bsu.audioservice.exception.TechnicalException;
import by.bsu.audioservice.logic.LoginLogic;
import by.bsu.audioservice.logic.ShowAllAudioLogic;
import by.bsu.audioservice.logic.ShowUserAudioLogic;
import by.bsu.audioservice.manager.ConfigurationManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Created by 7 on 06.08.2016.
 */
public class LoginCommand implements Command {
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private static final String USER = "user";
    private static final String ADMIN = "admin";
    private static final String ERROR = "error";
    private static final String USER_ACCOUNT = "user_account";
    private static final String USER_AUDIOS = "user_audios";
    private static final String AUDIOS = "audios";

    private static final Logger LOGGER = LogManager.getLogger(LoginCommand.class);
    @Override
    public String execute(HttpServletRequest request) {
        LOGGER.info("Log in command");
        String page = null;
        String email = request.getParameter(EMAIL);
        String pass = request.getParameter(PASSWORD);
        User user = null;
        ArrayList<Audio> audios = null;
        try {
            user = LoginLogic.findUserByEmailAndPassword(email, pass);
            if(user.getRole().toString().toLowerCase().equals(USER)){
                UserAccount account = LoginLogic.findUserAccountByUserID(user.getUserId());
                if (!LoginLogic.isBanned(account)) {
                    request.getSession().setAttribute(USER, user);
                    request.getSession().setAttribute(USER_ACCOUNT, account);
                    audios = ShowUserAudioLogic.getUserAccountAudios(account);
                    request.getSession().setAttribute(USER_AUDIOS, audios);
                    page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.USER_CABINET_PAGE_PATH);
                }
                else {
                    request.setAttribute(ERROR, "You were banned!");
                    page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.LOGIN_PAGE_PATH);
                }
            } else{
                audios = ShowAllAudioLogic.getAllAudios();
                request.getSession().setAttribute(AUDIOS, audios);
                page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.ADMIN_CABINET_PAGE_PATH);
            }
        } catch (LogicException e) {
            request.setAttribute(ERROR, e.getMessage());
            page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.LOGIN_PAGE_PATH);
        } catch (TechnicalException e) {
            LOGGER.error("Something was wrong, redirect to error page.");
        }
        return page;
    }
}
