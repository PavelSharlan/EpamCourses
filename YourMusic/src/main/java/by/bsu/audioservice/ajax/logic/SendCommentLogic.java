package by.bsu.audioservice.ajax.logic;

import by.bsu.audioservice.ajax.util.JSONUtil;
import by.bsu.audioservice.dao.impl.CommentDAO;
import by.bsu.audioservice.entity.Comment;
import by.bsu.audioservice.entity.User;
import by.bsu.audioservice.exception.DAOException;
import by.bsu.audioservice.exception.TechnicalException;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 7 on 11.09.2016.
 */
public class SendCommentLogic {
    private static final String COMMENT = "comment";
    public static String sendComment(String requestData, User user) throws TechnicalException {
        JSONObject json = null;
        try {
            json = JSONUtil.stringToJson(requestData);
            String message = JSONUtil.jsonToMessage(json);
            Date dNow = new Date( );
            SimpleDateFormat ft =
                    new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
            Comment comment = new Comment(user, message, ft.format(dNow));
            json = new JSONObject();
            json.put(COMMENT, comment);
            CommentDAO.getInstance().addComment(comment);
        } catch (ParseException e) {

        } catch (DAOException e) {
            throw new TechnicalException("DAOException", e);
        }
        return json.toJSONString();
    }
}
