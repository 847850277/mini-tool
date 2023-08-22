package com.zp.nettygateway.demo00;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

public interface HttpRequestFilter {

    boolean filter(FullHttpRequest request, ChannelHandlerContext ctx);

}
