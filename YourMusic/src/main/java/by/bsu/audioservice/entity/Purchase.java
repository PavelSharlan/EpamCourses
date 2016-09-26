package by.bsu.audioservice.entity;

/**
 * Created by 7 on 07.09.2016.
 */
public class Purchase {
    private Long id;
    private UserAccount userAccount;
    private Audio audio;

    public Purchase(Long id, UserAccount userAccount, Audio audio) {
        this.id = id;
        this.userAccount = userAccount;
        this.audio = audio;
    }

    public Purchase(UserAccount userAccount, Audio audio) {
        this.userAccount = userAccount;
        this.audio = audio;
    }

    public Long getId() {
        return id;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public Audio getAudio() {
        return audio;
    }

    @Override
    public String toString() {
        return "{\"id\":\"" + getId() + "\", \"userAccount\":" + userAccount + ", \"audio\":" + audio + "}";
    }
}
