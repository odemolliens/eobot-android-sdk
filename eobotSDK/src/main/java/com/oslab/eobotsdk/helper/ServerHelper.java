package com.oslab.eobotsdk.helper;

import com.oslab.eobotsdk.domain.Coin;

/**
 * ServerHelper - manage current env., provide url with parameters
 * Created by Demolliens Olivier - @odemolliens on 24/09/15.
 * Eobot
 */
public class ServerHelper {

    /**
     * Dev Server
     */
    private static final String S_SERVERHELPER_DEV = "?/";//TODO: dev env?
    /**
     * Prod Server
     */
    private static final String S_SERVERHELPER_PROD = "https://www.eobot.com/";
    /**
     * Chat Dev Server
     */
    private static final String S_SERVERHELPER_CHAT_DEV = "?/";//TODO: dev env?
    /**
     * Chat Prod Server
     */
    private static final String S_SERVERHELPER_CHAT_PROD = "https://eobotchat.chatango.com/";
    /**
     * Api path
     */
    private static final String S_SERVERHELPER_API_PATH = "api.aspx";
    /**
     * Api key UserID
     */
    private static final String S_SERVERHELPER_API_KEY_ID = "?id=";
    /**
     * Api key UserEmail
     */
    private static final String S_SERVERHELPER_API_KEY_USER_EMAIL = "&email=";
    /**
     * Api key UserPassword
     */
    private static final String S_SERVERHELPER_API_KEY_PASSWORD = "&password=";
    /**
     * Api retrieve JSON Objects
     */
    private static final String S_SERVERHELPER_API_KEY_JSON_RESULT = "&json=true";
    /**
     * Singleton
     */
    private static ServerHelper mSharedInstance = null;
    /**
     * Main theme
     */
    private Config mConfig;

    /**
     * Private constructor
     */
    private ServerHelper() {
        super();
        mConfig = Config.Prod;
    }

    /**
     * Single instance
     *
     * @return current server instance
     */
    public static ServerHelper sharedServerHelper() {
        if (mSharedInstance == null) {
            mSharedInstance = new ServerHelper();
        }
        return mSharedInstance;
    }

    /**
     * Root url defined by config enum in instance
     *
     * @return root url
     */
    public String rootURL() {

        if (this.mConfig == Config.Dev) {
            return S_SERVERHELPER_DEV;
        } else if (this.mConfig == Config.Prod) {
            return S_SERVERHELPER_PROD;
        } else {
            return "";
        }
    }

    /**
     * Root chat URL
     *
     * @return chat url
     */
    public String rootChatURL() {

        if (this.mConfig == Config.Dev) {
            return S_SERVERHELPER_CHAT_DEV;
        } else if (this.mConfig == Config.Prod) {
            return S_SERVERHELPER_CHAT_PROD;
        } else {
            return "";
        }
    }

    /**
     * Forgot URL
     *
     * @return builded url
     */
    public String forgotURL() {
        String rootUrl = ServerHelper.sharedServerHelper().rootURL();
        return rootUrl + "forgot";
    }

    /**
     * Signup URL
     *
     * @return builded url
     */
    public String signupURL() {
        String rootUrl = ServerHelper.sharedServerHelper().rootURL();
        return rootUrl + "signup";
    }

    /**
     * Login URL
     *
     * @return builded url
     */
    public String loginURL(String email, String password) {
        String rootUrl = ServerHelper.sharedServerHelper().rootURL();
        return rootUrl + S_SERVERHELPER_API_PATH + "?email=" + email + S_SERVERHELPER_API_KEY_PASSWORD + password + S_SERVERHELPER_API_KEY_JSON_RESULT;
    }

    /**
     * Coin URL
     *
     * @return builded url
     */
    public String coinPriceURL(String coinName) {
        String rootUrl = ServerHelper.sharedServerHelper().rootURL();
        return rootUrl + S_SERVERHELPER_API_PATH + "?coin=" + coinName + S_SERVERHELPER_API_KEY_JSON_RESULT;
    }

    /**
     * Total URL
     *
     * @return builded url
     */
    public String totalURL(String id) {
        String rootUrl = ServerHelper.sharedServerHelper().rootURL();
        return rootUrl + S_SERVERHELPER_API_PATH + "?total=" + id + S_SERVERHELPER_API_KEY_JSON_RESULT;
    }

    /**
     * Speed URL
     *
     * @return builded url
     */
    public String speedURL(String id) {
        String rootUrl = ServerHelper.sharedServerHelper().rootURL();
        return rootUrl + S_SERVERHELPER_API_PATH + "?idspeed=" + id + S_SERVERHELPER_API_KEY_JSON_RESULT;
    }

    /**
     * Estimate URL
     *
     * @return builded url
     */
    public String estimateURL(String id) {
        String rootUrl = ServerHelper.sharedServerHelper().rootURL();
        return rootUrl + S_SERVERHELPER_API_PATH + "?idestimates=" + id + S_SERVERHELPER_API_KEY_JSON_RESULT;
    }

