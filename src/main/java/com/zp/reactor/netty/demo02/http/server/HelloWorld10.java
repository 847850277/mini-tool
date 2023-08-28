package com.zp.reactor.netty.demo02.http.server;
import reactor.netty.DisposableServer;
import reactor.netty.http.server.HttpServer;
public class HelloWorld10 {

    public static void main(String[] args) {
        DisposableServer server =
                HttpServer.create()
                        .handle((request, response) -> request.receive().then())
                        .bindNow();

        server.onDispose()
                .block();
    }

}
