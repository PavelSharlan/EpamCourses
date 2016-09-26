package by.bsu.audioservice.entity;

import java.util.ArrayList;

/**
 * Created by 7 on 07.09.2016.
 */
public class Basket {
    private Long accountId;
    private ArrayList<Purchase> purchases;

    public Basket(Long userId, ArrayList<Purchase> purchases) {
        this.accountId = userId;
        this.purchases = purchases;
    }

    public Long getAccountId() {
        return accountId;
    }

    public ArrayList<Purchase> getPurchases() {
        return purchases;
    }

    @Override
    public String toString() {
        return "{\"accountId\":\"" + getAccountId() + "\", \"purchases\":\"" + purchases + "\"}";
    }
}
