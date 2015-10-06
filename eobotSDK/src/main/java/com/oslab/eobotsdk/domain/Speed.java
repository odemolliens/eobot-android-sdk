package com.oslab.eobotsdk.domain;

import org.json.*;

/**
 * Speed
 * Created by Demolliens Olivier - @odemolliens on 24/09/15.
 * Eobot
 */
public class Speed {

    /**
     * Cloud scrypt
     */
    private double cloudScrypt;
    /**
     * Mining SHA 256
     */
    private double miningSHA256;

    /**
     * Cloud SHA 256
     */
    private double cloudSHA256;
    /**
     * Mining scrypt
     */
    private double miningScrypt;
    /**
     * Cloud SHA 256 - 2
     */
    private double cloud2SHA256;

    /**
     * Public constructor
     *
     * @param json json values
     */
    public Speed(JSONObject json) {
        this.cloudScrypt = Double.valueOf(json.optString("CloudScrypt"));
        this.miningSHA256 = Double.valueOf(json.optString("MiningSHA-256"));
        this.cloudSHA256 = Double.valueOf(json.optString("CloudSHA-256"));
        this.miningScrypt = Double.valueOf(json.optString("MiningScrypt"));
        this.cloud2SHA256 = Double.valueOf(json.optString("Cloud2SHA-256"));
    }

    /**
     * Get cloud scrypt
     *
     * @return current cloud scrypt estimation
     */
    public double getCloudScrypt() {
        return this.cloudScrypt;
    }

    /**
     * Get mining SHA 256
     *
     * @return current mining SHA 256 estimation
     */
    public double getMiningSHA256() {
        return this.miningSHA256;
    }

    /**
     * Get cloud SHA 256
     *
     * @return current cloud SHA 256 estimation
     */
    public double getCloudSHA256() {
        return this.cloudSHA256;
    }

    /**
     * Get mining scrypt
     *
     * @return current mining scrypt estimation
     */
    public double getMiningScrypt() {
        return this.miningScrypt;
    }

    /**
     * Get cloud SHA 2 256
     *
     * @return current cloud SHA 256 estimation
     */
    public double getCloud2SHA256() {
        return this.cloud2SHA256;
    }

}
