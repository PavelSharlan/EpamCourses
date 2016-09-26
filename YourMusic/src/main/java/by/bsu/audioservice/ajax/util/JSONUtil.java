package by.bsu.audioservice.ajax.util;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Created by 7 on 02.09.2016.
 */
public class JSONUtil {
    private static final String COMMAND = "command";
    private static final String ID = "id";
    private static final String MESSAGE = "message";

    public JSONUtil(){}

    public static String getCommand(JSONObject jsonObject){
        return (String) jsonObject.get(COMMAND);
    }

    public static JSONObject stringToJson(String data) throws ParseException {
        JSONParser jsonParser = new JSONParser();
        return (JSONObject) jsonParser.parse(data.trim());
    }

    public static Long jsonToId(JSONObject json) {
        return Long.parseLong((String)json.get(ID));
    }

    public static String jsonToMessage(JSONObject json){
        return (String)json.get(MESSAGE);
    }
}
