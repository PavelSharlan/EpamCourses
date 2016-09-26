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
 * Created by 7 on 10.09.2016.
 */
public class ShowAllUsersAccountsCommand implements Command {
    private static final String USERS_ACCOUNTS = "users_accounts";
    private static final Logger LOGGER = LogManager.getLogger(ShowAllUsersAccountsCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        LOGGER.info("Show all accounts command.");
        String page = null;
        try {
            ArrayList<UserAccount> accounts = ShowAllUsersAccountsLogic.show();
            request.setAttribute(USERS_ACCOUNTS, accounts);
            page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.USER_LIST_PATH);
        } catch (TechnicalException e) {
            LOGGER.error("Something was wrong, redirect to error page.  ");
        }
        return page;
    }
}
