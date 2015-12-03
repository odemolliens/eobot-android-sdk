package com.oslab.eobotsdk.service.manager;

import android.os.AsyncTask;

import com.neopixl.logger.NPLog;
import com.oslab.eobotsdk.app.App;
import com.oslab.eobotsdk.constants.EobotErrorConstants;
import com.oslab.eobotsdk.domain.EobotError;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.CacheControl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

/**
 * Generic task for all WebServices call
 * Created by Demolliens Olivier - @odemolliens on 24/09/15.
 * Eobot
 */
public class EobotTask extends AsyncTask<EobotTaskConfig, Void, EobotResult> {

    public static final int S_EOBOT_TASK_NO_CACHE = -1;
    /**
     * Delegate
     */
    public EobotInterface.EobotBasicListener mDelegate;

    OkHttpClient mClient = new OkHttpClient();

    /**
     * Run request
     *
     * @param url          to call
     * @param cacheTime    duration when we cache the response
     * @param forceRefresh avoid cache and call server
     * @return response or "" or "Error"
     * @throws IOException throw an IOError
     */
    EobotResult run(String url, int cacheTime, boolean forceRefresh) throws IOException {

        try {
            Cache responseCache = new Cache(App.getAppContext().getCacheDir(), 10 * 1024 * 1024);
            mClient.setCache(responseCache);
            //http://stackoverflow.com/questions/29119253/retrofit-okhttp-client-how-to-cache-the-response ?
        } catch (Exception e) {
            NPLog.e("Unable to set http cache:" + e);
        }

        try {
            Request request;

            if (cacheTime != S_EOBOT_TASK_NO_CACHE || forceRefresh == true) {
                request = new Request.Builder()
                        .url(url)
                        .build();
            } else {
                request = new Request.Builder()
                        .url(url)
                        .cacheControl(new CacheControl.Builder().maxAge(cacheTime, TimeUnit.MINUTES).build())
                        .build();
            }

            Response response = mClient.newCall(request).execute();

            return new EobotResult(response.code(), response.body().string());
        } catch (UnknownHostException e) {
            return new EobotResult(EobotErrorConstants.S_ERROR_NO_NETWORK, "");
        }
    }

    /**
     * Execute request in separated thread
     *
     * @param params url is param
     * @return response in String format
     */
    @Override
    protected EobotResult doInBackground(EobotTaskConfig... params) {
        try {

            // Define timeout
            mClient.setConnectTimeout(15, TimeUnit.SECONDS);
            mClient.setWriteTimeout(15, TimeUnit.SECONDS);
            mClient.setReadTimeout(30, TimeUnit.SECONDS);

            EobotTaskConfig config = params[0];

            return this.run(config.getUrl(), config.getCacheTime(), config.isForceRefresh());

        } catch (IOException e) {
            e.printStackTrace();
            //TODO:
            return new EobotResult(EobotErrorConstants.S_ERROR_NETWORK_ISSUE, "");
        }
    }

    /**
     * After the call, execute some thing in main thread
     *
     * @param result current response from server
     */
    @Override
    protected void onPostExecute(EobotResult result) {

        if (result.getResultCode() == 200) {

            try {
                JSONObject jsonObject = new JSONObject(result.getResult());
                mDelegate.successed(jsonObject);

            } catch (JSONException e) {
                e.printStackTrace();
                mDelegate.failure(EobotError.parseError());
            }

        } else {
            if (result.getResultCode() == EobotErrorConstants.S_ERROR_NO_NETWORK) {
                mDelegate.failure(EobotError.noNetworkError());
            } else if (result.getResultCode() == EobotErrorConstants.S_ERROR_SERVER_ERROR) {
                mDelegate.failure(EobotError.serverError());
            } else {
                //TODO: unknow case
                mDelegate.failure(EobotError.serverError());
            }

        }


    }

    /**
     * Do before launch the call
     */
    @Override
    protected void onPreExecute() {
    }

    /**
     * Current progress update
     *
     * @param values
     */
    @Override
    protected void onProgressUpdate(Void... values) {
    }

    /**
     * Set basic delegate accessor
     *
     * @param mDelegate set a new basic delegate
     */
    public void setDelegate(EobotInterface.EobotBasicListener mDelegate) {
        this.mDelegate = mDelegate;
    }


}
