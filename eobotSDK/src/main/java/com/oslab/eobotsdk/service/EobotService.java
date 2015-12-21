package com.oslab.eobotsdk.service;

import com.oslab.eobotsdk.domain.Coin;
import com.oslab.eobotsdk.domain.CurrentMining;
import com.oslab.eobotsdk.domain.Deposit;
import com.oslab.eobotsdk.domain.EobotError;
import com.oslab.eobotsdk.domain.Estimate;
import com.oslab.eobotsdk.domain.Speed;
import com.oslab.eobotsdk.domain.Total;
import com.oslab.eobotsdk.domain.User;
import com.oslab.eobotsdk.domain.UserID;
import com.oslab.eobotsdk.helper.ServerHelper;
import com.oslab.eobotsdk.service.manager.EobotInterface;
import com.oslab.eobotsdk.service.manager.EobotTask;
import com.oslab.eobotsdk.service.manager.EobotTaskConfig;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * EobotService - provide all WebService calls
 * Created by Demolliens Olivier - @odemolliens on 24/09/15.
 * Eobot
 */
public class EobotService {


    /**
     * Login service
     *
     * @param user     current user
     * @param listener Mining listener
     */
    public static void login(final User user, final EobotInterface.EobotLoginListener listener) {

        String userPwd;
        try {
            userPwd = URLEncoder.encode(user.getUserPassword(), "utf-8");
        } catch (UnsupportedEncodingException e) {
            userPwd = user.getUserPassword();
        }

        //GET
        String url = ServerHelper.sharedServerHelper().loginURL(user.getUserEmail(), userPwd);

        EobotTask aTask = new EobotTask();

        aTask.setDelegate(new EobotInterface.EobotBasicListener() {
            @Override
            public void successed(JSONObject output) {

                UserID userID = new UserID(output);

                if (userID != null || userID.getUserid() != null) {

                    if (!userID.getUserid().isEmpty()) {
                        User newUser = new User(userID.getUserid(), user.getUserEmail(), user.getUserPassword());
                        listener.successed(newUser);
                    } else {
                        listener.failure(EobotError.serverBadUser());
                    }

                } else {
                    listener.failure(EobotError.parseError());
                }

            }

            @Override
            public void failure(EobotError output) {
                listener.failure(output);
            }
        });


        EobotTaskConfig config = new EobotTaskConfig(url, EobotTask.S_EOBOT_TASK_NO_CACHE, true);
        aTask.execute(config);
    }

    /**
     * Get getCoinPrice service
     *
     * @param coin     current coin price
     * @param listener Coin Listener
     */
    public static void getCoinPrice(Coin coin, final EobotInterface.EobotCoinListener listener) {
        //GET
        final String coinName = coin.getName();

        String url = ServerHelper.sharedServerHelper().coinPriceURL(coinName);

        EobotTask aTask = new EobotTask();

        aTask.setDelegate(new EobotInterface.EobotBasicListener() {
            @Override
            public void successed(JSONObject output) {

                Coin coin = new Coin(output, coinName);

                if (coin != null) {
                    listener.successed(coin);
                } else {
                    listener.failure(EobotError.parseError());
                }
            }

            @Override
            public void failure(EobotError output) {
                listener.failure(output);
            }
        });

        EobotTaskConfig config = new EobotTaskConfig(url, EobotTask.S_EOBOT_TASK_NO_CACHE, true);
        aTask.execute(config);
    }

