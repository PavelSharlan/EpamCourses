package by.bsu.parsing.handler;

import by.bsu.parsing.entity.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.EnumSet;

/**
 * Created by 7 on 22.06.2016.
 */
public class CandyHandler extends DefaultHandler {

    private ArrayList<Lollipop> lollipops;
    private ArrayList<GlazedCandy> glazedCandies;
    private Lollipop currentLollipop;
    private GlazedCandy currentGlazedCandy;
    private CandyEnum currentEnum;
    private CandyEnum currentCandy;
    private EnumSet<CandyEnum> withText;

    public ArrayList<Lollipop> getLollipops(){
        return lollipops;
    }

    public ArrayList<GlazedCandy> getGlazedCandies(){
        return glazedCandies;
    }

    public CandyHandler(){
        lollipops = new ArrayList<Lollipop>();
        glazedCandies = new ArrayList<GlazedCandy>();
        withText = EnumSet.range(CandyEnum.GLAZED_CANDY, CandyEnum.CARBOHYDRATES);
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        CandyEnum temp = CandyEnum.valueOf(localName.toUpperCase().replace("-", "_"));
        switch(temp){
            case LOLLIPOP:
                currentCandy = CandyEnum.LOLLIPOP;
                currentLollipop = new Lollipop();
                String strProductionLollipop = attributes.getValue(0);
                if(strProductionLollipop != null){
                    currentLollipop.setProduction(Production.valueOf(strProductionLollipop.toUpperCase()));
                } else {
                    currentLollipop.setProduction(Production.BLR);
                }
                String strAroma = attributes.getValue(1);
                if(strAroma != null){
                    currentLollipop.setAroma(Aroma.valueOf(strAroma.toUpperCase()));
                } else{
                    currentLollipop.setAroma(Aroma.COLA);
                }
                break;
            case GLAZED_CANDY:
                currentCandy = CandyEnum.GLAZED_CANDY;
                currentGlazedCandy = new GlazedCandy();
                String strProductionGlazedCandy = attributes.getValue(0);
                if (strProductionGlazedCandy != null){
                    currentGlazedCandy.setProduction(Production.valueOf(strProductionGlazedCandy.toUpperCase()));
                } else{
                    currentGlazedCandy.setProduction(Production.BLR);
                }
                String strFrosting = attributes.getValue(1);
                if(strFrosting != null){
                    currentGlazedCandy.setFrosting(Frosting.valueOf(strFrosting.toUpperCase()));
                } else{
                    currentGlazedCandy.setFrosting(Frosting.MILK);
                }
                break;
            default:
                temp = CandyEnum.valueOf(localName.toUpperCase().replace("-","_"));
                if (withText.contains(temp)){
                    currentEnum = temp;
                }
                break;
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        CandyEnum temp = CandyEnum.valueOf(localName.toUpperCase().replace("-","_"));
        switch(temp) {
            case LOLLIPOP:
                lollipops.add(currentLollipop);
                break;
            case GLAZED_CANDY:
                glazedCandies.add(currentGlazedCandy);
                break;
            default:
                break;
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        String s = new String(ch, start, length).trim();
        if (currentEnum != null){
            switch(currentCandy) {
                case LOLLIPOP:
                    switch (currentEnum){
                        case NAME:
                            currentLollipop.setName(s);
                            break;
                        case ENERGY:
                            currentLollipop.setEnergy(Integer.parseInt(s));
                            break;
                        case SUGAR:
                            currentLollipop.getIngredients().setSugar(Integer.parseInt(s));
                            break;
                        case FRUCTOSE:
                            currentLollipop.getIngredients().setFructose(Integer.parseInt(s));
                            break;
                        case VANILLIN:
                            currentLollipop.getIngredients().setVanillin(Integer.parseInt(s));
                            break;
                        case PROTEINS:
                            currentLollipop.getValue().setProteins(Integer.parseInt(s));
                            break;
                        case FATS:
                            currentLollipop.getValue().setFats(Integer.parseInt(s));
                            break;
                        case CARBOHYDRATES:
                            currentLollipop.getValue().setCarbohydrates(Integer.parseInt(s));
                            break;
                        default:
                            break;
                    }
                    break;
                case GLAZED_CANDY:
                    switch (currentEnum){
                        case NAME:
                            currentGlazedCandy.setName(s);
                            break;
                        case ENERGY:
                            currentGlazedCandy.setEnergy(Integer.parseInt(s));
                            break;
                        case SUGAR:
                            currentGlazedCandy.getIngredients().setSugar(Integer.parseInt(s));
                            break;
                        case FRUCTOSE:
                            currentGlazedCandy.getIngredients().setFructose(Integer.parseInt(s));
                            break;
                        case VANILLIN:
                            currentGlazedCandy.getIngredients().setVanillin(Integer.parseInt(s));
                            break;
                        case PROTEINS:
                            currentGlazedCandy.getValue().setProteins(Integer.parseInt(s));
                            break;
                        case FATS:
                            currentGlazedCandy.getValue().setFats(Integer.parseInt(s));
                            break;
                        case CARBOHYDRATES:
                            currentGlazedCandy.getValue().setCarbohydrates(Integer.parseInt(s));
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }
        }
        currentEnum = null;
    }
}
