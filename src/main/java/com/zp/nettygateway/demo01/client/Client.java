package com.zp.nettygateway.demo01.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.HttpRequest;

public class Client {

    static private EventLoopGroup clientGroup;

    static public void init(EventLoopGroup group) {
        clientGroup = group;
    }

    static public void send(HttpRequest request, Channel serverChannel) throws InterruptedException{
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(clientGroup)
                .channel(NioSocketChannel.class)
                .handler(new ClientInitializer(serverChannel));
        Channel channel = bootstrap.connect("localhost", 8002).sync().channel();
        ChannelFuture channelFuture = channel.writeAndFlush(request);
        channelFuture.addListener(new ChannelFutureListener() {
            public void operationComplete(ChannelFuture future) throws Exception {
                if(future.isDone()){
                    if(future.isSuccess()){
                        System.out.println("执行成功...");
                    }else if(future.isCancelled()){
                        System.out.println("任务被取消...");
                    }else if(future.cause()!=null){
                        System.out.println("执行出错："+future.cause().getMessage());
                    }
                }
            }
        });
        channel.closeFuture().sync();
    }

}
