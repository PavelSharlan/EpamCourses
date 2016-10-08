package by.bsu.audioservice.command.impl;

import by.bsu.audioservice.command.Command;
import by.bsu.audioservice.entity.Audio;
import by.bsu.audioservice.entity.User;
import by.bsu.audioservice.exception.TechnicalException;
import by.bsu.audioservice.logic.OrderAudioLogic;
import by.bsu.audioservice.logic.ShowAllAudioLogic;
import by.bsu.audioservice.manager.ConfigurationManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Class MakeOrderAudioCommand
 *
 * Created by 7 on 27.08.2016.
 */
public class MakeOrderAudioCommand implements Command {
    /** Field SINGER */
    private static final String SINGER = "singer";

    /** Field AUDIO_NAME */
    private static final String AUDIO_NAME = "audio_name";

    /** Field USER */
    private static final String USER = "user";

    /** Field AUDIOS */
    private static final String AUDIOS = "audios";

    /** Field LOGGER */
    private static final Logger LOGGER = LogManager.getLogger(MakeOrderAudioCommand.class);

    /**
     * Method execute
     *
     * @param request of type HttpServletRequest
     * @return String
     */
    @Override
    public String execute(HttpServletRequest request) {
        LOGGER.info("Make order audio command.");
        String singer = request.getParameter(SINGER);
        String audioName = request.getParameter(AUDIO_NAME);
        User user = (User)request.getSession().getAttribute(USER);
        String login = user.getEmail();
        String page = null;
        try {
            ArrayList<Audio> audios = ShowAllAudioLogic.getAllDemoAudios();
            request.setAttribute(AUDIOS, audios);
            OrderAudioLogic.makeOrder(singer, audioName, login);
            page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.AUDIOS_FOR_REGISTERED_PAGE_PATH);
        } catch (TechnicalException e) {
            LOGGER.error("Something was wrong, redirect to error page.");
            page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.ERROR_PAGE_PATH);
        }
        return page;
    }
}
