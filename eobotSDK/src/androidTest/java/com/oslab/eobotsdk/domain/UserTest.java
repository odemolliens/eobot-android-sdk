package com.oslab.eobotsdk.domain;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.oslab.eobotsdk.domain.User;

/**
 * User - contains ID,Email and password.
 * Created by Demolliens Olivier - @odemolliens on 25/09/15.
 * Eobot
 */
public class UserTest extends ApplicationTestCase<Application> {
    public UserTest() {
        super(Application.class);
    }


    /**
     * Test User constructor
     */
    public void testConstructor() {
        String testValue = "0";
        User user = new User(testValue, testValue, testValue);
        boolean result = true;

        if (!user.getUserEmail().equals(testValue)) {
            result = false;
        }

        if (!user.getUserPassword().equals(testValue)) {
            result = false;
        }

        if (!user.getUserID().equals(testValue)) {
            result = false;
        }
        assert result;
    }


}
