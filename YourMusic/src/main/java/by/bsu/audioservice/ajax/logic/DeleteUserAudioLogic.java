package by.bsu.audioservice.ajax.logic;

import by.bsu.audioservice.ajax.util.JSONUtil;
import by.bsu.audioservice.dao.impl.UserAccountDAO;
import by.bsu.audioservice.exception.DAOException;
import by.bsu.audioservice.exception.TechnicalException;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

/**
 * Created by 7 on 14.09.2016.
 */
public class DeleteUserAudioLogic {
    public static boolean delete(String requestData, Long accountId) throws TechnicalException {
        boolean flag = false;
        try {
            JSONObject json = JSONUtil.stringToJson(requestData);
            Long audioId = JSONUtil.jsonToId(json);
            flag = UserAccountDAO.getInstance().deleteAudioFromUserAccount(audioId, accountId);
        } catch (DAOException e) {
            throw new TechnicalException("DAOException", e);
        } catch (ParseException e) {
            throw new TechnicalException("ParseException", e);
        }
        return flag;
    }
}
