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
 * Created by 7 on 21.08.2016.
 */
public class ShowAllAudioCommand implements Command {
    private static final String AUDIOS = "audios";

    private static final Logger LOGGER = LogManager.getLogger(ShowAllAudioCommand.class);
    @Override
    public String execute(HttpServletRequest request) {
        LOGGER.info("Show all audio command.");
        String page = null;
        try {
            ArrayList<Audio> audios = ShowAllAudioLogic.getAllDemoAudios();
            request.setAttribute(AUDIOS, audios);
            page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.AUDIOS_FOR_REGISTERED_PAGE_PATH);
        } catch (TechnicalException e) {
            LOGGER.error("Something was wrong, redirect to error page.");
        }
        return page;
    }
}