    /**
     * Mining URL
     *
     * @return builded url
     */
    public String miningURL(String id) {
        String rootUrl = ServerHelper.sharedServerHelper().rootURL();
        return rootUrl + S_SERVERHELPER_API_PATH + "?idmining=" + id + S_SERVERHELPER_API_KEY_JSON_RESULT;
    }

    /**
     * Change getCurrentMining URL
     *
     * @return builded url
     */
    public String changeMiningURL(String id, String email, String password, String coinName) {
        String rootUrl = ServerHelper.sharedServerHelper().rootURL();
        return rootUrl + S_SERVERHELPER_API_PATH + S_SERVERHELPER_API_KEY_ID + id + S_SERVERHELPER_API_KEY_USER_EMAIL + email + S_SERVERHELPER_API_KEY_PASSWORD + password + "&mining=" + coinName + S_SERVERHELPER_API_KEY_JSON_RESULT;
    }

    /**
     * Deposit URL
     *
     * @return builded url
     */
    public String depositURL(String id, String coinName) {
        String rootUrl = ServerHelper.sharedServerHelper().rootURL();
        return rootUrl + S_SERVERHELPER_API_PATH + S_SERVERHELPER_API_KEY_ID + id + "&deposit=" + coinName + S_SERVERHELPER_API_KEY_JSON_RESULT;
    }

    /**
     * Convert URL
     *
     * @return builded url
     */
    public String convertURL(String id, String email, String password, String convertFrom, String amount, String convertTo) {
        String rootUrl = ServerHelper.sharedServerHelper().rootURL();
        return rootUrl + S_SERVERHELPER_API_PATH + S_SERVERHELPER_API_KEY_ID + id + S_SERVERHELPER_API_KEY_USER_EMAIL + email + S_SERVERHELPER_API_KEY_PASSWORD + password + "&convertfrom=" + convertFrom + "&amount=" + amount + "&convertto=" + convertTo + S_SERVERHELPER_API_KEY_JSON_RESULT;
    }

    /**
     * Exchange estimate URL
     *
     * @return builded url
     */
    public String exchangeEstimateURL(String convertFrom, String amount, String convertTo) {
        String rootUrl = ServerHelper.sharedServerHelper().rootURL();
        return rootUrl + S_SERVERHELPER_API_PATH + "?exchangefee=true" + "&convertfrom=" + convertFrom + "&amount=" + amount + "&convertto=" + convertTo + S_SERVERHELPER_API_KEY_JSON_RESULT;
    }

    /**
     * Supported fiat coins URL
     *
     * @param value
     * @return builded url
     */
    public String supportedFIATCoins(Boolean value) {
        String rootUrl = ServerHelper.sharedServerHelper().rootURL();

        String result = null;

        if (value == true) {
            result = "true";
        } else {
            result = "false";
        }
        return rootUrl + S_SERVERHELPER_API_PATH + "?supportedfiat=" + value + S_SERVERHELPER_API_KEY_JSON_RESULT;
    }

    /**
     * Supported coins URL
     *
     * @param value
     * @return builded url
     */
    public String supportedCoins(Boolean value) {
        String rootUrl = ServerHelper.sharedServerHelper().rootURL();

        String result = null;

        if (value == true) {
            result = "true";
        } else {
            result = "false";
        }
        return rootUrl + S_SERVERHELPER_API_PATH + "?supportedcoins=" + value + S_SERVERHELPER_API_KEY_JSON_RESULT;
    }

    /**
     * Manual withdraw
     *
     * @param id       user id
     * @param email    user email
     * @param password user password
     * @param coin     coin to withdraw
     * @param amount   amount to withdraw
     * @param address  withdraw address
     * @return builded url
     */
    public String manualWithdraw(String id, String email, String password, Coin coin, double amount, String address) {
        String rootUrl = ServerHelper.sharedServerHelper().rootURL();
        return rootUrl + S_SERVERHELPER_API_PATH + S_SERVERHELPER_API_KEY_ID + id + "&email=" + email + S_SERVERHELPER_API_KEY_PASSWORD + password + "&manualwithdraw=" + coin.getName() + "&amount=" + amount + "&wallet=" + address + S_SERVERHELPER_API_KEY_JSON_RESULT;
    }

    /**
     * Automatic withdraw
     *
     * @param id       user id
     * @param email    user email
     * @param password user password
     * @param coin     coin to withdraw
     * @param amount   amount to withdraw
     * @param address  withdraw address
     * @return builded url
     */
    public String automaticWithdraw(String id, String email, String password, Coin coin, double amount, String address) {
        String rootUrl = ServerHelper.sharedServerHelper().rootURL();
        return rootUrl + S_SERVERHELPER_API_PATH + S_SERVERHELPER_API_KEY_ID + id + "&email=" + email + S_SERVERHELPER_API_KEY_PASSWORD + password + "&withdraw=" + coin.getName() + "&amount=" + amount + "&wallet=" + address + S_SERVERHELPER_API_KEY_JSON_RESULT;
    }

    /**
     * Config Enum
     */
    private enum Config {
        /// Dev env.
        Dev,
        /// Prod env.
        Prod
    }

}
