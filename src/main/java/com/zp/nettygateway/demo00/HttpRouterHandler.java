package com.zp.nettygateway.demo00;

import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpUtil;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

@ChannelHandler.Sharable
public class HttpRouterHandler extends ChannelInboundHandlerAdapter {

    //private final HttpRouter router;

    //private final CloseableHttpAsyncClient httpClient;

    //private final ThreadPoolExecutor executorService;

    private static final int SUCCESS_CODE = 200;

    private static final int NUM_OF_CORE = Runtime.getRuntime().availableProcessors();

    private static final long KEEP_ALIVE = 8L;

    private static final int QUEUE_SIZE = 1024;

    public HttpRouterHandler(List<String> proxyServers) {


//        IOReactorConfig ioConfig = IOReactorConfig.custom()
//                .setConnectTimeout(1000)
//                .setSoTimeout(1000)
//                .setIoThreadCount(NUM_OF_CORE)
//                .setRcvBufSize(32 * 1024)
//                .build();
//
//        httpClient = HttpAsyncClients.custom().setMaxConnTotal(40)
//                .setMaxConnPerRoute(8).setDefaultIOReactorConfig(ioConfig)
//                .setKeepAliveStrategy(((httpResponse, httpContext) -> 6000)).build();
//
//        httpClient.start();
//
//        this.executorService = new ThreadPoolExecutor(NUM_OF_CORE, NUM_OF_CORE, KEEP_ALIVE, TimeUnit.SECONDS,
//                new ArrayBlockingQueue<>(QUEUE_SIZE), new ThreadPoolExecutor.CallerRunsPolicy());
//        this.router = new RoundRobinRouter(proxyServers);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String host = null;//TODO fixme this.router.route();
        FullHttpRequest request = (FullHttpRequest) msg;
        String url = host + request.uri();
        //this.executorService.submit(() -> executeAndWrite(request, ctx, url));
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    /**
     * 调用并返回
     *
     * @param url
     */
    private void executeAndWrite(FullHttpRequest request, ChannelHandlerContext ctx, String url) {
        /*
        final HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
        this.httpClient.execute(httpGet, new FutureCallback<HttpResponse>() {
            @Override
            public void completed(HttpResponse httpResponse) {
                try {
                    writeResp(httpResponse, request, ctx);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(Exception e) {
                httpGet.abort();
                FullHttpResponse resp = HttpNettyHelper.genFailedResp();
                ctx.writeAndFlush(resp);
                e.printStackTrace();
            }

            @Override
            public void cancelled() {
                httpGet.abort();
            }
        });
         */
    }

    private void writeResp(HttpResponse response, FullHttpRequest request, ChannelHandlerContext ctx) {
        /*
        FullHttpResponse resp = null;
        try {
            if (response.getStatusLine().getStatusCode() == SUCCESS_CODE) {
                byte[] bytes = EntityUtils.toByteArray(response.getEntity());
                resp = HttpNettyHelper.genBaseResp(bytes);
            } else {
                resp = HttpNettyHelper.genFailedResp();
            }
        } catch (IOException e) {
            e.printStackTrace();
            resp = HttpNettyHelper.genFailedResp();
        } finally {
            if (request != null) {
                if (!HttpUtil.isKeepAlive(request)) {
                    ctx.write(resp).addListener(ChannelFutureListener.CLOSE);
                } else {
                    ctx.write(resp);
                }
            }
            ctx.flush();
        }
    }
         */
    }
}