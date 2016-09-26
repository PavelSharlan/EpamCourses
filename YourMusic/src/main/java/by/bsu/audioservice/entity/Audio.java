package by.bsu.audioservice.entity;

/**
 * Created by 7 on 18.08.2016.
 */
public class Audio {
    private Long audioId;
    private String singer;
    private String name;
    private String url;
    private Float price;
    private Genre genre;

    public Audio(Long audioID, String singer, String name, String url, Float price, Genre genre) {
        this.audioId = audioID;
        this.singer = singer;
        this.name = name;
        this.url = url;
        this.price = price;
        this.genre = genre;
    }

    public Audio(String singer, String name, String url, Float price, Genre genre) {
        this.singer = singer;
        this.name = name;
        this.url = url;
        this.price = price;
        this.genre = genre;
    }

    public Long getAudioId() {
        return audioId;
    }

    public void setAudioId(Long audioId) {
        this.audioId = audioId;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "{\"audioId\":\"" + audioId + "\", \"singer\":\"" + singer + "\", \"name\":\"" + name +
                "\", \"price\":\"" + price + "\", \"genre\":\"" + genre.toString() + "\"}";
    }

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
