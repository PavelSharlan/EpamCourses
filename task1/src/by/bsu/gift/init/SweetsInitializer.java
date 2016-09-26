package by.bsu.gift.init;

import by.bsu.gift.entity.Sweet;
import by.bsu.gift.exception.IncorrectValueException;
import by.bsu.gift.exception.UnknownSweetException;
import by.bsu.gift.action.JSONWorker;
import by.bsu.gift.util.SweetTag;
import by.bsu.gift.valid.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


import java.util.ArrayList;

/**
 * Created by 7 on 18.05.2016.
 */
public class SweetsInitializer {
    private static final Logger LOGGER =  LogManager.getLogger(SweetsInitializer.class);

    public static ArrayList<Sweet> init(JSONObject jsonObject) throws UnknownSweetException {
        ArrayList<Sweet> sweetsArrayList = new ArrayList<Sweet>();

        JSONArray jsonArray = JSONWorker.objectToArray(jsonObject);
        for (Object aJsonArray : jsonArray) {
            JSONObject object = (JSONObject) aJsonArray;
            String type = (String) object.get(SweetTag.TYPE);
            switch (type) {
                case SweetTag.LOLLIPOP:
                    if (Validator.lollipopJSONValid(object)){
                        try {
                            sweetsArrayList.add(JSONWorker.jsonToLollipop(object));
                        } catch (IncorrectValueException e) {
                            LOGGER.error("Something is wrong with values", e);
                        }
                    }
                    break;
                case SweetTag.LOLLIPOP_AT_WAND:
                    if (Validator.lollipopAtWandJSONValid(object)){
                        try {
                            sweetsArrayList.add(JSONWorker.jsonToLollipopAtWand(object));
                        } catch (IncorrectValueException e) {
                            LOGGER.error("Something is wrong with values", e);
                        }
                    }
                    break;
                case SweetTag.GLAZED_CANDY:
                    if (Validator.glazedCandyJSONValid(object)){
                        try {
                            sweetsArrayList.add(JSONWorker.jsonToGlazedCandy(object));
                        } catch (IncorrectValueException e) {
                            LOGGER.error("Something is wrong with values", e);
                        }
                    }
                    break;
                case SweetTag.WAFER:
                    if (Validator.waferJSONVAlid(object)){
                        try {
                            sweetsArrayList.add(JSONWorker.jsonToWafer(object));
                        } catch (IncorrectValueException e) {
                            LOGGER.error("Something is wrong with values", e);
                        }
                    }
                    break;
                default:
                    throw new UnknownSweetException("There is no such sweet!");
            }
        }
        return sweetsArrayList;
    }
}
