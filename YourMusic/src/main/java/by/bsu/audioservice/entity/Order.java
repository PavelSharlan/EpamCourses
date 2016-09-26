package by.bsu.audioservice.entity;

/**
 * Created by 7 on 27.08.2016.
 */
public class Order {
    private Long id;
    private String singer;
    private String audioName;
    private String userLogin;

    public Order(String singer, String audioName, String userLogin) {
        this.singer = singer;
        this.audioName = audioName;
        this.userLogin = userLogin;
    }

    public Order(Long id, String singer, String audioName, String userLogin) {
        this.id = id;
        this.singer = singer;
        this.audioName = audioName;
        this.userLogin = userLogin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getAudioName() {
        return audioName;
    }

    public void setAudioName(String audioName) {
        this.audioName = audioName;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    @Override
    public String toString() {
        return "{\"id\":\"" + getId() + "\", \"userLogin\":\"" + userLogin + "\", \"singer\":\"" + singer +
                "\", \"audioName\":\"" + audioName + "\"}";
    }
}
