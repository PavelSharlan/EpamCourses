package by.bsu.audioservice.util;

import by.bsu.audioservice.entity.Genre;

/**
 * Class GenreUtil
 *
 * Created by 7 on 05.09.2016.
 */
public class GenreUtil {
    /** Field HIP_HOP */
    private static final String HIP_HOP = "Hip-Hop";

    /** Field ROCK */
    private static final String ROCK = "Rock";

    /** Field POP */
    private static final String POP = "Pop";

    /**
     * Get genre string.
     *
     * @param genre the genre
     * @return the string
     */
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

    /**
     * Get genre from string genre.
     *
     * @param genreStr the genre str
     * @return the genre
     */
    public static Genre getGenreFromString(String genreStr){
        Genre genre;
        if (genreStr.toUpperCase().equals(HIP_HOP.toUpperCase().replace("_", "-"))){
            genre = Genre.HIP_HOP;
        } else if (genreStr.toUpperCase().equals(POP.toUpperCase())){
            genre = Genre.POP;
        } else  {
            genre = Genre.ROCK;
        }
        return genre;
    }
}
