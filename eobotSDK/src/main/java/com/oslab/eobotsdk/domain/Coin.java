package com.oslab.eobotsdk.domain;

import org.json.*;

/**
 * Coin
 * Created by Demolliens Olivier - @odemolliens on 24/09/15.
 * Eobot
 */
public class Coin {

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

        this.image = json.optString("Image");
        this.bigImage = json.optString("BigImage");
        this.price = json.optDouble("Price");
        this.name = name;

    }

    /**
     * Get image url
     * @return image url
     */
    public String getImage() {
        return this.image;
    }

    /**
     * Get big image url
     * @return big image url
     */
    public String getBigImage() {
        return this.bigImage;
    }

    /**
     * Get price
     * @return get current price
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Get coin name
     * @return coin name
     */
    public String getName() {
        return name;
    }


}
