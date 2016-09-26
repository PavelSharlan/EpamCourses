package by.bsu.audioservice.command.impl;

import by.bsu.audioservice.command.Command;
import by.bsu.audioservice.manager.ConfigurationManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by 7 on 16.08.2016.
 */
public class LogOutCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(LogOutCommand.class);
    @Override
    public String execute(HttpServletRequest request) {
        LOGGER.info("Log out command");
        HttpSession session = request.getSession();
        session.invalidate();
        return ConfigurationManager.getInstance().getProperty(ConfigurationManager.MAIN_PAGE_PATH);
    }
}
