package xyz.stg.player.action;

import xyz.stg.tcp.base.BaseAction;
import xyz.stg.tcp.base.Result;

/**
 * Created by tiangao on 2016/5/24.
 */
public class PlayerAction extends BaseAction{

    public String excute(String cmd) {
        switch (cmd) {
            case "player@login":
                return login();
            default:
                return Result.buildNoActionError();
        }

    }

    String login() {
        String name = getPara("username");
        String pwd = getPara("password");
        if ("aaa".endsWith(name) && "123".equals(pwd)) {
            return "succ";
        }
        return Result.buildError("");
    }
}
