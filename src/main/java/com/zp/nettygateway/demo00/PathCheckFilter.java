package com.zp.nettygateway.demo00;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

public class PathCheckFilter implements HttpRequestFilter{
    @Override
    public boolean filter(FullHttpRequest request, ChannelHandlerContext ctx) {
        String uri = request.uri();
        return uri.contains("hello");
        //return false;
    }
}
