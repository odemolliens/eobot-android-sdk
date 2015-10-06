package com.oslab.eobotsdk.domain;

import org.json.*;

/**
 * Exchange Estimation
 * Created by Demolliens Olivier - @odemolliens on 24/09/15.
 * Eobot
 */
public class ExchangeEstimation {

    private double result;

    public ExchangeEstimation() {

    }

    public ExchangeEstimation(JSONObject json) {
        this.result = json.optDouble("Result");
    }

    public double getResult() {
        return this.result;
    }

    public void setResult(double result) {
        this.result = result;
    }


}
