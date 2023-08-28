package com.zp.reactor.netty.demo02.http.server;
import reactor.core.publisher.Mono;
import reactor.netty.DisposableServer;
import reactor.netty.http.server.HttpServer;
public class HelloWorld14 {

    public static void main(String[] args) {
        DisposableServer server =
                HttpServer.create()
                        .forwarded(true)
                        .route(routes ->
                                routes.get("/clientip",
                                        (request, response) ->
                                                response.sendString(Mono.just(request.remoteAddress()
                                                        .getHostString()))))
                        .bindNow();

        server.onDispose()
                .block();
    }

}
