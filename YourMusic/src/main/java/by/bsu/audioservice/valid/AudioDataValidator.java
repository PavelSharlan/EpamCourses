package by.bsu.audioservice.valid;

import by.bsu.audioservice.entity.Genre;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class AudioDataValidator
 *
 * Created by 7 on 05.09.2016.
 */
public class AudioDataValidator {
    /** Field PRICE_REGEX */
    private static final String PRICE_REGEX = "(^[1-9]{1}$)";

    /**
     * Is correct price boolean.
     *
     * @param price the price
     * @return boolean
     */
    public static boolean isCorrectPrice(String price){
        boolean flag = false;
        Pattern pattern = Pattern.compile(PRICE_REGEX);
        Matcher matcher = pattern.matcher(price);
        if (matcher.find()){
            flag = true;
        }
        return flag;
    }

    /**
     * Is correct genre boolean.
     *
     * @param genre the genre
     * @return the boolean
     */
    public static boolean isCorrectGenre(String genre){
        boolean flag = false;
        if (genre.toUpperCase().equals(Genre.HIP_HOP.toString()) ||genre.toUpperCase().equals(Genre.POP.toString()) ||
                genre.toUpperCase().equals(Genre.ROCK.toString())){
            flag = true;
        }
        return flag;
    }
}
