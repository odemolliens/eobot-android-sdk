package com.oslab.eobotsdk.domain;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.oslab.eobotsdk.constants.EobotErrorConstants;
import com.oslab.eobotsdk.domain.EobotError;

/**
 * Error object to handle all network problem
 * Created by Demolliens Olivier - @odemolliens on 25/09/15.
 * Eobot
 */
public class EobotErrorTest extends ApplicationTestCase<Application> {
    public EobotErrorTest() {
        super(Application.class);
    }

    /**
     * Test parse error management
     */
    public void testParseErrorCode() {
        assert EobotError.parseError().getErrorCode() == EobotErrorConstants.S_ERROR_PARSE_ERROR;
    }

    /**
     * Test no network error management
     */
    public void testNoNetworkErrorCode() {
        assert EobotError.noNetworkError().getErrorCode() == EobotErrorConstants.S_ERROR_NO_NETWORK;
    }

    /**
     * Test server error management
     */
    public void testServerErrorCode() {
        assert EobotError.serverError().getErrorCode() == EobotErrorConstants.S_ERROR_SERVER_ERROR;
    }

    /**
     * Test bad user session error management
     */
    public void testBadUserServerErrorCode() {
        assert EobotError.serverBadUser().getErrorCode() == EobotErrorConstants.S_ERROR_SERVER_BAD_USER;
    }
}
