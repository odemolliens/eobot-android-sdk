package com.oslab.eobotsdk.service;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.oslab.eobotsdk.constants.UserData;
import com.oslab.eobotsdk.domain.Coin;
import com.oslab.eobotsdk.domain.CurrentMining;
import com.oslab.eobotsdk.domain.Deposit;
import com.oslab.eobotsdk.domain.EobotError;
import com.oslab.eobotsdk.domain.Estimate;
import com.oslab.eobotsdk.domain.Speed;
import com.oslab.eobotsdk.domain.Total;
import com.oslab.eobotsdk.domain.User;
import com.oslab.eobotsdk.service.manager.EobotInterface;

import java.util.ArrayList;

/**
 * EobotService - provide all WebService calls
 * Created by Demolliens Olivier - @odemolliens on 25/09/15.
 * Eobot
 */
public class EobotServiceTest extends ApplicationTestCase<Application> {
    public EobotServiceTest() {
        super(Application.class);
    }


    /**
     * Login test successed
     */
    public void testLoginSuccess() {

        EobotService.login(UserData.realUser(), new EobotInterface.EobotLoginListener() {
            @Override
            public void successed(User user) {

                if (user.getUserID() == null || user.getUserID().isEmpty()) {
                    assert false;
                } else {
                    assert true;
                }
            }

            @Override
            public void failure(EobotError output) {
                assert false;
            }
        });
    }


    /**
     * Login test failed
     */
    public void testLoginFail() {
        EobotService.login(UserData.fakeUser(), new EobotInterface.EobotLoginListener() {
            @Override
            public void successed(User user) {
                assert false;
            }

            @Override
            public void failure(EobotError output) {
                assert true;
            }
        });
    }


    /**
     * Get coin price successed
     */
    public void testGetCoinPriceSuccess() {

        Coin coin = new Coin("BTC", "https://www.eobot.com/btc.png", "https://www.eobot.com/btcbig.png", 0);

        EobotService.getCoinPrice(coin, new EobotInterface.EobotCoinListener() {
            @Override
            public void successed(Coin coin) {

                //Price always change... so we test only if we have something or not
                assert coin.getPrice() > 0;

                assert true;
            }

            @Override
            public void failure(EobotError output) {
                assert false;
            }
        });

        assert true;
    }


    /**
     * Get supported coin TRUE successed
     */
    public void testCoinSupportedTrueSuccess() {
        EobotService.getSupportedCoins(true, new EobotInterface.EobotSupportedCoinListener() {
            @Override
            public void successed(ArrayList<Coin> coinArrayList) {

                //if coinArrayList is empty we get a failure callback
                Coin coin = coinArrayList.get(0);
                assert coin.getName().equals("BTC");
                assert coin.getBigImage().equals("https://www.eobot.com/btcbig.png");
                assert coin.getImage().equals("https://www.eobot.com/btc.png");
                //Price always change... so we test only if we have something or not
                assert coin.getPrice() > 0;

                assert true;
            }

            @Override
            public void failure(EobotError output) {
                assert false;
            }
        });
    }

    /**
     * Get supported coin TRUE successed
     */
    public void testCoinSupportedFalseSuccess() {
        EobotService.getSupportedCoins(false, new EobotInterface.EobotSupportedCoinListener() {
            @Override
            public void successed(ArrayList<Coin> coinArrayList) {

                // TODO: strange, same data with true parameters
                //if coinArrayList is empty we get a failure callback
                Coin coin = coinArrayList.get(0);
                assert coin.getName().equals("BTC");
                assert coin.getBigImage().equals("https://www.eobot.com/btcbig.png");
                assert coin.getImage().equals("https://www.eobot.com/btc.png");
                //Price always change... so we test only if we have something or not
                assert coin.getPrice() > 0;

                assert true;
            }

            @Override
            public void failure(EobotError output) {
                assert false;
            }
        });
    }


    /**
     * Get total successed
     */
    public void testTotalSuccess() {
        EobotService.getBalance(UserData.realUser(), new EobotInterface.EobotTotalListener() {
            @Override
            public void successed(Total total) {

                //Price always change... so we test only if we have something or not
                assert total.getTotal() > 0;

                Coin coin = total.getCoinList().get(0);
                assert coin.getName().equals("BTC");
                //Price always change... so we test only if we have something or not
                assert coin.getPrice() > 0;

                assert true;

            }

            @Override
            public void failure(EobotError output) {
                assert false;
            }
        });
    }


    /**
     * Get speed successed
     */
    public void testSpeedSuccess() {

        EobotService.getSpeed(UserData.realUser(), new EobotInterface.EobotSpeedListener() {
            @Override
            public void successed(Speed speed) {
                //Speed always change... so we test only if we have something or not
                assert speed.getCloudSHA256() > 0;
                assert speed.getCloud2SHA256() > 0;
                assert true;
            }

            @Override
            public void failure(EobotError output) {
                assert false;
            }
        });
    }


    /**
     * Get estimate successed
     */
    public void testEstimateSuccess() {

        EobotService.getEstimate(UserData.realUser(), new EobotInterface.EobotEstimateListener() {
            @Override
            public void successed(Estimate estimate) {
                //Estimate always change... so we test only if we have something or not
                assert estimate.getCloudSHA256() > 0;
                assert estimate.getCloud2SHA256() > 0;
                assert true;
            }

            @Override
            public void failure(EobotError output) {
                assert false;
            }
        });
    }


    /**
     * Get current mining successed
     */
    public void testCurrentMiningSuccess() {

        EobotService.getCurrentMining(UserData.realUser(), new EobotInterface.EobotMiningListener() {
            @Override
            public void successed(CurrentMining currentMining) {
                //Can change
                assert currentMining.equals("GHSCONTRACT");
                assert true;
            }

            @Override
            public void failure(EobotError output) {
                assert false;
            }
        });
    }

    /**
     * Get change mining successed
     */
    public void testChangeMiningSuccess() {
        EobotService.changeMining(UserData.realUser(), "GHSCONTRACT", new EobotInterface.EobotChangeMiningListener() {
            @Override
            public void successed(boolean success) {
                //No data from server
                assert true;
            }

            @Override
            public void failure(EobotError output) {
                assert false;
            }
        });

    }

    /**
     * Deposit successed
     */
    public void depositSuccess() {
        EobotService.deposit(UserData.realUser(), "BTC", new EobotInterface.EobotDepositListener() {
            @Override
            public void successed(Deposit deposit) {
                assert !deposit.getAddress().isEmpty();
                assert deposit.getCoinName().equals("BTC");
                assert true;
            }

            @Override
            public void failure(EobotError output) {
                assert false;
            }
        });
    }

    /**
     * Convert successed
     */
    public void convertSuccess() {
        EobotService.buyCloud(UserData.realUser(), "DOGE", "10", "GHS2", new EobotInterface.EobotConvertListener() {
            @Override
            public void successed(boolean result) {
                assert true;
            }

            @Override
            public void failure(EobotError output) {
                assert false;
            }
        });
    }

    /**
     * Convert exchange estimate
     */
    public void exchangeEstimateSuccess() {
        EobotService.exchangeEstimateCoin("DOGE", "20", "BTC", new EobotInterface.EobotExchangeEstimateListener() {
            @Override
            public void successed(double result) {
                assert result > 0;
                assert true;
            }

            @Override
            public void failure(EobotError output) {
                assert false;
            }
        });
    }


}

