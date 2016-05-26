package xyz.stg.tcp.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.stg.tcp.base.ActionManager;
import xyz.stg.tcp.base.BaseAction;
import xyz.stg.tcp.base.Result;

/**
 * Created by tiangao on 2016/5/22.
 */
public class GameServerHandler extends ChannelInboundHandlerAdapter{
    private static final Logger log = LoggerFactory.getLogger(GameServerHandler.class);

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        log.debug("=== channelRegistered ===");
        log.debug("---" + ctx.toString());
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        log.debug("=== channelUnregistered ===");
        log.debug("---" + ctx.toString());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        log.debug("=== channelRead ===");
        log.debug("---" + ctx.toString());
        log.debug("---" + msg.toString());
        if (msg instanceof String) {
            JSONObject json = JSON.parseObject((String) msg);
            String cmd = json.getString("cmd");
            Class actionClass = ActionManager.ins.getActionClass(cmd);
            if (actionClass == null) {
                ctx.writeAndFlush(Result.buildError("wrong cmd name"));
                return;
            }
            BaseAction action = (BaseAction) actionClass.newInstance();
            action.setParas(json);
            String res = null;
            try {
                res = action.excute(cmd);
            } catch (Exception e) {
                ctx.writeAndFlush(Result.buildError("exception"));

                e.printStackTrace();
                return;
            }

            ctx.writeAndFlush(Result.buildData(res));
        }

    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        log.debug("=== channelReadComplete ===");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.debug("=== exceptionCaught ===");
//        log.debug("excption", cause);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.debug("=== channelActive ===");
        log.debug("---" + ctx.toString());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.debug("=== channelActive ===");
        log.debug("---" + ctx.toString());
    }
}
