package by.bsu.audioservice.ajax.util;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Class JSONUtil
 *
 * Created by 7 on 02.09.2016.
 */
public class JSONUtil {

    /** Field COMMAND */
    private static final String COMMAND = "command";

    /** Field ID */
    private static final String ID = "id";

    /**Field MESSAGE */
    private static final String MESSAGE = "message";

    /**
     * Constructor JSONUtil creates a new JSONUtil instance.
     */
    public JSONUtil(){}

    /**
     * Method getCommand
     *
     * @param jsonObject of type JSONObject
     * @return String
     */
    public static String getCommand(JSONObject jsonObject){
        return (String) jsonObject.get(COMMAND);
    }

    /**
     * Method stringToJson
     *
     * @param data of type String
     * @return JSONObject
     * @throws ParseException
     */
    public static JSONObject stringToJson(String data) throws ParseException {
        JSONParser jsonParser = new JSONParser();
        return (JSONObject) jsonParser.parse(data.trim());
    }

    /**
     * Method jsonToId
     *
     * @param json of type JSONObject
     * @return Long
     */
    public static Long jsonToId(JSONObject json) {
        return Long.parseLong((String)json.get(ID));
    }

    /**
     * Method jsonToMessage
     *
     * @param json of type JSONObject
     * @return String
     */
    public static String jsonToMessage(JSONObject json){
        return (String)json.get(MESSAGE);
    }
}
