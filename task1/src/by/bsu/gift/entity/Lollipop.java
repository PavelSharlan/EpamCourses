package by.bsu.gift.entity;

/**
 * Created by 7 on 18.05.2016.
 */
public class Lollipop extends Candy {
    private Aroma aroma;

    public Lollipop(String name, double weight, String country, double sugar, String taste, Aroma aroma) {
        super(name, weight, country, sugar, taste);
        this.aroma = aroma;
    }

    public Aroma getAroma() {
        return aroma;
    }

    @Override
    public String toString() {
        return "Lollipop{" +
                " name= " + getName() +
                " weight= " + getWeight() +
                " country= " + getCountry() +
                " sugar= " + getSugar() +
                " taste= " + getTaste() +
                " aroma= " + aroma +
                '}';
    }
}
