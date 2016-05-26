package xyz.stg.chat;

import xyz.stg.tcp.base.BaseAction;
import xyz.stg.tcp.base.Result;

/**
 * Created by tiangao on 2016/5/25.
 */
public class ChatAction extends BaseAction{

    @Override
    public String excute(String cmd) {
        switch (cmd) {
            case "chat@send":
                return  recieve();
            default:
                return Result.buildNoActionError();
        }
    }

    String recieve() {
        return "";
    }
}
