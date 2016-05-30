package xyz.stg.common;

import xyz.stg.chat.ChatAction;
import xyz.stg.player.action.PlayerAction;
import xyz.stg.tcp.base.ActionManager;

/**
 * Created by tiangao on 2016/5/24.
 */
public class Router {
    public void init() {
        ActionManager.ins.register("player@login", PlayerAction.class);
        ActionManager.ins.register("chat@send", ChatAction.class);
    }
}
