package by.bsu.audioservice.entity;

/**
 * Class Audio
 *
 * Created by 7 on 18.08.2016.
 */
public class Audio {
    /** Field audioId */
    private Long audioId;

    /** Field singer */
    private String singer;

    /** Field name */
    private String name;

    /** Field url */
    private String url;

    /** Field price */
    private Float price;

    /** Field genre */
    private Genre genre;

    /**
     * Instantiates a new Audio.
     *
     * @param audioID the audio id
     * @param singer  the singer
     * @param name    the name
     * @param url     the url
     * @param price   the price
     * @param genre   the genre
     */
    public Audio(Long audioID, String singer, String name, String url, Float price, Genre genre) {
        this.audioId = audioID;
        this.singer = singer;
        this.name = name;
        this.url = url;
        this.price = price;
        this.genre = genre;
    }

    /**
     * Instantiates a new Audio.
     *
     * @param singer the singer
     * @param name   the name
     * @param url    the url
     * @param price  the price
     * @param genre  the genre
     */
    public Audio(String singer, String name, String url, Float price, Genre genre) {
        this.singer = singer;
        this.name = name;
        this.url = url;
        this.price = price;
        this.genre = genre;
    }

    /**
     * Gets audio id.
     *
     * @return the audio id
     */
    public Long getAudioId() {
        return audioId;
    }

    /**
     * Sets audio id.
     *
     * @param audioId the audio id
     */
    public void setAudioId(Long audioId) {
        this.audioId = audioId;
    }

    /**
     * Gets singer.
     *
     * @return the singer
     */
    public String getSinger() {
        return singer;
    }

    /**
     * Sets singer.
     *
     * @param singer the singer
     */
    public void setSinger(String singer) {
        this.singer = singer;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets url.
     *
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets url.
     *
     * @param url the url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public Float getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(Float price) {
        this.price = price;
    }

    /**
     * Gets genre.
     *
     * @return the genre
     */
    public Genre getGenre() {
        return genre;
    }

    /**
     * Sets genre.
     *
     * @param genre the genre
     */
    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    /**
     * Method toString
     *
     * @return String
     */
    @Override
    public String toString() {
        return "{\"audioId\":\"" + audioId + "\", \"singer\":\"" + singer + "\", \"name\":\"" + name +
                "\", \"price\":\"" + price + "\", \"genre\":\"" + genre.toString() + "\"}";
    }


    /**
     * Method equals
     *
     * @param o of type Object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Audio audio = (Audio) o;

        if (!audioId.equals(audio.audioId)) return false;
        if (genre != audio.genre) return false;
        if (!name.equals(audio.name)) return false;
        if (!price.equals(audio.price)) return false;
        if (!singer.equals(audio.singer)) return false;
        if (!url.equals(audio.url)) return false;

        return true;
    }

    /**
     * Method hashCode
     *
     * @return int
     */
    @Override
    public int hashCode() {
        int result = audioId.hashCode();
        result = 31 * result + singer.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + url.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + genre.hashCode();
        return result;
    }
}
