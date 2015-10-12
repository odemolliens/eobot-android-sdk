package com.oslab.eobotsdk.service.manager;

import com.oslab.eobotsdk.domain.Coin;
import com.oslab.eobotsdk.domain.CurrentMining;
import com.oslab.eobotsdk.domain.Deposit;
import com.oslab.eobotsdk.domain.EobotError;
import com.oslab.eobotsdk.domain.Estimate;
import com.oslab.eobotsdk.domain.Speed;
import com.oslab.eobotsdk.domain.Total;
import com.oslab.eobotsdk.domain.User;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Interfaces defined for all WebService
 * Created by Demolliens Olivier - @odemolliens on 24/09/15.
 * Eobot
 */
public class EobotInterface {

    /**
     * Eobot - WSListener - basic call
     */
    public interface EobotBasicListener {
        void successed(JSONObject output);

        void failure(EobotError output);
    }

    /**
     * Eobot - WSListener - login call
     */
    public interface EobotLoginListener {
        void successed(User user);

        void failure(EobotError output);
    }

    /**
     * Eobot - WSListener - get coin pruce call
     */
    public interface EobotCoinListener {
        void successed(Coin coin);

        void failure(EobotError output);
    }

    /**
     * Eobot - WSListener - get balance call
     */
    public interface EobotTotalListener {
        void successed(Total total);

        void failure(EobotError output);
    }

    /**
     * Eobot - WSListener - get speed call
     */
    public interface EobotSpeedListener {
        void successed(Speed speed);

        void failure(EobotError output);
    }

    /**
     * Eobot - WSListener - get estimation call
     */
    public interface EobotEstimateListener {
        void successed(Estimate estimate);

        void failure(EobotError output);
    }

    /**
     * Eobot - WSListener - get current mining call
     */
    public interface EobotMiningListener {
        void successed(CurrentMining currentMining);

        void failure(EobotError output);
    }

    /**
     * Eobot - WSListener - change current mining call
     */
    public interface EobotChangeMiningListener {
        void successed(boolean result);

        void failure(EobotError output);
    }

    /**
     * Eobot - WSListener - deposit call
     */
    public interface EobotDepositListener {
        void successed(Deposit deposit);

        void failure(EobotError output);
    }

    /**
     * Eobot - WSListener - buyCloud call
     */
    public interface EobotConvertListener {
        void successed(boolean result);

        void failure(EobotError output);
    }

    /**
     * Eobot - WSListener - buy coin estimate call
     */
    public interface EobotExchangeEstimateListener {
        void successed(double estimatedAmount);

        void failure(EobotError output);
    }

    /**
     * Eobot - WSListener - supported get coin price call
     */
    public interface EobotSupportedCoinListener {
        void successed(ArrayList<Coin> output);

        void failure(EobotError output);
    }


}
