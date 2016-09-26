package by.bsu.gift.action;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

/**
 * Created by 7 on 18.05.2016.
 */
public class JSONLoader {
    private static final Logger LOGGER = LogManager.getLogger(JSONLoader.class);

    public static JSONObject readFromFile(String path){

        JSONParser parser = new JSONParser();
        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject = (JSONObject) parser.parse(new FileReader(path));
        } catch (IOException e) {
            LOGGER.error("Something is wrong with IO", e);
        } catch (ParseException e) {
            LOGGER.error("Something is wrong with parsing", e);
        }

        return jsonObject;
    }
}
