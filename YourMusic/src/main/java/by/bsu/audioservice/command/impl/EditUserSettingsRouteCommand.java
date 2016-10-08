package by.bsu.audioservice.command.impl;

import by.bsu.audioservice.command.Command;
import by.bsu.audioservice.manager.ConfigurationManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * Class EditUser
 *
 * Created by 7 on 16.08.2016.
 */
public class EditUserSettingsRouteCommand implements Command {
    /** Field LOGGER */
    private static final Logger LOGGER = LogManager.getLogger(EditUserSettingsRouteCommand.class);

    /**
     * Method execute
     *
     * @param request of type HttpServletRequest
     * @return String
     */
    @Override
    public String execute(HttpServletRequest request) {
        LOGGER.info("Edit user's settings route command");
        return ConfigurationManager.getInstance().getProperty(ConfigurationManager.USER_SETTINGS_PATH);
    }
}
