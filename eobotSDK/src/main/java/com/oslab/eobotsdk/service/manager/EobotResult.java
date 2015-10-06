package com.oslab.eobotsdk.service.manager;

import org.json.JSONObject;

/**
 * TODO
 * Created by Demolliens Olivier - @odemolliens on 24/09/15.
 * Eobot
 */
public class EobotResult {

    private int mResultCode;
    private String mResult;
    private JSONObject mObject;

    public EobotResult(int resultCode, String result) {
        this.mResultCode = resultCode;
        this.mResult = result;
    }

    public int getResultCode() {
        return mResultCode;
    }

    public String getResult() {
        return mResult;
    }
}
