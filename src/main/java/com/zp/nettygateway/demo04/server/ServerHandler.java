package com.zp.nettygateway.demo04.server;

import com.zp.nettygateway.demo04.client.ClientInstance;
import com.zp.nettygateway.demo04.common.CreateRequest;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;

public class ServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest request) throws Exception {
        // 传入server outbound,在客户端中执行获取结果后，直接写回
        ClientInstance.getInstance().execute(CreateRequest.create(request), ctx.channel());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
