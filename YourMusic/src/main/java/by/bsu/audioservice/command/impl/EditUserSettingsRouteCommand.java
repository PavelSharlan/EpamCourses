package by.bsu.audioservice.command.impl;

import by.bsu.audioservice.command.Command;
import by.bsu.audioservice.manager.ConfigurationManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 7 on 16.08.2016.
 */
public class EditUserSettingsRouteCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(EditUserSettingsRouteCommand.class);
    @Override
    public String execute(HttpServletRequest request) {
        LOGGER.info("Edit user's settings route command");
        return ConfigurationManager.getInstance().getProperty(ConfigurationManager.USER_SETTINGS_PATH);
    }
}
