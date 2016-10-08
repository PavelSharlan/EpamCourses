package by.bsu.audioservice.dao;

import by.bsu.audioservice.entity.Comment;
import by.bsu.audioservice.exception.DAOException;

import java.util.ArrayList;

/**
 * Class AbstractCommentDAO
 * <p>
 * Created by 7 on 11.09.2016.
 */
public abstract class AbstractCommentDAO {
    /**
     * Take comments
     *
     * @return ArrayList<Comment>
     * @throws DAOException
     */
    public abstract ArrayList<Comment> takeComments() throws DAOException;

    /**
     * Add comment
     *
     * @param comment of type Comment
     * @return boolean
     * @throws DAOException
     */
    public abstract boolean addComment(Comment comment) throws DAOException;
}
