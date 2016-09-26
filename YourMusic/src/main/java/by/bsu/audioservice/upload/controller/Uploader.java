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
 * Created by 7 on 30.08.2016.
 */
@WebServlet("/uploader")
@MultipartConfig
public class Uploader extends HttpServlet {
    private static final String ERROR = "error";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response){
        LoadAudioCommand command = new LoadAudioCommand();
        command.execute(request);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(ConfigurationManager.getInstance().getProperty(ConfigurationManager.ADMIN_CABINET_PAGE_PATH));
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            request.getSession().setAttribute(ERROR, "ServletException in uploading!");
        } catch (IOException e) {
            request.getSession().setAttribute(ERROR, "IOException in uploading!");
        }
    }
}

