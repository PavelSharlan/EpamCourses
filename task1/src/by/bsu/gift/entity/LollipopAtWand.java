package by.bsu.gift.entity;

/**
 * Created by 7 on 18.05.2016.
 */
public class LollipopAtWand extends Lollipop {
    private String form;

    public LollipopAtWand(String name, double weight, String country, double sugar, String taste, Aroma aroma,  String form) {
        super(name, weight, country, sugar, taste, aroma);
        this.form = form;
    }

    public String getForm() {
        return form;
    }

    @Override
    public String toString() {
        return "LollipopAtWand{" +
                " name= " + getName() +
                " weight= " + getWeight() +
                " country= " + getCountry() +
                " sugar= " + getSugar() +
                " aroma= " + getAroma() +
                " taste= " + getTaste() +
                "form='" + form + '\'' +
                '}';
    }
}
