package by.bsu.audioservice.command.impl;

import by.bsu.audioservice.command.Command;
import by.bsu.audioservice.manager.ConfigurationManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Class LanguageCommand
 *
 * Created by 7 on 07.08.2016.
 */
public class LanguageCommand implements Command {
    /** Field LANG */
    private static final String LANG = "lang";

    /** Field LOGGER */
    private static final Logger LOGGER = LogManager.getLogger(LanguageCommand.class);

    /**
     * Method execute
     *
     * @param request of type HttpServletRequest
     * @return String
     */
    @Override
    public String execute(HttpServletRequest request) {
        LOGGER.info("Change language command.");
        HttpSession session = request.getSession(true);
        String lang = request.getParameter(LANG);
        session.setAttribute(LANG, lang);

        return ConfigurationManager.getInstance().getProperty(ConfigurationManager.MAIN_PAGE_PATH);
    }
}
