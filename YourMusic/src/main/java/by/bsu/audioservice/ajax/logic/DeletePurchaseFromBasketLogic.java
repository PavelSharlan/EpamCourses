package by.bsu.audioservice.ajax.logic;

import by.bsu.audioservice.ajax.util.JSONUtil;
import by.bsu.audioservice.dao.impl.PurchaseDAO;
import by.bsu.audioservice.exception.DAOException;
import by.bsu.audioservice.exception.TechnicalException;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

/**
 * Created by 7 on 09.09.2016.
 */
public class DeletePurchaseFromBasketLogic {
    public static void delete(String requestData) throws TechnicalException {
        JSONObject json = null;
        try {
            json = JSONUtil.stringToJson(requestData);
            Long id = JSONUtil.jsonToId(json);
            PurchaseDAO.getInstance().deletePurchaseById(id);
        } catch (ParseException e) {
            throw new TechnicalException("ParseException", e);
        } catch (DAOException e) {
            throw new TechnicalException("DAOException");
        }
    }
}
