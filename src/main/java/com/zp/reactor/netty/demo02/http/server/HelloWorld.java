package com.zp.reactor.netty.demo02.http.server;
import reactor.netty.DisposableServer;
import reactor.netty.http.server.HttpServer;
public class HelloWorld {

    public static void main(String[] args) {
        DisposableServer server =
                HttpServer.create()
                        .bindNow();

        server.onDispose()
                .block();
    }

}
