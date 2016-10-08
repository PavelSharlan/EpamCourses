package by.bsu.audioservice.ajax.command.impl;

import by.bsu.audioservice.ajax.command.Command;
import by.bsu.audioservice.ajax.logic.DeletePurchaseFromBasketLogic;
import by.bsu.audioservice.exception.TechnicalException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Class DeletePurchaseFromBasketCommand
 *
 * Created by 7 on 09.09.2016.
 */
public class DeletePurchaseFromBasketCommand implements Command {
    /** Field LOGGER */
    private static final Logger LOGGER = LogManager.getLogger(DeletePurchaseFromBasketCommand.class);

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
        LOGGER.info("Delete purchase from basket");
        PrintWriter out = response.getWriter();
        JSONObject object = new JSONObject();
        try{
            DeletePurchaseFromBasketLogic.delete(requestData);
            out.println(object);
            response.setStatus(HttpServletResponse.SC_OK);
        } catch (TechnicalException e) {
            LOGGER.error("Something was wrong", e);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        } finally {
            out.flush();
            out.close();
        }
    }
}
