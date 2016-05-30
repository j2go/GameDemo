package xyz.stg.player.service;

import xyz.stg.player.domain.Player;

import java.util.List;

/**
 * 在线所有玩家信息
 * Created by shitiangao on 16/5/29.
 */
public enum Players {
    ins;
    public List<Player> getAll() {
        Player player = new Player();
        player.setId(1);
        player.setName("abb");
        player.setGold(100);
        System.out.println(player.hashCode());
        return null;
    }
}
