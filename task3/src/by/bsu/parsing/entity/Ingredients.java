package by.bsu.parsing.entity;

/**
 * Created by 7 on 21.06.2016.
 */
public class Ingredients {
    private int sugar;
    private int fructose;
    private int vanillin;

    public Ingredients(){}

    @Override
    public String toString() {
        return "Ingredients{" +
                "sugar=" + sugar +
                ", fructose=" + fructose +
                ", vanillin=" + vanillin +
                '}';
    }

    public Ingredients(int sugar, int fructose, int vanillin) {
        this.sugar = sugar;
        this.fructose = fructose;
        this.vanillin = vanillin;
    }

    public int getSugar() {
        return sugar;
    }

    public int getFructose() {
        return fructose;
    }

    public int getVanillin() {
        return vanillin;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public void setFructose(int fructose) {
        this.fructose = fructose;
    }

    public void setVanillin(int vanillin) {
        this.vanillin = vanillin;
    }
}
