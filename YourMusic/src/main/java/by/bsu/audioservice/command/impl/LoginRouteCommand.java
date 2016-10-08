package by.bsu.audioservice.command.impl;

import by.bsu.audioservice.command.Command;
import by.bsu.audioservice.manager.ConfigurationManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * Class LoginRouteCommand
 *
 * Created by 7 on 06.08.2016.
 */
public class LoginRouteCommand implements Command {
    /** Field LOGGER */
    private static final Logger LOGGER = LogManager.getLogger(LoginRouteCommand.class);

    /**
     * Method execute
     *
     * @param request of type HttpServletRequest
     * @return String
     */
    @Override
    public String execute(HttpServletRequest request) {
        LOGGER.info("Log in route command.");
        return ConfigurationManager.getInstance().getProperty(ConfigurationManager.LOGIN_PAGE_PATH);
    }
}
