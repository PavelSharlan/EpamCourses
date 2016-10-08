package by.bsu.audioservice.command.impl;

import by.bsu.audioservice.command.Command;
import by.bsu.audioservice.entity.Audio;
import by.bsu.audioservice.exception.LogicException;
import by.bsu.audioservice.exception.TechnicalException;
import by.bsu.audioservice.logic.EditAudioInfoLogic;
import by.bsu.audioservice.logic.ShowAllAudioLogic;
import by.bsu.audioservice.manager.ConfigurationManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Class EditAudioInfoCommand
 *
 * Created by 7 on 12.09.2016.
 */
public class EditAudioInfoCommand implements Command {
    /** Field ERROR */
    private static final String ERROR = "error";

    /** Field AUDIO */
    private static final String AUDIO = "audio";

    /** Field AUDIOS */
    private static final String AUDIOS = "audios";

    /** Field AUDIO_NAME */
    private static final String AUDIO_NAME = "audio_name";

    /** Field SINGER */
    private static final String SINGER = "singer";

    /** Field PRICE */
    private static final String PRICE = "price";

    /** Field LOGGER */
    private static final Logger LOGGER = LogManager.getLogger(EditAudioInfoCommand.class);

    /**
     * Method execute
     *
     * @param request of type HttpServletRequest
     * @return String
     */
    @Override
    public String execute(HttpServletRequest request) {
        LOGGER.info("Edit information about audio command");
        Audio currentAudio = (Audio)request.getSession().getAttribute(AUDIO);
        String name = request.getParameter(AUDIO_NAME);
        String singer = request.getParameter(SINGER);
        Float price = Float.valueOf(request.getParameter(PRICE));
        Audio newAudio = new Audio(currentAudio.getAudioId(), singer, name, currentAudio.getUrl(), price, currentAudio.getGenre());
        String page = null;
        try {
            EditAudioInfoLogic.edit(currentAudio, newAudio);
            ArrayList<Audio> audios = ShowAllAudioLogic.getAllAudios();
            request.getSession().setAttribute(AUDIOS, audios);
            page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.ADMIN_CABINET_PAGE_PATH);
        } catch (LogicException e) {
            LOGGER.error("Something was wrong with editing information about audio.");
            request.setAttribute(ERROR, e.getMessage());
            page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.AUDIO_INFO_PAGE_PATH);
        } catch (TechnicalException e) {
            LOGGER.error("Something was wrong, redirect to error page!", e);
            page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.ERROR_PAGE_PATH);
        }
        return page;
    }
}