    /**
     * Get balance service
     *
     * @param user     current user
     * @param listener Total listener
     */
    public static void getBalance(User user, final EobotInterface.EobotTotalListener listener) {

        //GET
        String url = ServerHelper.sharedServerHelper().totalURL(user.getUserID());

        EobotTask aTask = new EobotTask();

        aTask.setDelegate(new EobotInterface.EobotBasicListener() {
            @Override
            public void successed(JSONObject output) {
                try {

                    Total total = new Total();
                    Iterator<?> keys = output.keys();

                    boolean checkIfData = false;

                    while (keys.hasNext()) {
                        String key = (String) keys.next();

                        checkIfData = true;

                        // Special key for getBalance amount
                        if (key.equals("Total")) {
                            total.setTotal(output.optDouble("Total"));
                        } else {

                            double value = Double.valueOf((String) output.get(key));

                            Coin coin = new Coin(value, key);

                            if (coin != null) {
                                total.getCoinList().add(coin);
                            }

                        }
                    }

                    if (checkIfData = false) {
                        listener.failure(EobotError.serverError());
                    } else {
                        listener.successed(total);
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                    listener.failure(EobotError.parseError());
                }
            }

            @Override
            public void failure(EobotError output) {
                listener.failure(output);
            }
        });

        EobotTaskConfig config = new EobotTaskConfig(url, EobotTask.S_EOBOT_TASK_NO_CACHE, true);
        aTask.execute(config);
    }

    /**
     * Get speed service
     *
     * @param user     current user
     * @param listener Speed listener
     */
    public static void getSpeed(User user, final EobotInterface.EobotSpeedListener listener) {
        //GET
        String url = ServerHelper.sharedServerHelper().speedURL(user.getUserID());

        EobotTask aTask = new EobotTask();

        aTask.setDelegate(new EobotInterface.EobotBasicListener() {
            @Override
            public void successed(JSONObject output) {

                Speed speed = new Speed(output);

                //TODO: improve checking double != 0
                if (speed != null) {
                    listener.successed(speed);
                } else {
                    listener.failure(EobotError.parseError());
                }

            }

            @Override
            public void failure(EobotError output) {
                listener.failure(output);
            }
        });

        EobotTaskConfig config = new EobotTaskConfig(url, EobotTask.S_EOBOT_TASK_NO_CACHE, true);
        aTask.execute(config);
    }

    /**
     * Get estimate service
     *
     * @param user     current user
     * @param listener Estimate listener
     */
    public static void getEstimate(User user, final EobotInterface.EobotEstimateListener listener) {
        //GET
        String url = ServerHelper.sharedServerHelper().estimateURL(user.getUserID());

        EobotTask aTask = new EobotTask();

        aTask.setDelegate(new EobotInterface.EobotBasicListener() {
            @Override
            public void successed(JSONObject output) {
                Estimate estimate = new Estimate(output);

                //TODO: improve checking double != 0
                if (estimate != null) {
                    listener.successed(estimate);
                } else {
                    listener.failure(EobotError.parseError());
                }
            }

            @Override
            public void failure(EobotError output) {
                listener.failure(output);
            }
        });

        EobotTaskConfig config = new EobotTaskConfig(url, EobotTask.S_EOBOT_TASK_NO_CACHE, true);
        aTask.execute(config);
    }

    /**
     * Get current mining service
     *
     * @param user     current user
     * @param listener Mining listener
     */
    public static void getCurrentMining(User user, final EobotInterface.EobotMiningListener listener) {
        //GET
        String url = ServerHelper.sharedServerHelper().miningURL(user.getUserID());

        EobotTask aTask = new EobotTask();

        aTask.setDelegate(new EobotInterface.EobotBasicListener() {
            @Override
            public void successed(JSONObject output) {
                CurrentMining currentMining = new CurrentMining(output);

                //TODO: improve checking current getCurrentMining value
                if (currentMining != null) {
                    listener.successed(currentMining);
                } else {
                    listener.failure(EobotError.parseError());
                }
            }

            @Override
            public void failure(EobotError output) {
                listener.failure(output);
            }
        });

        EobotTaskConfig config = new EobotTaskConfig(url, EobotTask.S_EOBOT_TASK_NO_CACHE, true);
        aTask.execute(config);
    }

    /**
     * Get change mining
     *
     * @param user     current user
     * @param coinName current getCoinPrice name
     * @param listener ChangeMining Listener
     */
    public static void changeMining(User user, String coinName, final EobotInterface.EobotChangeMiningListener listener) {


        String userPwd = null;
        try {
            userPwd = URLEncoder.encode(user.getUserPassword(), "utf-8");
        } catch (UnsupportedEncodingException e) {
            userPwd = user.getUserPassword();
        }


        //GET
        String url = ServerHelper.sharedServerHelper().changeMiningURL(user.getUserID(), user.getUserEmail(), userPwd, coinName);

        EobotTask aTask = new EobotTask();

        aTask.setDelegate(new EobotInterface.EobotBasicListener() {
            @Override
            public void successed(JSONObject output) {
                listener.successed(true);
            }

            @Override
            public void failure(EobotError output) {
                listener.failure(output);
            }
        });

        EobotTaskConfig config = new EobotTaskConfig(url, EobotTask.S_EOBOT_TASK_NO_CACHE, true);
        aTask.execute(config);
    }

    /**
     * Get deposit service
     *
     * @param user     current user
     * @param coinName current getCoinPrice name
     * @param listener Deposit listener
     */
    public static void deposit(User user, String coinName, final EobotInterface.EobotDepositListener listener) {
        //GET
        String url = ServerHelper.sharedServerHelper().depositURL(user.getUserID(), coinName);

        final String coin = coinName;

        EobotTask aTask = new EobotTask();

        aTask.setDelegate(new EobotInterface.EobotBasicListener() {
            @Override
            public void successed(JSONObject output) {
                listener.successed(new Deposit(output, coin));
            }

            @Override
            public void failure(EobotError output) {
                listener.failure(output);
            }
        });

        EobotTaskConfig config = new EobotTaskConfig(url, EobotTask.S_EOBOT_TASK_NO_CACHE, true);
        aTask.execute(config);
    }

    /**
     * Buy cloud service
     *
     * @param user        current user
     * @param convertFrom currency to buyCloud BTC, LTC, BLK, NMC, DOGE, XRP, DASH, RDD, BTS, CURE, SJCX, XMR, XCP, STR, BCN, PPC, NXT, MAID, ETH, GRC
     * @param amount      current amount
     * @param convertTo   GHS or GHS2 or SCRYPT
     * @param listener    Convert listener
     */
    public static void buyCloud(User user, String convertFrom, String amount, String convertTo, final EobotInterface.EobotConvertListener listener) {

        String userPwd;
        try {
            userPwd = URLEncoder.encode(user.getUserPassword(), "utf-8");
        } catch (UnsupportedEncodingException e) {
            userPwd = user.getUserPassword();
        }

        //GET
        String url = ServerHelper.sharedServerHelper().convertURL(user.getUserID(), user.getUserEmail(), userPwd, convertFrom, amount, convertTo);

        EobotTask aTask = new EobotTask();

        aTask.setDelegate(new EobotInterface.EobotBasicListener() {
            @Override
            public void successed(JSONObject output) {
                listener.successed(true);
            }

            @Override
            public void failure(EobotError output) {
                listener.failure(output);
            }
        });

        EobotTaskConfig config = new EobotTaskConfig(url, EobotTask.S_EOBOT_TASK_NO_CACHE, true);
        aTask.execute(config);
    }


    /**
     * Exchange estimate service
     *
     * @param convertFrom currency to
     * @param amount      current amount
     * @param convertTo   convert to any coin available on list
     * @param listener    Convert listener
     */
    public static void exchangeEstimateCoin(String convertFrom, String amount, String convertTo, final EobotInterface.EobotExchangeEstimateListener listener) {

        //GET
        String url = ServerHelper.sharedServerHelper().exchangeEstimateURL(convertFrom, amount, convertTo);

        EobotTask aTask = new EobotTask();

        aTask.setDelegate(new EobotInterface.EobotBasicListener() {
            @Override
            public void successed(JSONObject output) {
                //TODO
                try {
                    listener.successed(Double.valueOf(output.getString("Result")));

                } catch (JSONException e) {
                    e.printStackTrace();
                    listener.failure(EobotError.parseError());
                } catch (Exception e) {
                    e.printStackTrace();
                    listener.failure(EobotError.parseError());
                }
            }

            @Override
            public void failure(EobotError output) {
                listener.failure(output);
            }
        });

        EobotTaskConfig config = new EobotTaskConfig(url, EobotTask.S_EOBOT_TASK_NO_CACHE, true);
        aTask.execute(config);
    }

    /**
     * Supported coins service
     *
     * @param value    supported or not
     * @param listener SupportedCoi listener
     */
    public static void getSupportedCoins(Boolean value, final EobotInterface.EobotSupportedCoinListener listener) {
        //GET
        String url = ServerHelper.sharedServerHelper().supportedCoins(value);

        EobotTask aTask = new EobotTask();

        aTask.setDelegate(new EobotInterface.EobotBasicListener() {
            @Override
            public void successed(JSONObject output) {
                try {

                    ArrayList<Coin> coinArrayList = new ArrayList<Coin>();

                    Iterator<?> keys = output.keys();

                    while (keys.hasNext()) {
                        String key = (String) keys.next();
                        if (key != null && output.get(key) instanceof JSONObject) {

                            Coin coin = new Coin((JSONObject) output.get(key), key);

                            if (coin != null) {
                                coinArrayList.add(coin);
                            }
                        }
                    }

                    if (coinArrayList.size() == 0) {
                        listener.failure(EobotError.serverError());
                    } else {
                        listener.successed(coinArrayList);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    listener.failure(EobotError.parseError());
                }
            }

            @Override
            public void failure(EobotError output) {
                listener.failure(output);
            }
        });

        EobotTaskConfig config = new EobotTaskConfig(url, 24 * 60, false);
        aTask.execute(config);

    }

    /**
     * Supported coins service
     *
     * @param value    supported or not
     * @param listener SupportedCoi listener
     */
    public static void getSupportedFiatCoins(Boolean value, final EobotInterface.EobotSupportedCoinListener listener) {
        //GET
        String url = ServerHelper.sharedServerHelper().supportedFIATCoins(value);

        EobotTask aTask = new EobotTask();

        aTask.setDelegate(new EobotInterface.EobotBasicListener() {
            @Override
            public void successed(JSONObject output) {
                try {

                    ArrayList<Coin> coinArrayList = new ArrayList<Coin>();

                    Iterator<?> keys = output.keys();

                    while (keys.hasNext()) {
                        String key = (String) keys.next();
                        if (key != null && output.get(key) instanceof JSONObject) {

                            Coin coin = new Coin((JSONObject) output.get(key), key);

                            if (coin != null) {
                                coinArrayList.add(coin);
                            }
                        }
                    }

                    if (coinArrayList.size() == 0) {
                        listener.failure(EobotError.serverError());
                    } else {
                        listener.successed(coinArrayList);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    listener.failure(EobotError.parseError());
                }
            }

            @Override
            public void failure(EobotError output) {
                listener.failure(output);
            }
        });

        EobotTaskConfig config = new EobotTaskConfig(url, 24 * 60, false);
        aTask.execute(config);

    }

    /**
     * Manual withdraw
     *
     * @param user     user account
     * @param address  amount to send to this address
     * @param coin     coin name
     * @param amount   amount to withdraw
     * @param listener EobotWithdrawListener
     */
    public static void manualWithdraw(User user, String address, Coin coin, double amount, final EobotInterface.EobotWithdrawListener listener) {

        String userPwd;
        try {
            userPwd = URLEncoder.encode(user.getUserPassword(), "utf-8");
        } catch (UnsupportedEncodingException e) {
            userPwd = user.getUserPassword();
        }

        //GET
        String url = ServerHelper.sharedServerHelper().manualWithdraw(user.getUserID(), user.getUserEmail(), userPwd, coin, amount, address);

        EobotTask aTask = new EobotTask();

        aTask.setDelegate(new EobotInterface.EobotBasicListener() {
            @Override
            public void successed(JSONObject output) {
                listener.successed(true);
            }

            @Override
            public void failure(EobotError output) {
                listener.failure(output);
            }
        });

        EobotTaskConfig config = new EobotTaskConfig(url, EobotTask.S_EOBOT_TASK_NO_CACHE, true);
        aTask.execute(config);
    }

    /**
     * Automatic withdraw
     *
     * @param user     user account
     * @param address  amount to send to this address
     * @param coin     coin name
     * @param amount   amount to withdraw
     * @param listener EobotWithdrawListener
     */
    public static void automaticWithdraw(User user, String address, Coin coin, double amount, final EobotInterface.EobotWithdrawListener listener) {

        String userPwd;
        try {
            userPwd = URLEncoder.encode(user.getUserPassword(), "utf-8");
        } catch (UnsupportedEncodingException e) {
            userPwd = user.getUserPassword();
        }

        //GET
        String url = ServerHelper.sharedServerHelper().automaticWithdraw(user.getUserID(), user.getUserEmail(), userPwd, coin, amount, address);

        EobotTask aTask = new EobotTask();

        aTask.setDelegate(new EobotInterface.EobotBasicListener() {
            @Override
            public void successed(JSONObject output) {
                listener.successed(true);
            }

            @Override
            public void failure(EobotError output) {
                listener.failure(output);
            }
        });

        EobotTaskConfig config = new EobotTaskConfig(url, EobotTask.S_EOBOT_TASK_NO_CACHE, true);
        aTask.execute(config);
    }

}
