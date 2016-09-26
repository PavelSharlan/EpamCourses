package by.bsu.gift.entity;


/**
 * Created by 7 on 18.05.2016.
 */
public class Wafer extends Sweet {
    private Aroma aroma;

    public Wafer(String name, double weight, String country,double sugar, Aroma aroma) {
        super(name, weight, country, sugar);
        this.aroma = aroma;
    }

    public Aroma getAroma() {
        return aroma;
    }

    @Override
    public String toString() {
        return "Wafer{" +
                " name= " + getName() +
                " weight= " + getName() +
                " country= " + getCountry() +
                " sugar= " + getSugar() +
                "aroma=" + aroma +
                '}';
    }
}
