package by.bsu.audioservice.command.impl;

import by.bsu.audioservice.command.Command;
import by.bsu.audioservice.manager.ConfigurationManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 7 on 21.08.2016.
 */
public class AboutUsRouteCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(AboutUsRouteCommand.class);
    @Override
    public String execute(HttpServletRequest request) {
        LOGGER.info("About us route command");
        return ConfigurationManager.getInstance().getProperty(ConfigurationManager.ABOUT_US_PAGE_PATH);
    }
}
