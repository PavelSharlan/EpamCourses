package by.bsu.audioservice.valid;

import by.bsu.audioservice.entity.User;
import by.bsu.audioservice.exception.LogicException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class UserDataValidator
 * <p>
 * Created by 7 on 16.08.2016.
 */
public class UserDataValidator {
    /** Field EMAIL_REGEX */
    private static final String EMAIL_REGEX = "([a-z0-9!#$%&'*+\\/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+\\/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?)";

    /** Field PHONE_REGEX */
    private static final String PHONE_REGEX = "(80[17|25|29|33|44][0-9]{8})";

    /** Field NAME_REGEX */
    private static final String NAME_REGEX = "[A-ZА-ЯЁ][a-zа-яё]{2,15}";

    /** Field LAST_NAME_REGEX */
    /**
     * Validate boolean.
     *
     * @param user of type User
     * @return boolean
     * @throws LogicException the logic exception
     */
    public static boolean validate(User user){
        boolean flag = false;
        if (fieldValidate(user.getEmail(), EMAIL_REGEX) && fieldValidate(user.getFirstName(), NAME_REGEX) &&
                fieldValidate(user.getSecondName(), NAME_REGEX) && fieldValidate(user.getPhoneNumber(), PHONE_REGEX)){
            flag = true;
        }
        return flag;
    }

    /**
     * Method fieldValidate
     *
     * @param field of type String
     * @param regex of type String
     * @return boolean
     */
    private static boolean fieldValidate(String field, String regex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(field);
        if (matcher.find()){
            return true;
        }
        return false;
    }

}
