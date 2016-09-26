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
 * Created by 7 on 27.08.2016.
 */
public class MakeOrderAudioCommand implements Command {
    private static final String SINGER = "singer";
    private static final String AUDIO_NAME = "audio_name";
    private static final String USER = "user";
    private static final String AUDIOS = "audios";

    private static final Logger LOGGER = LogManager.getLogger(MakeOrderAudioCommand.class);
    @Override
    public String execute(HttpServletRequest request) {
        LOGGER.info("Make order audio command.");
        String singer = request.getParameter(SINGER);
        String audioName = request.getParameter(AUDIO_NAME);
        User user = (User)request.getSession().getAttribute(USER);
        String login = user.getEmail();
        try {
            ArrayList<Audio> audios = ShowAllAudioLogic.getAllDemoAudios();
            request.setAttribute(AUDIOS, audios);
            OrderAudioLogic.makeOrder(singer, audioName, login);
        } catch (TechnicalException e) {
            LOGGER.error("Something was wrong, redirect to error page.");
        }
        return ConfigurationManager.getInstance().getProperty(ConfigurationManager.AUDIOS_FOR_REGISTERED_PAGE_PATH);
    }
}
