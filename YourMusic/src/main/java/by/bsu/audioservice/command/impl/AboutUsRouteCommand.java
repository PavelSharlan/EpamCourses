package by.bsu.audioservice.command.impl;

import by.bsu.audioservice.command.Command;
import by.bsu.audioservice.manager.ConfigurationManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * Class AboutUsRouteCommand
 *
 * Created by 7 on 21.08.2016.
 */
public class AboutUsRouteCommand implements Command {

    /** Field LOGGER */
    private static final Logger LOGGER = LogManager.getLogger(AboutUsRouteCommand.class);

    /**
     * Method execute
     *
     * @param request of type HttpServletRequest
     * @return String
     */
    @Override
    public String execute(HttpServletRequest request) {
        LOGGER.info("About us route command");
        return ConfigurationManager.getInstance().getProperty(ConfigurationManager.ABOUT_US_PAGE_PATH);
    }
}
