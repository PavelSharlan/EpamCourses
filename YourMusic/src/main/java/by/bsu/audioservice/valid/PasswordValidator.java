package by.bsu.audioservice.valid;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 7 on 16.08.2016.
 */
public class PasswordValidator {

    private static final String PASSWORD_REGEX = ".{6,}";

    /**
     * Validate boolean.
     *
     * @param password the password
     * @return the boolean
     */
    public static boolean validate(String password){
        boolean flag = false;
        Pattern pattern = Pattern.compile(PASSWORD_REGEX);
        Matcher matcher = pattern.matcher(password);
        if (matcher.find()){
            flag = true;
        }
        return flag;
    }
}
