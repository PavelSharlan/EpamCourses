package by.bsu.audioservice.valid;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class BalanceValidator
 *
 * Created by 7 on 04.10.2016.
 */
public class BalanceValidator {
    /** Field BALANCE_REGEX */
    private static final String BALANCE_REGEX = "(^[1-9][0-9]{0,2}$)";

    /**
     * Valid boolean.
     *
     * @param balance the balance
     * @return the boolean
     */
    public static boolean valid(String balance){
        boolean flag = false;
        Pattern pattern = Pattern.compile(BALANCE_REGEX);
        Matcher matcher = pattern.matcher(balance);
        if (matcher.find()){
            flag = true;
        }
        return flag;
    }
}
