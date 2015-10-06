package com.oslab.eobotsdk.domain;

import org.json.JSONObject;

/**
 * Deposit
 * Created by Demolliens Olivier - @odemolliens on 5/09/15.
 * Eobot
 */
public class Deposit {

    /**
     * Address to make deposit
     */
    private String mAddress;
    /**
     * Coin name
     */
    private String mCoinName;


    /**
     * Deposit
     *
     * @param json json values
     * @param name coin name
     */
    public Deposit(JSONObject json, String name) {
        this.mAddress = json.optString(name);
        this.mCoinName = name;

    }

    /**
     * Get address
     *
     * @return current address for a specific coin
     */
    public String getAddress() {
        return mAddress;
    }

    /**
     * Get coin name
     *
     * @return current coin name
     */
    public String getCoinName() {
        return mCoinName;
    }

}
