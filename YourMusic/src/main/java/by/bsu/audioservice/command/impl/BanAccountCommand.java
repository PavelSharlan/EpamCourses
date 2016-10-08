package by.bsu.audioservice.command.impl;

import by.bsu.audioservice.command.Command;
import by.bsu.audioservice.entity.UserAccount;
import by.bsu.audioservice.exception.TechnicalException;
import by.bsu.audioservice.logic.BanAccountLogic;
import by.bsu.audioservice.logic.ShowAllUsersAccountsLogic;
import by.bsu.audioservice.manager.ConfigurationManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Class BanAccountCommand
 *
 * Created by 7 on 14.09.2016.
 */
public class BanAccountCommand implements Command {

    /** Field ACCOUNT_ID */
    private static final String ACCOUNT_ID = "account_id";

    /** Field USERS_ACCOUNTS */
    private static final String USERS_ACCOUNTS = "users_accounts";

    /** Field LOGGER */
    private static final Logger LOGGER = LogManager.getLogger(BanAccountCommand.class);

    /**
     * Method execute
     *
     * @param request of type HttpServletRequest
     * @return String
     */
    @Override
    public String execute(HttpServletRequest request) {
        LOGGER.info("Ban account command");
        String page = null;
        try {
            Long accountId = Long.parseLong(request.getParameter(ACCOUNT_ID));
            BanAccountLogic.ban(accountId);
            ArrayList<UserAccount> accounts = ShowAllUsersAccountsLogic.show();
            request.getSession().setAttribute(USERS_ACCOUNTS, accounts);
            page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.USER_LIST_PATH);
        } catch (TechnicalException e) {
            LOGGER.error("Something was wrong, redirect to error page!", e);
            page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.ERROR_PAGE_PATH);
        }
        return page;
    }
}
