package xyz.stg.tcp.initializer;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import xyz.stg.tcp.handler.TimeServerHandler;

/**
 * Created by tiangao on 2016/5/21.
 */
public class TimeChannelInitializer  extends ChannelInitializer<SocketChannel> {

    protected void initChannel(SocketChannel sc) throws Exception {
        sc.pipeline().addLast(new TimeServerHandler());
    }
}
