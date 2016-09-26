package by.bsu.audioservice.logic;

import by.bsu.audioservice.dao.impl.CommentDAO;
import by.bsu.audioservice.entity.Comment;
import by.bsu.audioservice.exception.DAOException;
import by.bsu.audioservice.exception.TechnicalException;

import java.util.ArrayList;

/**
 * Created by 7 on 11.09.2016.
 */
public class CommentsLogic {


    public static ArrayList<Comment> takeComments() throws TechnicalException {
        try {
            return CommentDAO.getInstance().takeComments();
        } catch (DAOException e) {
            throw new TechnicalException("DAOException", e);
        }
    }
}
