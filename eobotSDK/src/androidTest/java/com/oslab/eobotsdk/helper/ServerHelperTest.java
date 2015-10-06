package com.oslab.eobotsdk.helper;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.oslab.eobotsdk.helper.ServerHelper;

/**
 * ServerHelper - manage current env., provide url with parameters
 * Created by Demolliens Olivier - @odemolliens on 24/09/15.
 * Eobot
 */
public class ServerHelperTest extends ApplicationTestCase<Application> {
    public ServerHelperTest() {
        super(Application.class);
    }

    /**
     *
     */
    public void testInstance() {
        assert ServerHelper.sharedServerHelper() != null;
    }
}