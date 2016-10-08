package by.bsu.parsing.entity;

/**
 * Created by 7 on 21.06.2016.
 */
public abstract class Candy {
    private String name;
    private int energy;
    private Ingredients ingredients;
    private Value value;
    private Production production;

    public Candy(){
        ingredients = new Ingredients();
        value = new Value();
    }

    public Candy(String name, int energy, Ingredients ingredients, Value value, Production production) {
        this.name = name;
        this.energy = energy;
        this.ingredients = ingredients;
        this.value = value;
        this.production = production;
    }

    public String toString() {
        return "Candy{" +
                "name='" + name + '\'' +
                ", energy=" + energy +
                ", ingredients=" + ingredients +
                ", value=" + value +
                ", production=" + production +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getEnergy() {
        return energy;
    }

    public Ingredients getIngredients() {
        return ingredients;
    }

    public Value getValue() {
        return value;
    }

    public Production getProduction() {
        return production;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public void setIngredients(Ingredients ingredients) {
        this.ingredients = ingredients;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public void setProduction(Production production) {
        this.production = production;
    }
}
