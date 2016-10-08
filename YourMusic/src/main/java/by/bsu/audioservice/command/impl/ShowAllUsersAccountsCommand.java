package by.bsu.audioservice.command.impl;

import by.bsu.audioservice.command.Command;
import by.bsu.audioservice.entity.UserAccount;
import by.bsu.audioservice.exception.TechnicalException;
import by.bsu.audioservice.logic.ShowAllUsersAccountsLogic;
import by.bsu.audioservice.manager.ConfigurationManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Class ShowAllUsersAccountsCommand
 *
 * Created by 7 on 10.09.2016.
 */
public class ShowAllUsersAccountsCommand implements Command {
    /** Field USERS_ACCOUNTS */
    private static final String USERS_ACCOUNTS = "users_accounts";

    /** Field LOGGER */
    private static final Logger LOGGER = LogManager.getLogger(ShowAllUsersAccountsCommand.class);

    /**
     * Method execute
     *
     * @param request of type HttpServletRequest
     * @return String
     */
    @Override
    public String execute(HttpServletRequest request) {
        LOGGER.info("Show all accounts command.");
        String page = null;
        try {
            ArrayList<UserAccount> accounts = ShowAllUsersAccountsLogic.show();
            request.setAttribute(USERS_ACCOUNTS, accounts);
            page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.USER_LIST_PATH);
        } catch (TechnicalException e) {
            LOGGER.error("Something was wrong, redirect to error page.");
            page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.ERROR_PAGE_PATH);
        }
        return page;
    }
}
