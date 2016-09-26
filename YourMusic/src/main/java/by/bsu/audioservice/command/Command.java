package by.bsu.audioservice.command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by 7 on 19.07.2016.
 */
public interface Command {
    String execute(HttpServletRequest request);
}
