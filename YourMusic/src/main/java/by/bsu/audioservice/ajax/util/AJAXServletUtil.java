package by.bsu.audioservice.ajax.util;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by 7 on 02.09.2016.
 */
public class AJAXServletUtil {
    public static final String APPLICATION_JSON = "application/json";

    public static final String UTF_8 = "UTF-8";

    public static String getRequestBody(HttpServletRequest request) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        try (BufferedReader reader = request.getReader()) {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        }
        return sb.toString();
    }
}
