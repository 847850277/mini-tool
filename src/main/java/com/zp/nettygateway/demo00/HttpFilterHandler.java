package com.zp.nettygateway.demo00;

import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.util.ReferenceCountUtil;

public class HttpFilterHandler extends ChannelInboundHandlerAdapter {

    private final HttpFilterChain filterChain;

    public HttpFilterHandler(HttpFilterChain filterChain) {
        this.filterChain = filterChain;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        FullHttpRequest fullHttpRequest = (FullHttpRequest) msg;
        try {
            if (doFilter(fullHttpRequest, ctx)) {
                ctx.fireChannelRead(msg);
            } else {
                DefaultFullHttpResponse unAuthResp = null ;//TODO fixme = HttpNettyHelper.genUnAuthResp();
                if (!HttpUtil.isKeepAlive(fullHttpRequest)) {
                    ctx.writeAndFlush(unAuthResp).addListener(ChannelFutureListener.CLOSE);
                } else {
                    unAuthResp.headers().set(HttpHeaderNames.CONNECTION, HttpHeaderNames.KEEP_ALIVE);
                    ctx.writeAndFlush(unAuthResp);
                }
            }
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    /**
     * 执行过滤链
     * @param request
     * @return
     */
    private boolean doFilter(FullHttpRequest request, ChannelHandlerContext ctx) {
        for (HttpRequestFilter filter : this.filterChain.getFilters()) {
            if (!filter.filter(request, ctx)) {
                return false;
            }
        }
        return true;
    }
}
