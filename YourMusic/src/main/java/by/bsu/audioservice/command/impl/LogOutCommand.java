package by.bsu.audioservice.command.impl;

import by.bsu.audioservice.command.Command;
import by.bsu.audioservice.manager.ConfigurationManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Class LogOutCommand
 *
 * Created by 7 on 16.08.2016.
 */
public class LogOutCommand implements Command {
    /** Field LOGGER */
    private static final Logger LOGGER = LogManager.getLogger(LogOutCommand.class);

    /**
     * Method execute
     *
     * @param request of type HttpServletRequest
     * @return String
     */
    @Override
    public String execute(HttpServletRequest request) {
        LOGGER.info("Log out command");
        HttpSession session = request.getSession();
        session.invalidate();
        return ConfigurationManager.getInstance().getProperty(ConfigurationManager.MAIN_PAGE_PATH);
    }
}
