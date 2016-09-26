package by.bsu.audioservice.command.impl;

import by.bsu.audioservice.command.Command;
import by.bsu.audioservice.entity.Audio;
import by.bsu.audioservice.exception.TechnicalException;
import by.bsu.audioservice.logic.SortAudioByGenreLogic;
import by.bsu.audioservice.manager.ConfigurationManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Created by 7 on 26.08.2016.
 */
public class SortAudioCommand implements Command {
    private static final String KIND = "kind";
    private static final String AUDIOS = "audios";
    private static final Logger LOGGER = LogManager.getLogger(SortAudioCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        LOGGER.info("Sort audio command.");
        String kind = request.getParameter(KIND);
        try {
            ArrayList<Audio> audios = SortAudioByGenreLogic.getAudiosByGenre(kind);
            request.setAttribute(AUDIOS, audios);
        } catch (TechnicalException e) {
            LOGGER.error("Something was wrong, redirect to error page.");
        }
        return ConfigurationManager.getInstance().getProperty(ConfigurationManager.AUDIOS_FOR_REGISTERED_PAGE_PATH);
    }
}
