package by.bsu.gift.entity;

import java.util.ArrayList;

/**
 * Created by 7 on 22.05.2016.
 */
public class Gift {
    private ArrayList<Sweet> sweets;

    public Gift(ArrayList<Sweet> gift) {
        this.sweets = gift;
    }

    public Gift() { sweets = new ArrayList<>(); }

    public ArrayList<Sweet> getSweets() {
        return new ArrayList<Sweet>(sweets);
    }

    public void setSweets(ArrayList<Sweet> sweets) {
        this.sweets = sweets;
    }

    public double countWeight(){
        double sumWeight = 0;
        for (Sweet sweet: sweets){
            sumWeight += sweet.getWeight();
        }
        return sumWeight;
    }

    @Override
    public String toString() {
        return "Gift=" + sweets +
                '}';
    }
}
