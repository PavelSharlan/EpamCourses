package by.bsu.parsing.builder;

import by.bsu.parsing.entity.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Created by 7 on 22.06.2016.
 */
public class CandiesDOMBuilder {
    private static final Logger LOGGER = LogManager.getLogger(CandiesDOMBuilder.class);

    private ArrayList<Lollipop> lollipops;
    private ArrayList<GlazedCandy> glazedCandies;
    private DocumentBuilder docBuilder;

    public ArrayList<Lollipop> getLollipops() {
        return new ArrayList<Lollipop>(lollipops);
    }
    public ArrayList<GlazedCandy> getGlazedCandies() { return new ArrayList<GlazedCandy>(glazedCandies); }

    public CandiesDOMBuilder(){
        this.lollipops = new ArrayList<Lollipop>();
        this.glazedCandies = new ArrayList<GlazedCandy>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try{
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            LOGGER.error("ParserConfigurationException!", e);
        }
    }

    public void buildLollipopList(String fileName){
        Document doc = null;
        try{
            doc = docBuilder.parse(fileName);
            Element root = doc.getDocumentElement();
            NodeList lollipopList = root.getElementsByTagName(CandyEnum.LOLLIPOP.getValue());
            for (int i = 0; i < lollipopList.getLength(); i++){
                Element lollipopElement = (Element) lollipopList.item(i);
                Lollipop lollipop = buildLollipop(lollipopElement);
                lollipops.add(lollipop);
            }
        } catch (SAXException e) {
            LOGGER.error("SAXException!", e);
        } catch (IOException e) {
            LOGGER.error("IOException!", e);
        }
    }

    private Lollipop buildLollipop(Element lollipopElement){
        String productionStr = lollipopElement.getAttribute(CandyEnum.PRODUCTION.getValue()).toUpperCase();
        if (productionStr.isEmpty()){
            productionStr = "BLR";
        }
        Production production;
        production = Production.valueOf(productionStr);
        String aromaStr = lollipopElement.getAttribute(CandyEnum.AROMA.getValue()).toUpperCase();
        if (aromaStr.isEmpty()){
            aromaStr = "COLA";
        }
        Aroma aroma;
        aroma = Aroma.valueOf(aromaStr);
        String name = getElementTextContent(lollipopElement, CandyEnum.NAME.getValue());
        int energy = Integer.parseInt(getElementTextContent(lollipopElement, CandyEnum.ENERGY.getValue()));
        Element ingredientsElement = (Element) lollipopElement.getElementsByTagName(CandyEnum.INGREDIENTS.getValue()).item(0);
        int sugar = Integer.parseInt(getElementTextContent(ingredientsElement, CandyEnum.SUGAR.getValue()));
        int fructose = Integer.parseInt(getElementTextContent(ingredientsElement, CandyEnum.FRUCTOSE.getValue()));
        int vanillin = Integer.parseInt(getElementTextContent(ingredientsElement, CandyEnum.VANILLIN.getValue()));
        Ingredients ingredients = new Ingredients(sugar, fructose, vanillin);
        Element valueElement = (Element) lollipopElement.getElementsByTagName(CandyEnum.VALUE.getValue()).item(0);
        int proteins = Integer.parseInt(getElementTextContent(valueElement, CandyEnum.PROTEINS.getValue()));
        int fats = Integer.parseInt(getElementTextContent(valueElement, CandyEnum.FATS.getValue()));
        int carbohydrates = Integer.parseInt(getElementTextContent(valueElement, CandyEnum.CARBOHYDRATES.getValue()));
        Value value = new Value(proteins, fats, carbohydrates);
        Lollipop lollipop = new Lollipop(name, energy, ingredients,value, production, aroma);
        return lollipop;
    }

    public void buildGlazedCandiesList(String fileName){
        Document doc = null;
        try{
            doc = docBuilder.parse(fileName);
            Element root = doc.getDocumentElement();
            NodeList glazedCandyList = root.getElementsByTagName(CandyEnum.GLAZED_CANDY.getValue());
            for (int i = 0; i < glazedCandyList.getLength(); i++){
                Element glazedCandyElement = (Element) glazedCandyList.item(i);
                GlazedCandy glazedCandy = buildGlazedCandy(glazedCandyElement);
                glazedCandies.add(glazedCandy);
            }
        } catch (SAXException e) {
            LOGGER.error("SAXException!", e);
        } catch (IOException e) {
            LOGGER.error("IOException!", e);
        }
    }

    private GlazedCandy buildGlazedCandy(Element glazedCandyElement){
        String productionStr = glazedCandyElement.getAttribute(CandyEnum.PRODUCTION.getValue()).toUpperCase();
        if (productionStr == null){
            productionStr = "BLR";
        }
        Production production;
        production = Production.valueOf(productionStr);
        String frostingStr = glazedCandyElement.getAttribute(CandyEnum.FROSTING.getValue()).toUpperCase();
        if (frostingStr == null){
            frostingStr = "MILK";
        }
        Frosting frosting;
        frosting = Frosting.valueOf(frostingStr);
        String name = getElementTextContent(glazedCandyElement, CandyEnum.NAME.getValue());
        int energy = Integer.parseInt(getElementTextContent(glazedCandyElement, CandyEnum.ENERGY.getValue()));
        Element ingredientsElement = (Element) glazedCandyElement.getElementsByTagName(CandyEnum.INGREDIENTS.getValue()).item(0);
        int sugar = Integer.parseInt(getElementTextContent(ingredientsElement, CandyEnum.SUGAR.getValue()));
        int fructose = Integer.parseInt(getElementTextContent(ingredientsElement, CandyEnum.FRUCTOSE.getValue()));
        int vanillin = Integer.parseInt(getElementTextContent(ingredientsElement, CandyEnum.VANILLIN.getValue()));
        Ingredients ingredients = new Ingredients(sugar, fructose, vanillin);
        Element valueElement = (Element) glazedCandyElement.getElementsByTagName(CandyEnum.VALUE.getValue()).item(0);
        int proteins = Integer.parseInt(getElementTextContent(valueElement, CandyEnum.PROTEINS.getValue()));
        int fats = Integer.parseInt(getElementTextContent(valueElement, CandyEnum.FATS.getValue()));
        int carbohydrates = Integer.parseInt(getElementTextContent(valueElement, CandyEnum.CARBOHYDRATES.getValue()));
        Value value = new Value(proteins, fats, carbohydrates);
        GlazedCandy glazedCandy = new GlazedCandy(name, energy, ingredients,value, production, frosting);
        return glazedCandy;
    }

    private static String getElementTextContent(Element element, String elementName){
        NodeList nodeList = element.getElementsByTagName(elementName);
        Node node = nodeList.item(0);
        return node.getTextContent();
    }
}
