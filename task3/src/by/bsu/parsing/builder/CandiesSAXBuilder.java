package by.bsu.parsing.builder;

import by.bsu.parsing.entity.GlazedCandy;
import by.bsu.parsing.entity.Lollipop;
import by.bsu.parsing.handler.CandyHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by 7 on 22.06.2016.
 */
public class CandiesSAXBuilder {
    private static final Logger LOGGER = LogManager.getLogger(CandiesSAXBuilder.class);

    private XMLReader reader;
    private CandyHandler ch;

    public CandiesSAXBuilder(){
        ch = new CandyHandler();
        try{
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(ch);
        } catch (SAXException e) {
            LOGGER.error("SAXException!", e);
        }
    }

    public void buildListsCandies(String fileName){
        try{
            reader.parse(fileName);
        } catch (SAXException e) {
            LOGGER.error("SAXException!", e);
        } catch (IOException e) {
            LOGGER.error("IOException!", e);
        }
        ArrayList<Lollipop> lollipops = ch.getLollipops();
        ArrayList<GlazedCandy> glazedCandies = ch.getGlazedCandies();
    }

}
