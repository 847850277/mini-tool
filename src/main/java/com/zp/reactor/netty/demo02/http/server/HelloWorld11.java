package com.zp.reactor.netty.demo02.http.server;
import reactor.core.publisher.Mono;
import reactor.netty.DisposableServer;
import reactor.netty.http.server.HttpServer;

public class HelloWorld11 {

    public static void main(String[] args) {
        DisposableServer server =
                HttpServer.create()
                        .route(routes ->
                                routes.get("/{param}",
                                        (request, response) -> {
                                            if (request.requestHeaders().contains("Some-Header")) {
                                                return response.sendString(Mono.just(request.param("param")));
                                            }
                                            return response.sendNotFound();
                                        }))
                        .bindNow();

        server.onDispose()
                .block();
    }

}
