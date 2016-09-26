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
 * Created by 7 on 14.09.2016.
 */
public class BanAccountCommand implements Command {
    private static final String ACCOUNT_ID = "account_id";
    private static final String USERS_ACCOUNTS = "users_accounts";
    private static final Logger LOGGER = LogManager.getLogger(BanAccountCommand.class);

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
        }
        return page;
    }
}
