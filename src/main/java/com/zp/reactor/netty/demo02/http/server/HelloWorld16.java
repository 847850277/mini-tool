package com.zp.reactor.netty.demo02.http.server;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.ReadTimeoutHandler;
import reactor.netty.DisposableServer;
import reactor.netty.http.server.HttpServer;
import java.util.concurrent.TimeUnit;
public class HelloWorld16 {

    public static void main(String[] args) {
        DisposableServer server =
                HttpServer.create()
                        .doOnConnection(conn ->
                                conn.addHandlerFirst(new ReadTimeoutHandler(10, TimeUnit.SECONDS)))
                        .doOnChannelInit((observer, channel, remoteAddress) ->
                                channel.pipeline()
                                        .addFirst(new LoggingHandler("reactor.netty.examples")))
                        .bindNow();

        server.onDispose()
                .block();
    }

}
