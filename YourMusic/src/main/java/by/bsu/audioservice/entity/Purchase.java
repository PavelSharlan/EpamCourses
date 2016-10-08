package by.bsu.audioservice.entity;

/**
 * Class Purchase
 *
 * Created by 7 on 07.09.2016.
 */
public class Purchase {
    /** Field id */
    private Long id;

    /** Field userAccount */
    private UserAccount userAccount;

    /** Field audio */
    private Audio audio;

    /**
     * Instantiates a new Purchase.
     *
     * @param id          the id
     * @param userAccount the user account
     * @param audio       the audio
     */
    public Purchase(Long id, UserAccount userAccount, Audio audio) {
        this.id = id;
        this.userAccount = userAccount;
        this.audio = audio;
    }

    /**
     * Instantiates a new Purchase.
     *
     * @param userAccount the user account
     * @param audio       the audio
     */
    public Purchase(UserAccount userAccount, Audio audio) {
        this.userAccount = userAccount;
        this.audio = audio;
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
     * Gets user account.
     *
     * @return the user account
     */
    public UserAccount getUserAccount() {
        return userAccount;
    }

    /**
     * Gets audio.
     *
     * @return the audio
     */
    public Audio getAudio() {
        return audio;
    }

    /**
     * Method toString
     *
     * @return String
     */
    @Override
    public String toString() {
        return "{\"id\":\"" + getId() + "\", \"userAccount\":" + userAccount + ", \"audio\":" + audio + "}";
    }
}
