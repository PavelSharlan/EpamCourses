package by.bsu.audioservice.entity;

import java.util.ArrayList;

/**
 * Class Basket
 *
 * Created by 7 on 07.09.2016.
 */
public class Basket {
    /** Field accountId */
    private Long accountId;

    /** Field purchases */
    private ArrayList<Purchase> purchases;

    /**
     * Instantiates a new Basket.
     *
     * @param userId    the user id
     * @param purchases the purchases
     */
    public Basket(Long userId, ArrayList<Purchase> purchases) {
        this.accountId = userId;
        this.purchases = purchases;
    }

    /**
     * Gets account id.
     *
     * @return the account id
     */
    public Long getAccountId() {
        return accountId;
    }

    /**
     * Gets purchases.
     *
     * @return the purchases
     */
    public ArrayList<Purchase> getPurchases() {
        return purchases;
    }

    @Override
    public String toString() {
        return "{\"accountId\":\"" + getAccountId() + "\", \"purchases\":\"" + purchases + "\"}";
    }
}
