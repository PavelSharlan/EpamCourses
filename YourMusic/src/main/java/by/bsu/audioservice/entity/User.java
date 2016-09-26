package by.bsu.audioservice.entity;

/**
 * Created by 7 on 06.08.2016.
 */
public class User {
    private Long userId;
    private String firstName;
    private String secondName;
    private String email;
    private String password;
    private String phoneNumber;
    private Role role;

    public User(Long userId, String firstName, String secondName, String email, String password, String phoneNumber, Role role) {
        this.userId = userId;
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    public User(String firstName, String secondName, String email, String password, String phoneNumber, Role role) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "{\"userId\":\"" + userId + "\", \"firstName\":\"" + firstName + "\", \"secondName\":\""
                + secondName + "\", \"email\":\"" + email + "\", " +
                " \"phoneNumber\":\"" + phoneNumber + "\", \"role\":\"" + role.toString() + "\"}";

    }
}
