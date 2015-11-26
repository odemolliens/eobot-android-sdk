package com.oslab.eobotsdk.domain;

import android.support.v4.util.Pair;

import org.json.JSONObject;

/**
 * Coin
 * Created by Demolliens Olivier - @odemolliens on 24/09/15.
 * Eobot
 */
public class Coin {

    public static final String[] S_COINNAME_ARRAY = {CoinName.USD.name, CoinName.EUR.name, CoinName.JPY.name, CoinName.GBP.name,
            CoinName.CNY.name, CoinName.CAD.name, CoinName.AUD.name, CoinName.MXN.name, CoinName.CZK.name,
            CoinName.BTC.name, CoinName.LTC.name, CoinName.DOGE.name};

    public enum CoinName {

        USD("USD"),
        EUR("EUR"),
        JPY("JPY"),
        GBP("GBP"),
        CNY("CNY"),
        CAD("CAD"),
        AUD("AUD"),
        MXN("MXN"),
        CZK("CZK"),
        BTC("BTC"),
        LTC("LTC"),
        DOGE("DOGE");

        private String name;

        private CoinName(String s) {
            name = s;
        }
    }

    /**
     * Coin name
     */
    private String name;
    /**
     * Coin small image
     */
    private String image;

    /**
     * Coin big image
     */
    private String bigImage;

    /**
     * Current price of the coin
     */
    private double price;

    /**
     * Public constructor - ONLY FOR TESTING
     *
     * @param name     coin name
     * @param image    small image url
     * @param bigImage big image url
     * @param price    current price of coin
     */
    public Coin(String name, String image, String bigImage, double price) {
        this.name = name;
        this.image = image;
        this.bigImage = bigImage;
        this.price = price;
    }


    /**
     * Public constructor - ONLY FOR TOTAL OBJECT
     *
     * @param price current price of coin
     * @param name  coin name
     */
    public Coin(double price, String name) {
        this.price = price;
        this.name = name;
    }

    /**
     * Public constructor
     *
     * @param json current json values
     * @param name coin name
     */
    public Coin(JSONObject json, String name) {

        try {

            //coinprice service
            double coinPrice = Double.valueOf(json.optString(name));
            this.price = coinPrice;
            this.name = name;

        } catch (NumberFormatException e) {

            this.image = json.optString("Image");
            this.bigImage = json.optString("BigImage");
            this.price = json.optDouble("Price");
            this.name = name;

        }
    }

    /**
     * Get deposit rules (minimun amount)
     *
     * @return filled pair with coin name and minimun deposit amount
     */
    public Pair<String, String> getDepositRules() {

        String coinName = null;
        String minimunDepositValue = null;

        //TODO: fix when rules are on server
        if (this.getName().equals(Coin.CoinName.BTC.name())) {
            coinName = Coin.CoinName.BTC.name();
            minimunDepositValue = "0.001";
        } else if (this.getName().equals(CoinName.LTC.name()) || this.getName().equals("DASH")) {
            coinName = this.getName();
            minimunDepositValue = "0.2";
        } else if (this.getName().equals("NMC") || this.getName().equals("CURE") || this.getName().equals("XCP") || this.getName().equals("PPC") || this.getName().equals("ETH")) {
            coinName = this.getName();
            minimunDepositValue = "1.0";
        } else if (this.getName().equals("BLK") || this.getName().equals("XRP") || this.getName().equals("XMR") || this.getName().equals("NXT")) {
            coinName = this.getName();
            minimunDepositValue = "10";
        } else if (this.getName().equals(CoinName.DOGE.name()) || this.getName().equals("SJCX") || this.getName().equals("XLM") || this.getName().equals("MAID") || this.getName().equals("GRC")) {
            coinName = this.getName();
            minimunDepositValue = "100";
        } else if (this.getName().equals("BCN") || this.getName().equals("BTS")) {
            coinName = this.getName();
            minimunDepositValue = "1000";
        } else if (this.getName().equals("RDD")) {
            coinName = this.getName();
            minimunDepositValue = "10000";
        }

        return new Pair<String, String>(coinName, minimunDepositValue);
    }

    /**
     * Get image url
     *
     * @return image url
     */
    public String getImage() {
        return this.image;
    }

    /**
     * Get big image url
     *
     * @return big image url
     */
    public String getBigImage() {
        return this.bigImage;
    }

    /**
     * Get price
     *
     * @return get current price
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Get coin name
     *
     * @return coin name
     */
    public String getName() {
        return name;
    }


}
