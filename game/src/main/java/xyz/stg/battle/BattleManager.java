package xyz.stg.battle;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by tiangao on 2016/5/25.
 */
public enum  BattleManager {
    ins;

    private ExecutorService executorService;

    public void init() {
        executorService = Executors.newCachedThreadPool();
    }

    public void addBattle() {

    }
}
