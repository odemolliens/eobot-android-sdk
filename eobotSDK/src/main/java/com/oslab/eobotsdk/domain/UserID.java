package com.oslab.eobotsdk.domain;

import org.json.*;

/**
 * UserID
 * Created by Demolliens Olivier - @odemolliens on 24/09/15.
 * Eobot
 */
public class UserID {
    /**
     * User ID
     */
    private String userid;

    /**
     * Public constructor
     * @param json json values
     */
    public UserID (JSONObject json) {
    
        this.userid = json.optString("userid");

    }

    /**
     * Get user ID
     * @return current user ID
     */
    public String getUserid() {
        return this.userid;
    }

}
