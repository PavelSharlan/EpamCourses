package by.bsu.audioservice.entity;

/**
 * Class UserAccount
 *
 * Created by 7 on 10.08.2016.
 */
public class UserAccount {
    /** Field userAccountId */
    private Long userAccountId;

    /** Field user */
    private User user;

    /** Field creatingDate */
    private String creatingDate;

    /** Field endDate */
    private String endDate;

    /** Field balance */
    private Float balance;

    /**
     * Instantiates a new User account.
     *
     * @param userAccountId the user account id
     * @param user          the user
     * @param creatingDate  the creating date
     * @param endDate       the end date
     * @param balance       the balance
     */
    public UserAccount(Long userAccountId, User user, String creatingDate, String endDate, Float balance) {
        this.userAccountId = userAccountId;
        this.user = user;
        this.creatingDate = creatingDate;
        this.endDate = endDate;
        this.balance = balance;
    }

    /**
     * Instantiates a new User account.
     *
     * @param user         the user
     * @param creatingDate the creating date
     * @param balance      the balance
     */
    public UserAccount(User user, String creatingDate, Float balance) {
        this.user = user;
        this.creatingDate = creatingDate;
        this.balance = balance;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets creating date.
     *
     * @return the creating date
     */
    public String getCreatingDate() {
        return creatingDate;
    }

    /**
     * Sets creating date.
     *
     * @param creatingDate the creating date
     */
    public void setCreatingDate(String creatingDate) {
        this.creatingDate = creatingDate;
    }

    /**
     * Gets end date.
     *
     * @return the end date
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * Sets end date.
     *
     * @param endDate the end date
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * Gets balance.
     *
     * @return the balance
     */
    public Float getBalance() {
        return balance;
    }

    /**
     * Sets balance.
     *
     * @param balance the balance
     */
    public void setBalance(Float balance) {
        this.balance = balance;
    }

    /**
     * Gets user account id.
     *
     * @return the user account id
     */
    public Long getUserAccountId() {
        return userAccountId;
    }

    /**
     * Sets user account id.
     *
     * @param userAccountId the user account id
     */
    public void setUserAccountId(Long userAccountId) {
        this.userAccountId = userAccountId;
    }

    /**
     * Method toString
     *
     * @return String
     */
    @Override
    public String toString() {
        return  "{\"userAccountId\":\"" + userAccountId + "\", \"user\":" + user + ", \"creatingDate\":\""
                + creatingDate + "\", \"endDate\":\"" + endDate + "\", \"balance\":\"" + balance + "\"}";
    }
}
