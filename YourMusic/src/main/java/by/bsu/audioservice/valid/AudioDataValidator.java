package by.bsu.audioservice.valid;

import by.bsu.audioservice.entity.Genre;

/**
 * Created by 7 on 05.09.2016.
 */
public class AudioDataValidator {

    public static boolean isCorrectPrice(String price){
        boolean flag = true;
        try {
            Float.parseFloat(price);
        } catch (NumberFormatException e){
            flag = false;
        }
        return flag;
    }

    public static boolean isCorrectGenre(String genre){
        boolean flag = false;
        if (genre.toUpperCase().equals(Genre.HIP_HOP.toString()) ||genre.toUpperCase().equals(Genre.POP.toString()) ||
                genre.toUpperCase().equals(Genre.ROCK.toString())){
            flag = true;
        }
        return flag;
    }
}
