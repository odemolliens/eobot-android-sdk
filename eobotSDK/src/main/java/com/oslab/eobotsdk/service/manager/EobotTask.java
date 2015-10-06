package com.oslab.eobotsdk.service.manager;

import android.os.AsyncTask;

import com.oslab.eobotsdk.domain.EobotError;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Generic task for all WebServices call
 * Created by Demolliens Olivier - @odemolliens on 24/09/15.
 * Eobot
 */
public class EobotTask extends AsyncTask<String, Void, EobotResult> {

    /**
     * Delegate
     */
    public EobotInterface.EobotBasicListener mDelegate;

    OkHttpClient mClient = new OkHttpClient();

    /**
     * Run request
     *
     * @param url to call
     * @return response or "" or "Error"
     * @throws IOException throw an IOError
     */
    EobotResult run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = mClient.newCall(request).execute();

        return new EobotResult(response.code(), response.body().string());
    }

    /**
     * Execute request in separated thread
     *
     * @param params url is param
     * @return response in String format
     */
    @Override
    protected EobotResult doInBackground(String... params) {
        try {

            // Define timeout
            mClient.setConnectTimeout(10, TimeUnit.SECONDS);
            mClient.setWriteTimeout(10, TimeUnit.SECONDS);
            mClient.setReadTimeout(30, TimeUnit.SECONDS);

            return this.run(params[0]);
        } catch (IOException e) {
            e.printStackTrace();
            //TODO:
            return new EobotResult(-1, "");
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
            //TODO: manage error 500 etc..
            mDelegate.failure(EobotError.parseError());
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
