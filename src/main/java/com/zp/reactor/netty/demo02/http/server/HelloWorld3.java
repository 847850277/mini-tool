package com.zp.reactor.netty.demo02.http.server;
import reactor.netty.DisposableServer;
import reactor.netty.http.server.HttpServer;
public class HelloWorld3 {

    public static void main(String[] args) {

        HttpServer httpServer =
                HttpServer.create()
                        .handle((request, response) -> request.receive().then());

        httpServer.warmup()
                .block();

        DisposableServer server = httpServer.bindNow();

        server.onDispose()
                .block();
    }


}
