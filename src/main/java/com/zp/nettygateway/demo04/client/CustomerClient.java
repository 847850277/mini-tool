package com.zp.nettygateway.demo04.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

public class CustomerClient implements Client{

    private ConcurrentHashMap<Channel,Channel> channelPool = new ConcurrentHashMap<>();

    private EventLoopGroup clientGroup;

    public CustomerClient(EventLoopGroup clientGroup) {
        this.clientGroup = clientGroup;
    }

    @Override
    public FullHttpResponse execute(FullHttpRequest request, String address, int port, Channel serverOutBound) {
        try {
            return getResponse(address,port,request,serverOutBound);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private FullHttpResponse getResponse(String address, int port, FullHttpRequest request, Channel serverChannel) throws InterruptedException {

        //缓存中获取
        if(channelPool.contains(serverChannel)){
            Channel channel = channelPool.get(channelPool);
            if (!channel.isActive() || !channel.isWritable() || !channel.isOpen()) {
                System.out.println("Channel can't reuse");
            }else {
                try{
                    channel.pipeline().removeLast();
                    CustomClientAsyncHandler handler = new CustomClientAsyncHandler();
                    handler.setLatch(new CountDownLatch(1));
                    channel.pipeline().addLast("clientHandler", handler);
                    channel.writeAndFlush(request.retain()).sync();
                    return handler.getResponse();
                }catch (Exception e){
                    System.out.println("channel reuse send msg failed!");
                    channel.close();
                    channelPool.remove(serverChannel);
                    e.printStackTrace();
                }
                System.out.println("Handler is busy, please user new channel");
            }
        }

        CustomClientAsyncHandler handler = new CustomClientAsyncHandler();
        handler.setLatch(new CountDownLatch(1));
        Channel channel = createChannel(address, port);
        channel.pipeline().addLast("clientHandler", handler);
        channelPool.put(serverChannel, channel);
        channel.writeAndFlush(request).sync();
        return handler.getResponse();

    }

    private Channel createChannel(String address, int port) throws InterruptedException {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(clientGroup)
                .option(ChannelOption.SO_REUSEADDR, true)
                .option(ChannelOption.TCP_NODELAY, true)
                .option(ChannelOption.AUTO_CLOSE, true)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .channel(NioSocketChannel.class)
                .handler(new CustomClientAsyncInitializer());
        return bootstrap.connect(address, port).sync().channel();
    }
}
