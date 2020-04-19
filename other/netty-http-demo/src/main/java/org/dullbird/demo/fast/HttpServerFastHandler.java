package org.dullbird.demo.fast;

import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.*;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年04月17日 09:21:00
 */
public class HttpServerFastHandler extends ChannelInboundHandlerAdapter {

    private AtomicInteger count = new AtomicInteger(0);
//    25287 25298 25287
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        InetSocketAddress insocket = (InetSocketAddress) ctx.channel().remoteAddress();
        String clientIP = insocket.getAddress().getHostAddress();
        String clientPort = String.valueOf(insocket.getPort());
        System.out.println(clientIP);
        System.out.println(clientPort);
        int andIncrement = count.getAndIncrement();
        System.out.println(andIncrement);
        if (msg instanceof HttpRequest) {
            FullHttpResponse httpResponse = new DefaultFullHttpResponse(
                    HttpVersion.HTTP_1_1, HttpResponseStatus.OK);
            httpResponse.content().writeBytes("query success".getBytes());
            /**
             * 延迟。模拟服务端阻塞
             */
            Thread.sleep(5000L);
//            if (Objects.equals(25286, andIncrement)){
//                Thread.sleep(10000L);
//            }
            httpResponse.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/html;charset=UTF-8");
            httpResponse.headers().setInt(HttpHeaderNames.CONTENT_LENGTH, httpResponse.content().readableBytes());
            ctx.writeAndFlush(httpResponse);
        }
    }
}
