package by.bsu.audioservice.command.impl;

import by.bsu.audioservice.command.Command;
import by.bsu.audioservice.entity.Audio;
import by.bsu.audioservice.exception.TechnicalException;
import by.bsu.audioservice.logic.EditAudioInfoLogic;
import by.bsu.audioservice.manager.ConfigurationManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 7 on 12.09.2016.
 */
public class EditAudioInfoRouteCommand implements Command {
    private static final String AUDIO_ID = "audio_id";
    private static final String AUDIO = "audio";
    private static final Logger LOGGER = LogManager.getLogger(EditAudioInfoRouteCommand.class);
    @Override
    public String execute(HttpServletRequest request) {
        LOGGER.info("Edit information about audio route command.");
        String page = null;
        try {
            Long id = Long.valueOf(request.getParameter(AUDIO_ID));
            Audio audio = EditAudioInfoLogic.takeAudio(id);
            request.getSession().setAttribute(AUDIO, audio);
            page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.AUDIO_INFO_PAGE_PATH);
        } catch (TechnicalException e) {
            LOGGER.error("Something was wrong, redirect to error page!", e);
        }
        return page;
    }
}
