package xyz.stg.tcp.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by tiangao on 2016/5/22.
 */
public class GameServerHandler extends ChannelInboundHandlerAdapter{
    private static final Logger log = LoggerFactory.getLogger(GameServerHandler.class);

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        log.debug("=============== channelRegistered ==============");
        log.debug("---" + ctx.toString());
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        log.debug("=============== channelUnregistered ==============");
        log.debug("---" + ctx.toString());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        log.debug("=============== channelRead ==============");
        log.debug("---" + ctx.toString());
        log.debug("---" + msg.toString());
//        if (msg instanceof String) {
//            log.debug("String:" + msg);
//        }
        ctx.writeAndFlush("server收到: " + msg);

    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {

        log.debug("=============== channelReadComplete ==============");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.debug("=============== exceptionCaught ==============");
//        log.debug("excption", cause);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.debug("=============== channelActive ==============");
        log.debug("---" + ctx.toString());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.debug("=============== channelActive ==============");
        log.debug("---" + ctx.toString());
    }
}
