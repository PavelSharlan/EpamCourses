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
 * Created by 7 on 28.08.2016.
 */
public class AdminCabinetRouteCommand implements Command {
    private static final String AUDIOS = "audios";
    private static final Logger LOGGER = LogManager.getLogger(AdminCabinetRouteCommand.class);
    @Override
    public String execute(HttpServletRequest request) {
        LOGGER.info("Admin cabinet route command");
        ArrayList<Audio> audios = null;
        try {
            audios = ShowAllAudioLogic.getAllAudios();
            request.getSession().setAttribute(AUDIOS, audios);
        } catch (TechnicalException e) {
            LOGGER.error("Something was wrong, redirect to error page.", e);
        }
        return ConfigurationManager.getInstance().getProperty(ConfigurationManager.ADMIN_CABINET_PAGE_PATH);
    }
}
