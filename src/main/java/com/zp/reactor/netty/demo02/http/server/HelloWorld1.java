package com.zp.reactor.netty.demo02.http.server;
import reactor.netty.DisposableServer;
import reactor.netty.http.server.HttpServer;
public class HelloWorld1 {

    public static void main(String[] args) {
        DisposableServer server =
                HttpServer.create()
                        .host("localhost")
                        .port(8080)
                        .bindNow();

        server.onDispose()
                .block();
    }

}
