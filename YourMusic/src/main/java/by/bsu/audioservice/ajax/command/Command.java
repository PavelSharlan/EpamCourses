package by.bsu.audioservice.ajax.command;

import by.bsu.audioservice.exception.TechnicalException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Interface Command
 *
 * Created by 7 on 02.09.2016.
 */
public interface Command {

    /**
     * Method execute ...
     *
     * @param request of type HttpServletRequest
     * @param response of type HttpServletResponse
     * @param requestData of type String
     * @throws IOException when
     */
    void execute(HttpServletRequest request, HttpServletResponse response, String requestData) throws IOException;
}
