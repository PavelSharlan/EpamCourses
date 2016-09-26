package by.bsu.gift.entity;

/**
 * Created by 7 on 18.05.2016.
 */
public class GlazedCandy extends Candy {
    private Frosting frosting;

    public GlazedCandy(String name, double weight, String country, double sugar, String taste, Frosting frosting) {
        super(name, weight, country, sugar, taste);
        this.frosting = frosting;
    }

    public Frosting getFrosting() {
        return frosting;
    }

    @Override
    public String toString() {
        return "GlazedCandy{" + " name= " + getName() +
                " weight= " + getWeight() +
                " country= " + getCountry() +
                " sugar= " + getSugar() +
                " taste= " + getTaste() +
                " frosting= " + frosting +
                '}';
    }
}
