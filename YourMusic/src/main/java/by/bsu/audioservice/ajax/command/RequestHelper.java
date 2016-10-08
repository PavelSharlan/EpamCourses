package by.bsu.audioservice.ajax.command;

import by.bsu.audioservice.ajax.command.impl.*;
import by.bsu.audioservice.ajax.util.JSONUtil;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.HashMap;

/**
 * Class RequestHelper
 *
 * Created by 7 on 07.09.2016.
 */
public class RequestHelper {
    /** Field instance  */
    private static RequestHelper instance = null;

    /** Field commands  */
    HashMap<String, Command> commands = new HashMap<String, Command>();

    /**
     * Constructor RequestHelper creates a new RequestHelper instance.
     */
    private RequestHelper(){
        commands.put("addAudioToBasket", new AudioToBasketCommand());
        commands.put("deletePurchaseFromBasket", new DeletePurchaseFromBasketCommand());
        commands.put("buyAudios", new BuyAudiosCommand());
        commands.put("showBasket", new ShowBasketCommand());
        commands.put("sendComment", new SendCommentCommand());
        commands.put("deleteUserAudio", new DeleteUserAudioCommand());
        commands.put("deleteOrder", new DeleteOrderCommand());
    };

    /**
     * Method getInstance returns the instance of this RequestHelper object.
     *
     * Field instance
     *
     * @return the instance (type RequestHelper) of this RequestHelper object.
     */
    public static RequestHelper getInstance(){
        if (instance == null){
            instance = new RequestHelper();
        }
        return instance;
    }

    /**
     * Method getCommand ...
     *
     * @param requestData of type String
     * @return Command
     * @throws IOException when
     */
    public Command getCommand(String requestData) throws IOException {
        JSONObject json = null;
        try{
            json = JSONUtil.stringToJson(requestData);
        } catch (ParseException e) {
            throw new IOException();
        }
        String action = JSONUtil.getCommand(json);
        Command command = commands.get(action);
        if (command == null){
            command = new NoCommand();
        }
        return command;
    }
}
