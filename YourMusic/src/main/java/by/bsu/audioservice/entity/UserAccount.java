package by.bsu.audioservice.entity;

/**
 * Created by 7 on 10.08.2016.
 */
public class UserAccount {
    private Long userAccountId;
    private User user;
    private String creatingDate;
    private String endDate;
    private Float balance;

    public UserAccount(Long userAccountId, User user, String creatingDate, String endDate, Float balance) {
        this.userAccountId = userAccountId;
        this.user = user;
        this.creatingDate = creatingDate;
        this.endDate = endDate;
        this.balance = balance;
    }

    public UserAccount(User user, String creatingDate, Float balance) {
        this.user = user;
        this.creatingDate = creatingDate;
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCreatingDate() {
        return creatingDate;
    }

    public void setCreatingDate(String creatingDate) {
        this.creatingDate = creatingDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public Long getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(Long userAccountId) {
        this.userAccountId = userAccountId;
    }

    @Override
    public String toString() {
        return  "{\"userAccountId\":\"" + userAccountId + "\", \"user\":" + user + ", \"creatingDate\":\""
                + creatingDate + "\", \"endDate\":\"" + endDate + "\", \"balance\":\"" + balance + "\"}";
    }
}
