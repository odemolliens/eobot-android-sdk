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

    /**
     * Find specific coin in getCoinList()
     *
     * @param toFindCoinName coin name
     * @return coin with data can be null
     */
    public void findCoin(String toFindCoinName) {
        findCoin(new Coin(0, toFindCoinName));
    }

    /**
     * Find specific coin in getCoinList()
     *
     * @param toFindCoin coin name
     * @return coin with data can be null
     */
    public Coin findCoin(Coin toFindCoin) {
        ArrayList<Coin> coinArrayList = getCoinList();
        int coinListSize = coinArrayList.size();

        Coin coin = null;

        for (int i = 0; i < coinListSize; i++) {
            Coin aCoin = coinArrayList.get(i);
            if (aCoin.getName().trim().equals(toFindCoin.getName().trim())) {
                coin = aCoin;
                break;
            }
        }

        return coin;
    }
}
