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
 * Class SortAudioCommand
 *
 * Created by 7 on 26.08.2016.
 */
public class SortAudioCommand implements Command {
    /** Field KIND */
    private static final String KIND = "kind";

    /** Field AUDIOS */
    private static final String AUDIOS = "audios";

    /** Field LOGGER */
    private static final Logger LOGGER = LogManager.getLogger(SortAudioCommand.class);

    /**
     * Method execute
     *
     * @param request of type HttpServletRequest
     * @return String
     */
    @Override
    public String execute(HttpServletRequest request) {
        LOGGER.info("Sort audio command.");
        String kind = request.getParameter(KIND);
        String page = null;
        try {
            ArrayList<Audio> audios = SortAudioByGenreLogic.getAudiosByGenre(kind);
            request.setAttribute(AUDIOS, audios);
            page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.AUDIOS_FOR_REGISTERED_PAGE_PATH);
        } catch (TechnicalException e) {
            LOGGER.error("Something was wrong, redirect to error page.");
            page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.ERROR_PAGE_PATH);
        }
        return page;
    }
}
