package xyz.stg.tcp.initializer;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import xyz.stg.tcp.handler.HttpServerHandler;

/**
 * Created by tiangao on 2016/5/21.
 */
public class HttpChannelInitializer extends ChannelInitializer<SocketChannel> {

    protected void initChannel(SocketChannel sc) throws Exception {
        // server端发送的是httpResponse，所以要使用HttpResponseEncoder进行编码
        sc.pipeline().addLast(new HttpResponseEncoder());
        // server端接收到的是httpRequest，所以要使用HttpRequestDecoder进行解码
        sc.pipeline().addLast(new HttpRequestDecoder());
        sc.pipeline().addLast(new HttpServerHandler());
    }
}
