package by.bsu.audioservice.entity;

/**
 * Class User
 * <p>
 * Created by 7 on 06.08.2016.
 */
public class User {
    /** Field userId */
    private Long userId;

    /** Field firstName */
    private String firstName;

    /** Field secondName */
    private String secondName;

    /** Field email */
    private String email;

    /** Field password */
    private String password;

    /** Field phoneNumber */
    private String phoneNumber;

    /** Field role */
    private Role role;

    /**
     * Instantiates a new User.
     *
     * @param userId      the user id
     * @param firstName   the first name
     * @param secondName  the second name
     * @param email       the email
     * @param password    the password
     * @param phoneNumber the phone number
     * @param role        the role
     */
    public User(Long userId, String firstName, String secondName, String email, String password, String phoneNumber, Role role) {
        this.userId = userId;
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    /**
     * Instantiates a new User.
     *
     * @param firstName   the first name
     * @param secondName  the second name
     * @param email       the email
     * @param password    the password
     * @param phoneNumber the phone number
     * @param role        the role
     */
    public User(String firstName, String secondName, String email, String password, String phoneNumber, Role role) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets second name.
     *
     * @return the second name
     */
    public String getSecondName() {
        return secondName;
    }

    /**
     * Sets second name.
     *
     * @param secondName the second name
     */
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets phone number.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets phone number.
     *
     * @param phoneNumber the phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets role.
     *
     * @return the role
     */
    public Role getRole() {
        return role;
    }

    /**
     * Sets role.
     *
     * @param role the role
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * Gets user id.
     *
     * @return the user id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * Sets user id.
     *
     * @param userId the user id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * Method toString
     *
     * @return String
     */
    @Override
    public String toString() {
        return "{\"userId\":\"" + userId + "\", \"firstName\":\"" + firstName + "\", \"secondName\":\""
                + secondName + "\", \"email\":\"" + email + "\", " +
                " \"phoneNumber\":\"" + phoneNumber + "\", \"role\":\"" + role.toString() + "\"}";

    }
}
