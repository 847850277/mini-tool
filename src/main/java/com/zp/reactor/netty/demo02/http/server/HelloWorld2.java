package com.zp.reactor.netty.demo02.http.server;
import reactor.core.publisher.Mono;
import reactor.netty.DisposableServer;
import reactor.netty.http.server.HttpServer;
public class HelloWorld2 {

    public static void main(String[] args) {
        HttpServer httpServer = HttpServer.create();
        DisposableServer server1 = httpServer
                .host("localhost")
                .port(8080)
                .bindNow();

        DisposableServer server2 = httpServer
                .host("0.0.0.0")
                .port(8081)
                .bindNow();

        Mono.when(server1.onDispose(), server2.onDispose())
                .block();
    }

}
