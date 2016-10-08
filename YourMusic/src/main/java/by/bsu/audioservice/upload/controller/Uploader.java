package by.bsu.audioservice.upload.controller;

import by.bsu.audioservice.manager.ConfigurationManager;
import by.bsu.audioservice.upload.command.LoadAudioCommand;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class Uploader
 *
 * Created by 7 on 30.08.2016.
 */
@WebServlet("/uploader")
@MultipartConfig
public class Uploader extends HttpServlet {
    /** Field ERROR */
    private static final String ERROR = "error";

    /**
     * Method doPost
     *
     * @param request of type HttpServletRequest
     * @param response of type HttpServletResponse
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Process request.
     *
     * @param request  the request
     * @param response the response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response){
        LoadAudioCommand command = new LoadAudioCommand();
        command.execute(request);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(ConfigurationManager.getInstance().getProperty(ConfigurationManager.ADMIN_CABINET_PAGE_PATH));
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            request.setAttribute(ERROR, "ServletException in uploading!");
        } catch (IOException e) {
            request.setAttribute(ERROR, "IOException in uploading!");
        }
    }
}

