package by.bsu.audioservice.command;

import by.bsu.audioservice.command.impl.EmptyCommand;

import javax.servlet.http.HttpServletRequest;

/**
 * Class CommandFactory
 *
 * Created by 7 on 19.07.2016.
 */
public class CommandFactory {
    /**
     * Define command
     *
     * @param request of type HttpServletRequest
     * @return Command
     */
    public static Command defineCommand(HttpServletRequest request){

        Command command = null;
        String action = request.getParameter("command");
        if (action == null || action.isEmpty()){
            command = new EmptyCommand();
            return command;
        }
        command = CommandType.valueOf(action.toUpperCase()).getCommand();

        return command;
    }
}
