package by.bsu.audioservice.ajax.command.impl;

import by.bsu.audioservice.ajax.command.Command;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Class NoCommand
 *
 * Created by 7 on 07.09.2016.
 */
public class NoCommand implements Command {
    /** Field MESSAGE */
    private static final String MESSAGE = "message";

    /** Field LOGGER */
    private static final Logger LOGGER = LogManager.getLogger(NoCommand.class);

    /**
     * Method execute ...
     *
     * @param request of type HttpServletRequest
     * @param response of type HttpServletResponse
     * @param requestData of type String
     * @throws IOException when
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, String requestData) throws IOException{
        LOGGER.info("No command");
        PrintWriter out = response.getWriter();
        JSONObject object = new JSONObject();
        try{
            object.put(MESSAGE, "Unsupported command");
            out.println();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } finally {
            out.flush();
            out.close();
        }
    }
}
