package com.oslab.eobotsdk.domain;


import com.oslab.eobotsdk.R;
import com.oslab.eobotsdk.app.App;
import com.oslab.eobotsdk.constants.EobotErrorConstants;

/**
 * EobotError
 * Error object to handle all network problem
 * Created by Demolliens Olivier - @odemolliens on 24/09/15.
 * Eobot
 */
public class EobotError {

    /**
     * Current error code
     */
    private int mErrorCode;

    /**
     * Current localized error message
     */
    private int mLocalizedMessage;


    /**
     * Public contructor (no setter available)
     *
     * @param mErrorCode error code
     */
    private EobotError(int mErrorCode) {

        this.mErrorCode = mErrorCode;

        int message;

        switch (this.mErrorCode) {
            case EobotErrorConstants.S_ERROR_PARSE_ERROR:
                message = R.string.app_error_error;
                break;

            case EobotErrorConstants.S_ERROR_NO_NETWORK:
                message = R.string.internet_need_internet;
                break;

            case EobotErrorConstants.S_ERROR_SERVER_ERROR:
                message = R.string.app_error_error;
                break;
            case EobotErrorConstants.S_ERROR_NETWORK_ISSUE:
                message = R.string.internet_need_internet_issues;
                break;

            case EobotErrorConstants.S_ERROR_SERVER_BAD_USER:
                message = R.string.app_error_user;
                break;

            default:
                message = R.string.app_error_error;
                break;
        }
        // public static final int S_ERROR_NETWORK_ISSUE = -103;

        mLocalizedMessage = message;
    }

    /**
     * Get default message
     *
     * @return localized ID message
     */
    public String getDefaultMessage(String defaultTitle) {
        //TODO: refactor constants in enum
        if (mErrorCode == EobotErrorConstants.S_ERROR_PARSE_ERROR
                || mErrorCode == EobotErrorConstants.S_ERROR_NO_NETWORK
                || mErrorCode == EobotErrorConstants.S_ERROR_SERVER_ERROR
                || mErrorCode == EobotErrorConstants.S_ERROR_NETWORK_ISSUE
                || mErrorCode == EobotErrorConstants.S_ERROR_SERVER_BAD_USER) {
            return getLocalizedMessage();
        } else {
            return defaultTitle;
        }
    }

    /**
     * Get parse error
     *
     * @return filled error object
     */
    public static EobotError parseError() {
        return new EobotError(EobotErrorConstants.S_ERROR_PARSE_ERROR);
    }

    /**
     * Get no network error
     *
     * @return filled error object
     */
    public static EobotError noNetworkError() {
        return new EobotError(EobotErrorConstants.S_ERROR_NO_NETWORK);
    }

    /**
     * Get server error
     *
     * @return filled error object
     */
    public static EobotError serverError() {
        return new EobotError(EobotErrorConstants.S_ERROR_SERVER_ERROR);
    }

    /**
     * Get bad user error
     *
     * @return filled error object
     */
    public static EobotError serverBadUser() {
        return new EobotError(EobotErrorConstants.S_ERROR_SERVER_BAD_USER);
    }

    /**
     * Get error code
     *
     * @return current error code
     */
    public int getErrorCode() {
        return mErrorCode;
    }

    /**
     * Get localized ID message
     *
     * @return localized ID message
     */
    public int getLocalizedMessageID() {
        return mLocalizedMessage;
    }

    /**
     * Get localized message
     *
     * @return localized message
     */
    public String getLocalizedMessage() {
        return App.getAppContext().getString(mLocalizedMessage);
    }
}
