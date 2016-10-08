package by.bsu.parsing.entity;

/**
 * Created by 7 on 22.06.2016.
 */
public enum CandyEnum {
    CANDIES("candies"),
    LOLLIPOP("lollipop"),
    GLAZED_CANDY("glazed-candy"),
    FROSTING("frosting"),
    AROMA("aroma"),
    PRODUCTION("production"),
    NAME("name"),
    ENERGY("energy"),
    INGREDIENTS("ingredients"),
    SUGAR("sugar"),
    FRUCTOSE("fructose"),
    VANILLIN("vanillin"),
    VALUE("value"),
    PROTEINS("proteins"),
    FATS("fats"),
    CARBOHYDRATES("carbohydrates");
    private String value;

    private CandyEnum(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
