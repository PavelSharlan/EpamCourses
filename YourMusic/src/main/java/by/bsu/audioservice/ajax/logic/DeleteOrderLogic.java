package by.bsu.audioservice.ajax.logic;

import by.bsu.audioservice.ajax.util.JSONUtil;
import by.bsu.audioservice.dao.impl.OrderDAO;
import by.bsu.audioservice.exception.DAOException;
import by.bsu.audioservice.exception.TechnicalException;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

/**
 * Class DeleteOrderLogic
 *
 * Created by 7 on 06.09.2016.
 */
public class DeleteOrderLogic {

    /**
     * Method delete
     *
     * @param requestData of type String
     * @throws TechnicalException
     */
    public static void delete(String requestData) throws TechnicalException {
        try {
            JSONObject json = JSONUtil.stringToJson(requestData);
            Long id = JSONUtil.jsonToId(json);
            OrderDAO.getInstance().deleteOrderById(id);
        } catch (ParseException e) {
            throw new TechnicalException("ParseException", e);
        } catch (DAOException e) {
            throw new TechnicalException("DAOException", e);
        }
    }
}
