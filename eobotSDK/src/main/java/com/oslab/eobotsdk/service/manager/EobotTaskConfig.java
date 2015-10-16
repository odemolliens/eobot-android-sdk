package com.oslab.eobotsdk.service.manager;

/**
 * Task configuration
 * Created by Demolliens Olivier - @odemolliens on 16/10/15.
 * Eobot
 */
public class EobotTaskConfig {

    private String mUrl;
    private int mCacheTime;
    private boolean mForceRefresh;


    public EobotTaskConfig(String mUrl, int mCacheTime, boolean forceRefresh) {
        this.mUrl = mUrl;
        this.mCacheTime = mCacheTime;
        this.mForceRefresh = forceRefresh;
    }

    public String getUrl() {
        return mUrl;
    }

    public int getCacheTime() {
        return mCacheTime;
    }

    public boolean isForceRefresh() {
        return mForceRefresh;
    }
}
