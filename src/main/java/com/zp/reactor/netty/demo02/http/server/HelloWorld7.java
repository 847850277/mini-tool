package com.zp.reactor.netty.demo02.http.server;
import reactor.core.publisher.Mono;
import reactor.netty.DisposableServer;
import reactor.netty.http.server.HttpServer;
public class HelloWorld7 {

    public static void main(String[] args) {
        DisposableServer server =
                HttpServer.create()
                        .handle((request, response) -> response.sendString(Mono.just("hello")))
                        .bindNow();

        server.onDispose()
                .block();
    }

}
