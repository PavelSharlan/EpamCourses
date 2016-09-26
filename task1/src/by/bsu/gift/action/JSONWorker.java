package by.bsu.gift.action;

import by.bsu.gift.entity.*;
import by.bsu.gift.exception.IncorrectValueException;
import by.bsu.gift.util.SweetTag;
import by.bsu.gift.valid.Validator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Created by 7 on 18.05.2016.
 */
public class JSONWorker {
    public static JSONArray objectToArray(JSONObject jsonObject) {
        return (JSONArray) jsonObject.get(SweetTag.SWEETS);
    }

    public static Lollipop jsonToLollipop(JSONObject jsonObject) throws IncorrectValueException {
        if (Validator.lollipopJSONValid(jsonObject)) {
            String name = (String) jsonObject.get(SweetTag.NAME);
            double weight = Double.parseDouble((String)jsonObject.get(SweetTag.WEIGHT));
            double sugar = Double.parseDouble((String)jsonObject.get(SweetTag.SUGAR));
            String country = (String) jsonObject.get(SweetTag.COUNTRY);
            String taste = (String) jsonObject.get(SweetTag.TASTE);
            String aromaStr = jsonObject.get(SweetTag.AROMA).toString().toUpperCase();
            Aroma aroma;
            if (Validator.aromaValid(aromaStr)) {
                aroma = Aroma.valueOf(aromaStr);
            } else{
                throw new IncorrectValueException("Incorrect input data!");
            }
            if (Validator.weightValid(weight) && Validator.sugarValid(sugar)) {
                if (name.isEmpty() || country.isEmpty() || taste.isEmpty() || (aroma.toString().isEmpty())) {
                    throw new IncorrectValueException("Incorrect input data!");
                }
                return new Lollipop(name, weight, country, sugar, taste, aroma);
            } else{
                throw new IncorrectValueException("Incorrect input data!");
            }
        }
        else throw new IncorrectValueException("Incorrect input data!");
    }

    public static LollipopAtWand jsonToLollipopAtWand(JSONObject jsonObject) throws IncorrectValueException {
        if (Validator.lollipopAtWandJSONValid(jsonObject)) {
            String name = (String) jsonObject.get(SweetTag.NAME);
            double weight = Double.parseDouble((String) jsonObject.get(SweetTag.WEIGHT));
            double sugar = Double.parseDouble((String)jsonObject.get(SweetTag.SUGAR));
            String country = (String) jsonObject.get(SweetTag.COUNTRY);
            String taste = (String) jsonObject.get(SweetTag.TASTE);
            String aromaStr = jsonObject.get(SweetTag.AROMA).toString().toUpperCase();
            Aroma aroma;
            if (Validator.aromaValid(aromaStr)) {
                aroma = Aroma.valueOf(aromaStr);
            } else{
                throw new IncorrectValueException("Incorrect input data!");
            }
            String form = (String) jsonObject.get(SweetTag.FORM);
            if (Validator.weightValid(weight) && Validator.sugarValid(sugar)) {
                if (name.isEmpty() || country.isEmpty() || taste.isEmpty() || (aroma.toString().isEmpty()) || form.isEmpty()) {
                    throw new IncorrectValueException("Incorrect input data!");
                }
                return new LollipopAtWand(name, weight, country, sugar, taste, aroma, form);
            } else{
                throw new IncorrectValueException("Incorrect input data");
            }

        }
        else throw new IncorrectValueException("Incorrect input data!");
    }

    public static GlazedCandy jsonToGlazedCandy(JSONObject jsonObject) throws IncorrectValueException {
        if (Validator.glazedCandyJSONValid(jsonObject)) {
            String name = (String) jsonObject.get(SweetTag.NAME);
            double weight = Double.parseDouble((String) jsonObject.get(SweetTag.WEIGHT));
            double sugar = Double.parseDouble((String)jsonObject.get(SweetTag.SUGAR));
            String country = (String) jsonObject.get(SweetTag.COUNTRY);
            String taste = (String) jsonObject.get(SweetTag.TASTE);
            String frostingStr = jsonObject.get(SweetTag.FROSTING).toString().toUpperCase();
            Frosting frosting;
            if(Validator.frostingValid(frostingStr)){
                frosting = Frosting.valueOf(frostingStr);
            } else {
                throw new IncorrectValueException("Incorrect input data");
            }
            if (Validator.weightValid(weight) && Validator.sugarValid(sugar)) {
                if (name.isEmpty() || country.isEmpty() || taste.isEmpty() || (frosting.toString().isEmpty())) {
                    throw new IncorrectValueException("Incorrect input data!");
                }
                return new GlazedCandy(name, weight, country, sugar, taste, frosting);
            } else {
                throw new IncorrectValueException("Incorrect input data!");
            }
        }
        else throw new IncorrectValueException("Incorrect input data!");
    }

    public static Wafer jsonToWafer(JSONObject jsonObject) throws IncorrectValueException {
        if (Validator.waferJSONVAlid(jsonObject)) {
            String name = (String) jsonObject.get(SweetTag.NAME);
            double weight = Double.parseDouble((String)jsonObject.get(SweetTag.WEIGHT));
            double sugar = Double.parseDouble((String) jsonObject.get(SweetTag.SUGAR));
            String country = (String) jsonObject.get(SweetTag.COUNTRY);
            String aromaStr = jsonObject.get(SweetTag.AROMA).toString().toUpperCase();
            Aroma aroma;
            if (Validator.aromaValid(aromaStr)) {
                aroma = Aroma.valueOf(aromaStr);
            } else{
                throw new IncorrectValueException("Incorrect input data!");
            }
            if (Validator.weightValid(weight) && Validator.sugarValid(sugar)) {
                if (name.isEmpty() || country.isEmpty() || (aroma.toString().isEmpty())) {
                    throw new IncorrectValueException("Incorrect input data!");
                }
                return new Wafer(name, weight, country, sugar, aroma);
            } else {
                throw new IncorrectValueException("Incorrect input data!");
            }
        }
        else{
            throw new IncorrectValueException("Incorrect input data!");
        }
    }
}
