package by.bsu.parsing.builder;

import by.bsu.parsing.entity.*;
import com.sun.xml.internal.fastinfoset.tools.FI_SAX_Or_XML_SAX_DOM_SAX_SAXEvent;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * Created by 7 on 22.06.2016.
 */
public class CandiesStAXBuilder {
    private static final Logger LOGGER = LogManager.getLogger(CandiesStAXBuilder.class);
    private ArrayList<Lollipop> lollipops;
    private ArrayList<GlazedCandy> glazedCandies;
    private XMLInputFactory inputFactory;

    public CandiesStAXBuilder(){
        inputFactory = XMLInputFactory.newFactory();
        glazedCandies = new ArrayList<GlazedCandy>();
        lollipops = new ArrayList<Lollipop>();
    }

    public ArrayList<Lollipop> getLollipops() {
        return new ArrayList<Lollipop>(lollipops);
    }

    public ArrayList<GlazedCandy> getGlazedCandies() {
        return new ArrayList<GlazedCandy>(glazedCandies);
    }

    public void buildListsCandies(String fileName){
        FileInputStream inputStream = null;
        XMLStreamReader reader = null;
        String name;
        try{
            inputStream = new FileInputStream(new File(fileName));
            reader = inputFactory.createXMLStreamReader(inputStream);
            while(reader.hasNext()){
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT){
                    name = reader.getLocalName();
                    if (CandyEnum.valueOf(name.toUpperCase().replace("-", "_")) == CandyEnum.LOLLIPOP){
                        Lollipop lollipop = buildLollipop(reader);
                        lollipops.add(lollipop);
                    } else if(CandyEnum.valueOf(name.toUpperCase().replace("-", "_")) == CandyEnum.GLAZED_CANDY){
                        GlazedCandy glazedCandy = buildGlazedCandy(reader);
                        glazedCandies.add(glazedCandy);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            LOGGER.error("File: " + fileName + " not found!", e);
        } catch (XMLStreamException e) {
            LOGGER.error("XMLStreamException", e);
        } finally {
            try {
                if (inputStream != null){
                    inputStream.close();
                }
            } catch (IOException e) {
                LOGGER.error("Impossible to close test.by.bsu.file " + fileName, e);
            }
        }
    }

    private Lollipop buildLollipop(XMLStreamReader reader) throws XMLStreamException {
        Lollipop lollipop = new Lollipop();
        Production production = Production.valueOf(reader.getAttributeValue(null, CandyEnum.PRODUCTION.getValue()).toUpperCase());
        if (production == null){
            production = Production.BLR;
        }
        lollipop.setProduction(production);
        Aroma aroma = Aroma.valueOf(reader.getAttributeValue(null, CandyEnum.AROMA.getValue()).toUpperCase());
        if (aroma == null){
            aroma = Aroma.COLA;
        }
        lollipop.setAroma(aroma);
        String name;
        while (reader.hasNext()){
            int type = reader.next();
            switch (type){
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch(CandyEnum.valueOf(name.toUpperCase().replace("-", "_"))){
                        case NAME:
                            lollipop.setName(getXMLText(reader));
                            break;
                        case ENERGY:
                            lollipop.setEnergy(Integer.parseInt(getXMLText(reader)));
                            break;
                        case INGREDIENTS:
                            lollipop.setIngredients(getXMLIngredients(reader));
                            break;
                        case VALUE:
                            lollipop.setValue(getXMLValue(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (CandyEnum.valueOf(name.toUpperCase().replace("-", "_")) == CandyEnum.LOLLIPOP){
                        return lollipop;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Lollipop");
    }

    private GlazedCandy buildGlazedCandy(XMLStreamReader reader) throws XMLStreamException {
        GlazedCandy glazedCandy = new GlazedCandy();
        Production production = Production.valueOf(reader.getAttributeValue(null, CandyEnum.PRODUCTION.getValue()).toUpperCase());
        if (production == null){
            production = Production.BLR;
        }
        glazedCandy.setProduction(production);
        Frosting frosting = Frosting.valueOf(reader.getAttributeValue(null, CandyEnum.FROSTING.getValue()).toUpperCase());
        if (frosting == null){
            frosting = Frosting.MILK;
        }
        glazedCandy.setFrosting(frosting);
        String name;
        while (reader.hasNext()){
            int type = reader.next();
            switch (type){
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch(CandyEnum.valueOf(name.toUpperCase().replace("-", "_"))){
                        case NAME:
                            glazedCandy.setName(getXMLText(reader));
                            break;
                        case ENERGY:
                            glazedCandy.setEnergy(Integer.parseInt(getXMLText(reader)));
                            break;
                        case INGREDIENTS:
                            glazedCandy.setIngredients(getXMLIngredients(reader));
                            break;
                        case VALUE:
                            glazedCandy.setValue(getXMLValue(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (CandyEnum.valueOf(name.toUpperCase().replace("-", "_")) == CandyEnum.GLAZED_CANDY){
                        return glazedCandy;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag GlazedCandy");
    }

    private Ingredients getXMLIngredients(XMLStreamReader reader) throws XMLStreamException {
        Ingredients ingredients = new Ingredients();
        int type;
        String name;
        while(reader.hasNext()){
            type = reader.next();
            switch (type){
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (CandyEnum.valueOf(name.toUpperCase().replace("-", "_"))){
                        case SUGAR:
                            ingredients.setSugar(Integer.parseInt(getXMLText(reader)));
                            break;
                        case FRUCTOSE:
                            ingredients.setFructose(Integer.parseInt(getXMLText(reader)));
                            break;
                        case VANILLIN:
                            ingredients.setVanillin(Integer.parseInt(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (CandyEnum.valueOf(name.toUpperCase().replace("-", "_")) == CandyEnum.INGREDIENTS){
                        return ingredients;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Ingredients");
    }

    private Value getXMLValue(XMLStreamReader reader) throws XMLStreamException {
        Value value = new Value();
        int type;
        String name;
        while(reader.hasNext()){
            type = reader.next();
            switch (type){
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (CandyEnum.valueOf(name.toUpperCase().replace("-", "_"))){
                        case PROTEINS:
                            value.setProteins(Integer.parseInt(getXMLText(reader)));
                            break;
                        case FATS:
                            value.setFats(Integer.parseInt(getXMLText(reader)));
                            break;
                        case CARBOHYDRATES:
                            value.setCarbohydrates(Integer.parseInt(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (CandyEnum.valueOf(name.toUpperCase().replace("-", "_")) == CandyEnum.VALUE){
                        return value;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Value");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}
