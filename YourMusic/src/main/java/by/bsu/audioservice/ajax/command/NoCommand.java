package by.bsu.audioservice.ajax.command;

import by.bsu.audioservice.exception.TechnicalException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by 7 on 07.09.2016.
 */
public class NoCommand implements Command {
    private static final String MESSAGE = "message";
    private static final Logger LOGGER = LogManager.getLogger(NoCommand.class);
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
