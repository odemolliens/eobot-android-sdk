package com.oslab.eobotsdk.constants;

import com.oslab.eobotsdk.domain.User;

/**
 * Real/fake data to test the API
 * Created by Demolliens Olivier - @odemolliens on 25/09/15.
 * Eobot
 */
public class UserData {


    /**
     * TODO
     *
     * @return
     */
    public static final User realUser() {
        return new User(S_TEST_USER_ID, S_TEST_USER_MAIL, S_TEST_USER_PASSWORD);
    }

    /**
     * TODO
     *
     * @return
     */
    public static final User fakeUser() {
        return new User(S_TEST_USER_ID_FAKE, S_TEST_USER_MAIL_FAKE, S_TEST_USER_PASSWORD_FAKE);
    }

    /**
     * Real user - mail
     */
    private static final String S_TEST_USER_MAIL = "USER";
    /**
     * Real user - password
     */
    private static final String S_TEST_USER_PASSWORD = "PWD";
    /**
     * Real user - id
     */
    private static final String S_TEST_USER_ID = "000";

    /**
     * Fake user - mail
     */
    private static final String S_TEST_USER_MAIL_FAKE = "fake@fake.com";
    /**
     * Fake user - password
     */
    private static final String S_TEST_USER_PASSWORD_FAKE = "0000";
    /**
     * Fake user - id
     */
    private static final String S_TEST_USER_ID_FAKE = "0001";
}
