package by.bsu.parsing.entity;

/**
 * Created by 7 on 21.06.2016.
 */
public class Value {
    private int proteins;
    private int fats;
    private int carbohydrates;

    public Value() {
    }

    public Value(int proteins, int fats, int carbohydrates) {
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
    }

    @Override
    public String toString() {
        return "Value{" +
                "carbohydrates=" + carbohydrates +
                ", fats=" + fats +
                ", proteins=" + proteins +
                '}';
    }

    public int getProteins() {
        return proteins;
    }

    public int getFats() {
        return fats;
    }

    public int getCarbohydrates() {
        return carbohydrates;
    }

    public void setProteins(int proteins) {
        this.proteins = proteins;
    }

    public void setFats(int fats) {
        this.fats = fats;
    }

    public void setCarbohydrates(int carbohydrates) {
        this.carbohydrates = carbohydrates;
    }
}
