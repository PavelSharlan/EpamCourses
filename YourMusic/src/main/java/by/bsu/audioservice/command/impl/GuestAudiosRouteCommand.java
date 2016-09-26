package by.bsu.audioservice.command.impl;

import by.bsu.audioservice.command.Command;
import by.bsu.audioservice.entity.Audio;
import by.bsu.audioservice.exception.TechnicalException;
import by.bsu.audioservice.logic.ShowAllAudioLogic;
import by.bsu.audioservice.manager.ConfigurationManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Created by 7 on 19.08.2016.
 */
public class GuestAudiosRouteCommand implements Command {
    private static final String DEMO_AUDIOS = "demo_audios";
    private static final Logger LOGGER = LogManager.getLogger(GuestAudiosRouteCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        LOGGER.info("Guest audios route command!");
        String page = null;
        try {
            ArrayList<Audio> demoAudios = ShowAllAudioLogic.getAllDemoAudios();
            request.getSession().setAttribute(DEMO_AUDIOS, demoAudios);
            page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.AUDIOS_FOR_GUESTS_PAGE_PATH);
        } catch (TechnicalException e) {
            LOGGER.error("Something was wrong, redirect to error page");
            page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.ERROR_PAGE_PATH);
        }
        return page;
    }
}
