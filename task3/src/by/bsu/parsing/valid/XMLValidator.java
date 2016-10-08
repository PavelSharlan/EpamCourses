package by.bsu.parsing.valid;

import by.bsu.parsing.handler.CandyErrorHandler;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * Created by 7 on 21.06.2016.
 */
public class XMLValidator {
    private static final Logger LOGGER = LogManager.getLogger(XMLValidator.class);

    public static void validate(String fileName, String schemaName){
        Schema schema = null;
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        try{
            schema = factory.newSchema(new File(schemaName));
            SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setSchema(schema);
            SAXParser parser = spf.newSAXParser();
            parser.parse(fileName, new CandyErrorHandler());
            LOGGER.info("XML document is valid!");
        } catch (SAXException e) {
            LOGGER.error("SAXException", e);
        } catch (ParserConfigurationException e) {
            LOGGER.error("ParserConfigurationException", e);
        } catch (IOException e) {
            LOGGER.error("IOException", e);
        }
    }
}
