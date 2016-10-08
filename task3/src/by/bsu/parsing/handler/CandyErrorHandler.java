package by.bsu.parsing.handler;

import jdk.internal.org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * Created by 7 on 21.06.2016.
 */
public class CandyErrorHandler extends DefaultHandler {
    private static final Logger LOGGER = LogManager.getLogger(CandyErrorHandler.class);

    public void warning(SAXParseException e){
        LOGGER.warn(getLineAddress(e) + "-" + e.getMessage());
    }

    public void error(SAXParseException e){
        LOGGER.error(getLineAddress(e) + "-" + e.getMessage());
    }

    public void fatalError(SAXParseException e){
        LOGGER.fatal(getLineAddress(e) + "-" + e.getMessage());
    }

    private String getLineAddress(SAXParseException e){
        return e.getLineNumber() + " : " +e.getColumnNumber();
    }
}
