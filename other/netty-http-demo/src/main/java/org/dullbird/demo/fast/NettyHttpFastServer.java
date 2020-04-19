package org.dullbird.demo.fast;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * 快速返回的http请求。不管客户顿传什么。
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年04月17日 09:20:00
 */
public class NettyHttpFastServer {


    public static void start(final int port) throws Exception {
        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup woker = new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap();

        try {

            serverBootstrap.channel(NioServerSocketChannel.class)
                    .group(boss, woker)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast("http-decoder",new HttpServerCodec());
                            ch.pipeline().addLast(new HttpServerFastHandler());
                        }
                    });

            ChannelFuture future = serverBootstrap.bind(port).sync();
            System.out.printf("===============netty server===========port:%s\n", port);
            future.channel().closeFuture().sync();
        } finally {
            boss.shutdownGracefully();
            woker.shutdownGracefully();
        }
    }
    public static void main(String[] args) throws Exception {
        start(8080);
    }
}
