package com.oslab.eobotsdk.constants;

/**
 * Error constants to handle all network problem
 * Created by Demolliens Olivier - @odemolliens on 25/09/15.
 * Eobot
 */
public class EobotErrorConstants {


    /**
     * Mobile side - parse error (CSV)
     */
    public static final int S_ERROR_PARSE_ERROR = -99;
    /**
     * Mobile side - network issue
     */
    public static final int S_ERROR_NETWORK_ISSUE = -103;
    /**
     * Mobile side - no network
     */
    public static final int S_ERROR_NO_NETWORK = -100;
    /**
     * Server side - error on server
     */
    public static final int S_ERROR_SERVER_ERROR = 500;
    /**
     * Server side - user not logged or password changed
     */
    public static final int S_ERROR_SERVER_BAD_USER = -102;

}
