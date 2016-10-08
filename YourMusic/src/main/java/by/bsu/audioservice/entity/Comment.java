package by.bsu.audioservice.entity;

/**
 * Class Comment
 *
 * Created by 7 on 11.09.2016.
 */
public class Comment {
    /** Field commentId */
    private Long commentId;

    /** Field user */
    private User user;

    /** Field message */
    private String message;

    /** Field time */
    private String time;

    /**
     * Instantiates a new Comment.
     *
     * @param commentId the comment id
     * @param user      the user
     * @param message   the message
     * @param time      the time
     */
    public Comment(Long commentId, User user, String message, String time) {
        this.commentId = commentId;
        this.user = user;
        this.message = message;
        this.time = time;
    }

    /**
     * Instantiates a new Comment.
     *
     * @param user    the user
     * @param message the message
     * @param time    the time
     */
    public Comment(User user, String message, String time) {
        this.user = user;
        this.message = message;
        this.time = time;
    }

    /**
     * Gets comment id.
     *
     * @return the comment id
     */
    public Long getCommentId() {
        return commentId;
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
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Gets time.
     *
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * Sets comment id.
     *
     * @param commentId the comment id
     */
    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    /**
     * Method toString
     *
     * @return String
     */
    @Override
    public String toString() {
        return  "{\"commentId\":\"" + commentId + "\", \"user\":" + user
                + ", \"message\":\"" + message + "\", \"time\":\"" + time + "\"}";
    }
}
