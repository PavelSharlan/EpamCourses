package by.bsu.audioservice.entity;

/**
 * Class Order
 *
 * Created by 7 on 27.08.2016.
 */
public class Order {
    /** Field id */
    private Long id;

    /** Field singer */
    private String singer;

    /** Field audioName */
    private String audioName;

    /** Field userLogin */
    private String userLogin;

    /**
     * Instantiates a new Order.
     *
     * @param singer    the singer
     * @param audioName the audio name
     * @param userLogin the user login
     */
    public Order(String singer, String audioName, String userLogin) {
        this.singer = singer;
        this.audioName = audioName;
        this.userLogin = userLogin;
    }

    /**
     * Instantiates a new Order.
     *
     * @param id        the id
     * @param singer    the singer
     * @param audioName the audio name
     * @param userLogin the user login
     */
    public Order(Long id, String singer, String audioName, String userLogin) {
        this.id = id;
        this.singer = singer;
        this.audioName = audioName;
        this.userLogin = userLogin;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
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
     * Gets audio name.
     *
     * @return the audio name
     */
    public String getAudioName() {
        return audioName;
    }

    /**
     * Sets audio name.
     *
     * @param audioName the audio name
     */
    public void setAudioName(String audioName) {
        this.audioName = audioName;
    }

    /**
     * Gets user login.
     *
     * @return the user login
     */
    public String getUserLogin() {
        return userLogin;
    }

    /**
     * Sets user login.
     *
     * @param userLogin the user login
     */
    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    /**
     * Method toString
     *
     * @return String
     */
    @Override
    public String toString() {
        return "{\"id\":\"" + getId() + "\", \"userLogin\":\"" + userLogin + "\", \"singer\":\"" + singer +
                "\", \"audioName\":\"" + audioName + "\"}";
    }
}
