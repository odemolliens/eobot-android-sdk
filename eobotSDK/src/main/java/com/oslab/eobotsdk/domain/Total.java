package com.oslab.eobotsdk.domain;

import java.util.ArrayList;

/**
 * Total
 * Created by Demolliens Olivier - @odemolliens on 24/09/15.
 * Eobot
 */
public class Total {

    /**
     * Total amount BTC on account
     */
    private double mTotal;
    /**
     * Coin list
     */
    private ArrayList<Coin> mCoinList;

    /**
     * Public constructor
     */
    public Total() {
        mCoinList = new ArrayList<Coin>();
    }

    /**
     * Get current total of the account
     *
     * @return current total
     */
    public double getTotal() {
        return mTotal;
    }

    /**
     * Get coin list, with name and amount, related to the account
     *
     * @return coin list filled
     */
    public ArrayList<Coin> getCoinList() {
        return mCoinList;
    }

    /**
     * Used only to populate the field
     *
     * @param mTotal set current total
     */
    public void setTotal(double mTotal) {
        this.mTotal = mTotal;
    }
}
