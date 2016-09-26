package by.bsu.gift.valid;


import by.bsu.gift.entity.Aroma;
import by.bsu.gift.entity.Frosting;
import by.bsu.gift.entity.Sweet;
import by.bsu.gift.util.SweetTag;
import org.json.simple.JSONObject;

/**
 * Created by 7 on 19.05.2016.
 */
public class Validator {

    public static boolean lollipopJSONValid(JSONObject jsonObject){
        return (jsonObject.containsKey(SweetTag.NAME) && jsonObject.containsKey(SweetTag.WEIGHT) &&
                jsonObject.containsKey(SweetTag.COUNTRY) && jsonObject.containsKey(SweetTag.TASTE) &&
                jsonObject.containsKey(SweetTag.AROMA)) && jsonObject.containsKey(SweetTag.SUGAR);
    }

    public static boolean lollipopAtWandJSONValid(JSONObject jsonObject){
        return (jsonObject.containsKey(SweetTag.NAME) && jsonObject.containsKey(SweetTag.WEIGHT) &&
                jsonObject.containsKey(SweetTag.COUNTRY) && jsonObject.containsKey(SweetTag.TASTE) &&
                jsonObject.containsKey(SweetTag.AROMA) && jsonObject.containsKey(SweetTag.FORM)) &&
                jsonObject.containsKey(SweetTag.SUGAR);
    }

    public static boolean glazedCandyJSONValid(JSONObject jsonObject){
        return (jsonObject.containsKey(SweetTag.NAME) && jsonObject.containsKey(SweetTag.WEIGHT) &&
                jsonObject.containsKey(SweetTag.COUNTRY) && jsonObject.containsKey(SweetTag.TASTE) &&
                jsonObject.containsKey(SweetTag.FROSTING)) && jsonObject.containsKey(SweetTag.SUGAR);
    }

    public static boolean waferJSONVAlid(JSONObject jsonObject){
        return (jsonObject.containsKey(SweetTag.NAME) && jsonObject.containsKey(SweetTag.WEIGHT) &&
                jsonObject.containsKey(SweetTag.COUNTRY) && jsonObject.containsKey(SweetTag.AROMA)) &&
                jsonObject.containsKey(SweetTag.SUGAR);
    }

    public static boolean weightValid(double weight){
        return weight > 0;
    }

    public static boolean aromaValid(String str){
        Aroma[] aromas = Aroma.values();
        boolean flag = false;
        for (int i = 0; i < aromas.length; i++){
            if (str.equals(aromas[i].toString())){
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static boolean frostingValid(String str){
        Frosting[] frostingArr = Frosting.values();
        boolean flag = false;
        for (int i = 0; i < frostingArr.length; i++){
            if (str.equals(frostingArr[i].toString())){
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static boolean sugarValid(double sugar){
        return sugar >= 0;
    }
}
