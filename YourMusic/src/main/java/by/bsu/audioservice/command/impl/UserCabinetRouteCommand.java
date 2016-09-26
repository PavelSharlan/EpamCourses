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
 * Created by 7 on 21.08.2016.
 */
public class UserCabinetRouteCommand implements Command {
    private static final String USER_ACCOUNT = "user_account";
    private static final String USER_AUDIOS = "user_audios";
    private static final Logger LOGGER = LogManager.getLogger(UserCabinetRouteCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        LOGGER.info("User cabinet route cabinet.");
        String page = null;
        try{
            UserAccount account = (UserAccount) request.getSession().getAttribute(USER_ACCOUNT);
            ArrayList<Audio> audios = ShowUserAudioLogic.getUserAccountAudios(account);
            request.getSession().setAttribute(USER_AUDIOS, audios);
            page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.USER_CABINET_PAGE_PATH);
        } catch (TechnicalException e) {
            LOGGER.error("Something was wrong, redirect to error page.");
        }
        return page;
    }
}
