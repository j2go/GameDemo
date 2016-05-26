package xyz.stg.tcp.websocket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tiangao on 2016/5/26.
 */
public enum PushCommander {
    ins;

    private Map<String, ChannelHandlerContext> map = new HashMap<>();

    public void put(String id, ChannelHandlerContext ctx) {
        map.put(id, ctx);
    }

    public int push(String id, String msg) {
        ChannelHandlerContext ctx = map.get(id);
        if (ctx != null) {
            ctx.channel().writeAndFlush(new TextWebSocketFrame(msg));
            return 1;
        }
        return -1;
    }

    public void pushAll(String msg) {
        for (ChannelHandlerContext ctx : map.values()) {
            ctx.channel().writeAndFlush(new TextWebSocketFrame(msg));
        }
    }
}
