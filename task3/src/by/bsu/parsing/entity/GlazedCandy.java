package by.bsu.parsing.entity;

/**
 * Created by 7 on 21.06.2016.
 */
public class GlazedCandy extends Candy {
    private Frosting frosting;

    public GlazedCandy(){
        super();
    }

    public GlazedCandy(String name, int energy, Ingredients ingredients, Value value, Production production, Frosting frosting) {
        super(name, energy, ingredients, value, production);
        this.frosting = frosting;
    }

    @Override
    public String toString() {
        return "GlazedCandy{" +
                "name= " + getName()  +
                ", energy= " + getEnergy() +
                ", " + getIngredients().toString() +
                ", " + getValue().toString() +
                ", production= " + getProduction() +
                " frosting= " + frosting +
                '}';
    }

    public Frosting getFrosting() {
        return frosting;
    }

    public void setFrosting(Frosting frosting) {
        this.frosting = frosting;
    }
}
