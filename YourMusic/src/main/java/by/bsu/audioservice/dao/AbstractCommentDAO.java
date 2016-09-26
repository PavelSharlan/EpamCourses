package by.bsu.audioservice.dao;

import by.bsu.audioservice.entity.Comment;
import by.bsu.audioservice.exception.DAOException;

import java.util.ArrayList;

/**
 * Created by 7 on 11.09.2016.
 */
public abstract class AbstractCommentDAO {
    public abstract ArrayList<Comment> takeComments() throws DAOException;
    public abstract boolean addComment(Comment comment) throws DAOException;
}
