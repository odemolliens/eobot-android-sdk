package com.oslab.eobotsdk.domain;

/**
 * User - contains ID,Email and password.
 * Created by Demolliens Olivier - @odemolliens on 24/09/15.
 * Eobot
 */
public class User {

    /**
     * User ID
     */
    private String mUserID;
    /**
     * User email
     */
    private String mUserEmail;
    /**
     * User password
     */
    private String mUserPassword;

    /**
     * Public constructor, no setter available
     * @param mUserID current User ID
     * @param mUserEmail current User email
     * @param mUserPassword current User password
     */
    public User(String mUserID, String mUserEmail, String mUserPassword) {
        this.mUserID = mUserID;
        this.mUserEmail = mUserEmail;
        this.mUserPassword = mUserPassword;
    }

    /**
     * Get User ID
     * @return current User ID or "0"
     */
    public String getUserID() {
        return mUserID;
    }

    /**
     * Get User email
     * @return current User email or "0"
     */
    public String getUserEmail() {
        return mUserEmail;
    }

    /**
     * Get User password
     * @return current User password or "0"
     */
    public String getUserPassword() {
        return mUserPassword;
    }
}
