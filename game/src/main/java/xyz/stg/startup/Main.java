package xyz.stg.startup;

import xyz.stg.player.service.Players;

/**
 * Created by tiangao on 2016/5/21.
 */
public class Main {

    public static void main(String[] args) {
        Players.ins.getAll();
        System.out.printf("end");
    }
}
