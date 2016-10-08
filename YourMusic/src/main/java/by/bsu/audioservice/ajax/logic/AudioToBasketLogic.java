package by.bsu.audioservice.ajax.logic;

import by.bsu.audioservice.ajax.util.JSONUtil;
import by.bsu.audioservice.dao.impl.AudioDAO;
import by.bsu.audioservice.dao.impl.PurchaseDAO;
import by.bsu.audioservice.dao.impl.UserAccountDAO;
import by.bsu.audioservice.entity.Audio;
import by.bsu.audioservice.entity.Purchase;
import by.bsu.audioservice.entity.UserAccount;
import by.bsu.audioservice.exception.DAOException;
import by.bsu.audioservice.exception.LogicException;
import by.bsu.audioservice.exception.TechnicalException;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

/**
 * Class AudioToBasketLogic
 *
 * Created by 7 on 07.09.2016.
 */
public class AudioToBasketLogic {

    /**
     * Method add
     *
     * @param requestData of type String
     * @param account of type UserAccount
     * @throws TechnicalException
     */
    public static void add(String requestData, UserAccount account) throws TechnicalException, LogicException {
        try {
            JSONObject object = JSONUtil.stringToJson(requestData);
            Long audioId = JSONUtil.jsonToId(object);
            Long accountId = account.getUserAccountId();
            if (!UserAccountDAO.getInstance().isAccountHasAudio(accountId, audioId)
                    & !PurchaseDAO.getInstance().isBasketHasAudio(accountId, audioId)) {
                Audio audio = AudioDAO.getInstance().takeAudioByAudioId(audioId);
                Purchase purchase = new Purchase(account, audio);
                PurchaseDAO.getInstance().addPurchaseToBasket(purchase);
            } else {
                throw new LogicException("There is such in basket or in your owns!");
            }
        } catch (ParseException e) {
            throw new TechnicalException("ParseException", e);
        } catch (DAOException e) {
            throw new TechnicalException("DAOException", e);
        }
    }
}
