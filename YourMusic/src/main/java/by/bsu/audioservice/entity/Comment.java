package by.bsu.audioservice.entity;

/**
 * Created by 7 on 11.09.2016.
 */
public class Comment {
    private Long commentId;
    private User user;
    private String message;
    private String time;

    public Comment(Long commentId, User user, String message, String time) {
        this.commentId = commentId;
        this.user = user;
        this.message = message;
        this.time = time;
    }

    public Comment(User user, String message, String time) {
        this.user = user;
        this.message = message;
        this.time = time;
    }

    public Long getCommentId() {
        return commentId;
    }

    public User getUser() {
        return user;
    }

    public String getMessage() {
        return message;
    }

    public String getTime() {
        return time;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    @Override
    public String toString() {
        return  "{\"commentId\":\"" + commentId + "\", \"user\":" + user
                + ", \"message\":\"" + message + "\", \"time\":\"" + time + "\"}";
    }
}
