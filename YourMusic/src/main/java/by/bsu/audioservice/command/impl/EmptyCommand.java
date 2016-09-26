package by.bsu.audioservice.command.impl;

import by.bsu.audioservice.command.Command;
import by.bsu.audioservice.manager.ConfigurationManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 7 on 06.08.2016.
 */
public class EmptyCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(EmptyCommand.class);
    @Override
    public String execute(HttpServletRequest request) {
        LOGGER.info("Empty command");
        return ConfigurationManager.getInstance().getProperty(ConfigurationManager.ERROR_PAGE_PATH);
    }
}
