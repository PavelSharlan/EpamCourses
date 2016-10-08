package by.bsu.parsing.entity;

/**
 * Created by 7 on 21.06.2016.
 */
public class Lollipop extends Candy {
    private Aroma aroma;

    public Lollipop(){
        super();
    }

    public Lollipop(String name, int energy, Ingredients ingredients, Value value, Production production, Aroma aroma) {
        super(name, energy, ingredients, value, production);
        this.aroma = aroma;
    }

    @Override
    public String toString() {
            return "Lollipop{" +
                    "name= '" + getName()  +
                    ", energy= " + getEnergy() +
                    ", " + getIngredients().toString() +
                    ", " + getValue().toString() +
                    ", production= " + getProduction() +
                    ", aroma= " + aroma +
                    '}';
    }

    public Aroma getAroma() {
        return aroma;
    }

    public void setAroma(Aroma aroma) {
        this.aroma = aroma;
    }
}
