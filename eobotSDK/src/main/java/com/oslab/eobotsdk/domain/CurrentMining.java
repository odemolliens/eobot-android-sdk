package com.oslab.eobotsdk.domain;

import org.json.*;

/**
 * CurrentMining
 * Created by Demolliens Olivier - @odemolliens on 24/09/15.
 * Eobot
 */
public class CurrentMining {
    /**
     * Current mining
     */
    private String mining;


    /**
     * Public constructor
     *
     * @param json json values
     */
    public CurrentMining(JSONObject json) {
        this.mining = json.optString("mining");
    }

    /**
     * Get current mining
     *
     * @return current mining
     */
    public String getMining() {
        return this.mining;
    }

}
