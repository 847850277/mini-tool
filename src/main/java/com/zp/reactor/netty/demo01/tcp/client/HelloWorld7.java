package com.zp.reactor.netty.demo01.tcp.client;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.ReadTimeoutHandler;
import reactor.netty.Connection;
import reactor.netty.tcp.TcpClient;
import java.util.concurrent.TimeUnit;
public class HelloWorld7 {

    public static void main(String[] args) {
        Connection connection =
                TcpClient.create()
                        .host("localhost")
                        .port(8080)
                        .doOnConnected(conn ->
                                conn.addHandlerFirst(new ReadTimeoutHandler(10, TimeUnit.SECONDS)))
                        .doOnChannelInit((observer, channel, remoteAddress) ->
                                channel.pipeline()
                                        .addFirst(new LoggingHandler("reactor.netty.examples")))
                        .connectNow();

        connection.onDispose()
                .block();
    }

}
