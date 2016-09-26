package by.bsu.audioservice.util;

import by.bsu.audioservice.entity.Genre;

/**
 * Created by 7 on 05.09.2016.
 */
public class GenreUtil {
    private static final String HIP_HOP = "Hip-Hop";
    private static final String ROCK = "Rock";
    private static final String POP = "Pop";

    public static String getGenre(Genre genre){
        String genreStr = null;
        if (genre.equals(Genre.HIP_HOP)){
            genreStr = HIP_HOP;
        } else if (genre.equals(Genre.ROCK)){
            genreStr = ROCK;
        } else {
            genreStr = POP;
        }
        return genreStr;
    }
    public static Genre getGenreFromString(String genreStr){
        Genre genre;
        if (genreStr.toUpperCase().equals(HIP_HOP.toUpperCase())){
            genre = Genre.HIP_HOP;
        } else if (genreStr.toUpperCase().equals(POP.toUpperCase())){
            genre = Genre.POP;
        } else {
            genre = Genre.ROCK;
        }
        return genre;
    }
}
