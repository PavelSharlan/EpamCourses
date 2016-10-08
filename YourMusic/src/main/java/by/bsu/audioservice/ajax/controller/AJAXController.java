package by.bsu.audioservice.ajax.controller;

import by.bsu.audioservice.ajax.command.Command;
import by.bsu.audioservice.ajax.command.RequestHelper;
import by.bsu.audioservice.ajax.util.AJAXServletUtil;
import by.bsu.audioservice.exception.TechnicalException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class AJAXController
 *
 * Created by 7 on 02.09.2016.
 */
@WebServlet("/ajaxController")
public class AJAXController extends HttpServlet {
    /** Field LOGGER */
    private static final Logger LOGGER = LogManager.getLogger(AJAXController.class);

    /**
     * Method init
     * @throws ServletException when
     */
    @Override
    public void init() throws ServletException {
    }

    /**
     * Method doGet ...
     *
     * @param request of type HttpServletRequest
     * @param response of type HttpServletResponse
     * @throws IOException when
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LOGGER.info("Get method");
        processRequest(request, response);
    }

    /**
     * Method doPost ...
     *
     * @param request of type HttpServletRequest
     * @param response of type HttpServletResponse
     * @throws IOException when
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LOGGER.info("Post method");
        processRequest(request, response);
    }

    /**
     * Method processRequest ...
     *
     * @param request of type HttpServletRequest
     * @param response of type HttpServletResponse
     * @throws IOException when
     */
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType(AJAXServletUtil.APPLICATION_JSON);
        response.setCharacterEncoding(AJAXServletUtil.UTF_8);
        String requestData = AJAXServletUtil.getRequestBody(request);
        Command command = RequestHelper.getInstance().getCommand(requestData);
        command.execute(request, response, requestData);
    }
}
