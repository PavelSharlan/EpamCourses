package by.bsu.audioservice.command.impl;

import by.bsu.audioservice.command.Command;
import by.bsu.audioservice.entity.Audio;
import by.bsu.audioservice.entity.UserAccount;
import by.bsu.audioservice.exception.TechnicalException;
import by.bsu.audioservice.logic.ShowUserAudioLogic;
import by.bsu.audioservice.manager.ConfigurationManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Class UserCabinetRouteCommand
 *
 * Created by 7 on 21.08.2016.
 */
public class UserCabinetRouteCommand implements Command {
    /** Field USER_ACCOUNT */
    private static final String USER_ACCOUNT = "user_account";

    /** Field USER_AUDIOS */
    private static final String USER_AUDIOS = "user_audios";

    /** Field LOGGER */
    private static final Logger LOGGER = LogManager.getLogger(UserCabinetRouteCommand.class);

    /**
     * Method execute
     *
     * @param request of type HttpServletRequest
     * @return String
     */
    @Override
    public String execute(HttpServletRequest request) {
        LOGGER.info("User cabinet route command.");
        String page = null;
        try{
            UserAccount account = (UserAccount) request.getSession().getAttribute(USER_ACCOUNT);
            ArrayList<Audio> audios = ShowUserAudioLogic.getUserAccountAudios(account);
            request.getSession().setAttribute(USER_AUDIOS, audios);
            page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.USER_CABINET_PAGE_PATH);
        } catch (TechnicalException e) {
            LOGGER.error("Something was wrong, redirect to error page.");
            page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.ERROR_PAGE_PATH);
        }
        return page;
    }
}
