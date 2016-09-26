package by.bsu.audioservice.command.impl;

import by.bsu.audioservice.command.Command;
import by.bsu.audioservice.manager.ConfigurationManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 7 on 09.09.2016.
 */
public class MainPageRouteCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(MainPageRouteCommand.class);
    @Override
    public String execute(HttpServletRequest request) {
        LOGGER.info("Main page route command.");
        return ConfigurationManager.getInstance().getProperty(ConfigurationManager.MAIN_PAGE_PATH);
    }
}
