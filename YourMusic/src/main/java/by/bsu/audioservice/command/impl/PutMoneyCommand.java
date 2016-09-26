package by.bsu.audioservice.command.impl;

import by.bsu.audioservice.command.Command;
import by.bsu.audioservice.entity.UserAccount;
import by.bsu.audioservice.exception.TechnicalException;
import by.bsu.audioservice.logic.PutMoneyLogic;
import by.bsu.audioservice.manager.ConfigurationManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 7 on 13.09.2016.
 */
public class PutMoneyCommand implements Command {
    private static final String USER_ACCOUNT = "user_account";
    private static final String MONEY = "money";
    private static final Logger LOGGER = LogManager.getLogger(PutMoneyCommand.class);
    @Override
    public String execute(HttpServletRequest request) {
        LOGGER.info("Put the money command.");
        String page = null;
        try {
            Float money = Float.valueOf(request.getParameter(MONEY));
            UserAccount account = (UserAccount)request.getSession().getAttribute(USER_ACCOUNT);
            money = money + account.getBalance();
            account.setBalance(money);
            PutMoneyLogic.put(account.getUserAccountId(), money);
            request.getSession().setAttribute(USER_ACCOUNT, account);
            page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.USER_CABINET_PAGE_PATH);
        } catch (TechnicalException e) {
            LOGGER.error("Something was wrong, redirect to error page.");
        }
        return page;
    }
}
