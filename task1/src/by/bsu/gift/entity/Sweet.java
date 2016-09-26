package by.bsu.gift.entity;

/**
 * Created by 7 on 18.05.2016.
 */
public abstract class Sweet {
    private String name;
    private double weight;
    private String country;
    private double sugar;

    public Sweet(String name, double weight, String country, double sugar) {
        this.name = name;
        this.weight = weight;
        this.country = country;
        this.sugar = sugar;

    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public String getCountry() {
        return country;
    }

    public double getSugar() {
        return sugar;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setSugar(double sugar) {
        this.sugar = sugar;
    }
}
