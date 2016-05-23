package xyz.stg.tcp.initializer;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import xyz.stg.tcp.handler.GameServerHandler;

/**
 * Created by tiangao on 2016/5/22.
 */
public class GameChannelInitializer extends ChannelInitializer<SocketChannel>{

    protected void initChannel(SocketChannel sc) throws Exception {
        sc.pipeline().addLast(new StringDecoder()).addLast(new StringEncoder()).addLast(new GameServerHandler());
    }
}
