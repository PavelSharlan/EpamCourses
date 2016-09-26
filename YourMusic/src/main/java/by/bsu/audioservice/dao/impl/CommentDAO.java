package by.bsu.audioservice.dao.impl;

import by.bsu.audioservice.dao.AbstractCommentDAO;
import by.bsu.audioservice.entity.Comment;
import by.bsu.audioservice.entity.Role;
import by.bsu.audioservice.entity.User;
import by.bsu.audioservice.exception.DAOException;
import by.bsu.audioservice.pool.ConnectionPool;
import by.bsu.audioservice.pool.ProxyConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by 7 on 11.09.2016.
 */
public class CommentDAO extends AbstractCommentDAO {
    private static final String SQL_SELECT_ALL_COMMENTS = "SELECT c.comment_id, c.message, c.time, c.user_id," +
            " u.first_name, u.last_name, u.email, u.password, u.phone_number, u.role FROM comments AS c JOIN users AS u " +
            "ON c.user_id = u.user_id ORDER BY c.time desc;";
    private static final String SQL_INSERT_COMMENT = "INSERT INTO comments (user_id, message, time) VALUES (?, ?, ?);";

    private static final String MESSAGE = "message";
    private static final String COMMENT_ID = "comment_id";
    private static final String USER_ID = "user_id";
    private static final String TIME = "time";
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String EMAIL = "email";
    private static final String PHONE_NUMBER = "phone_number";
    private static final String ROLE = "role";
    private static final String PASSWORD = "password";

    private static CommentDAO instance = CommentDAO.getInstance();

    private static final Logger LOGGER = LogManager.getLogger(CommentDAO.class);
    private CommentDAO(){
    }

    public static CommentDAO getInstance(){
        if (instance == null){
            instance = new CommentDAO();
        }
        return instance;
    }

    @Override
    public ArrayList<Comment> takeComments() throws DAOException {
        ArrayList<Comment> comments = new ArrayList<Comment>();
        try(ProxyConnection cn = ConnectionPool.getInstance().takeConnection();
        PreparedStatement st = cn.prepareStatement(SQL_SELECT_ALL_COMMENTS)){
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                String message = rs.getString(MESSAGE);
                String password = rs.getString(PASSWORD);
                String firstName = rs.getString(FIRST_NAME);
                String lastName = rs.getString(LAST_NAME);
                String phone = rs.getString(PHONE_NUMBER);
                Role role = Role.valueOf(rs.getString(ROLE).toUpperCase());
                String time = rs.getTimestamp(TIME).toString();
                Long commentId = rs.getLong(COMMENT_ID);
                Long userId = rs.getLong(USER_ID);
                String email = rs.getString(EMAIL);
                User user = new User(userId, firstName, lastName, email, password, phone, role);
                Comment comment = new Comment(commentId, user, message, time);
                comments.add(comment);
            }
        } catch (SQLException e) {
            throw new DAOException("SQLException in CommentDAO(takeComments)");
        }
        return comments;
    }
    @Override
    public boolean addComment(Comment comment) throws DAOException {
        boolean flag = false;
        try(ProxyConnection cn = ConnectionPool.getInstance().takeConnection();
        PreparedStatement st = cn.prepareStatement(SQL_INSERT_COMMENT)){
            st.setLong(1, comment.getUser().getUserId());
            st.setString(2, comment.getMessage());
            st.setString(3, comment.getTime());
            st.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            throw new DAOException("SQLException in CommentDAO(addComment)");
        }
        return flag;
    }
}
