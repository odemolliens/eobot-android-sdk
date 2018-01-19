package com.oslab.eobotsdk.domain;

import android.content.Context;
import android.support.annotation.NonNull;

import com.oslab.eobotsdk.R;

import org.json.JSONObject;

/**
 * Estimate
 * Created by Demolliens Olivier - @odemolliens on 24/09/15.
 * Eobot
 */
public class Estimate {

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
    public Estimate(JSONObject json) {
        this.cloudScrypt = Double.valueOf(json.optString("CloudScrypt"));
        this.miningSHA256 = Double.valueOf(json.optString("MiningSHA-256"));
        this.cloudSHA256 = Double.valueOf(json.optString("CloudSHA-256"));
        this.miningScrypt = Double.valueOf(json.optString("MiningScrypt"));
        this.cloud2SHA256 = Double.valueOf(json.optString("Cloud2SHA-256"));
    }

    /**
     * Get estimation
     *
     * @param context  current context
     * @param mining   current mining name
     * @param estimate current estimate object
     * @return
     */
    public double getEstimate(@NonNull Context context, @NonNull String mining, @NonNull Estimate estimate) {
        double value = 0;

        if (mining.equals(context.getString(R.string.mining_sha))) {
            value = estimate.getMiningSHA256();
        } else if (mining.equals(context.getString(R.string.mining_scrypt))) {
            value = estimate.getMiningScrypt();
        } else if (mining.equals(context.getString(R.string.mining_cloud_scrypt))) {
            value = estimate.getCloudScrypt();
        } else if (mining.equals(context.getString(R.string.mining_cloud_sha))) {
            value = estimate.getCloudSHA256();
        } else if (mining.equals(context.getString(R.string.mining_cloud_sha2))) {
            value = estimate.getCloud2SHA256();
        }

        return value / 30.5;
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
