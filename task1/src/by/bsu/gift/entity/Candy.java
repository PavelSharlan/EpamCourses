package by.bsu.gift.entity;

/**
 * Created by 7 on 18.05.2016.
 */
public abstract class Candy extends Sweet {
    private String taste;

    public Candy(String name, double weight, String country, double sugar ,String taste) {
        super(name, weight, country, sugar);
        this.taste = taste;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }
}
