package com.zp.nettygateway.demo03.server;

import com.zp.nettygateway.demo03.client.Client;
import com.zp.nettygateway.demo03.route.RouteTable;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpUtil;

import java.util.Map;
import java.util.concurrent.ExecutionException;

import static io.netty.handler.codec.http.HttpHeaderNames.*;
import static io.netty.handler.codec.http.HttpHeaderValues.KEEP_ALIVE;
import static io.netty.handler.codec.http.HttpHeaderValues.*;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;

/**
 * @author lw
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 读取用户请求，调用client，发送请求到目标服务
     * @param ctx
     * @param msg
     * @throws InterruptedException
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws InterruptedException, ExecutionException {
        if (msg instanceof HttpRequest) {
            HttpRequest request = (HttpRequest) msg;
            showRequest(request);

            String source = request.uri();
            Map<String, String> target = RouteTable.getTarget(source);
//            System.out.println(target.toString());
            request.setUri(target.get("url"));
            String address = target.get("address");
            int port = Integer.parseInt(target.get("port"));

            String url = "http://" + address + ":" + port + target.get("url");

            boolean keepAlive = HttpUtil.isKeepAlive(request);
            FullHttpResponse response = new DefaultFullHttpResponse(request.protocolVersion(), OK,
                    Unpooled.wrappedBuffer(Client.getResponse(url)));

//            String s = cn.hutool.http.HttpUtil.get(url);
//            FullHttpResponse response = new DefaultFullHttpResponse(request.protocolVersion(), OK,
//                    Unpooled.wrappedBuffer(s.getBytes()));


            response.headers()
                    .set(CONTENT_TYPE, TEXT_PLAIN)
                    .setInt(CONTENT_LENGTH, response.content().readableBytes());

            if (keepAlive) {
                if (!request.protocolVersion().isKeepAliveDefault()) {
                    response.headers().set(CONNECTION, KEEP_ALIVE);
                }
            } else {
                // Tell the client we're going to close the connection.
                response.headers().set(CONNECTION, CLOSE);
            }

            ctx.channel().writeAndFlush(response).addListeners(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future) throws Exception {
                    if (future.isSuccess()) {
                        ctx.channel().read();
                    } else {
                        future.channel().close();
                    }
                }
            });
        }
    }

    private void showRequest(HttpRequest request) {
        System.out.println("show request" + request);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
