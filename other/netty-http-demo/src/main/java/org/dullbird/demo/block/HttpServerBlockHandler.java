package org.dullbird.demo.block;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年04月17日 09:21:00
 */
public class HttpServerBlockHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        InetSocketAddress insocket = (InetSocketAddress) ctx.channel().remoteAddress();
        String clientIP = insocket.getAddress().getHostAddress();
        String clientPort = String.valueOf(insocket.getPort());
        System.out.println(clientIP);
        System.out.println(clientPort);
        if (msg instanceof HttpRequest) {
            System.out.println("接收到消息，但是我什么也不做！！！");
            Thread.sleep(100000000);
            System.out.println("我睡完了，直接结束");
        }
    }
}
