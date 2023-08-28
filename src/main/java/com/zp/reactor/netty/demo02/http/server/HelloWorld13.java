package com.zp.reactor.netty.demo02.http.server;
import reactor.core.publisher.Mono;
import reactor.netty.DisposableServer;
import reactor.netty.http.server.HttpServer;
public class HelloWorld13 {

    public static void main(String[] args) {
        DisposableServer server =
                HttpServer.create()
                        .httpFormDecoder(builder -> builder.maxInMemorySize(0))
                        .route(routes ->
                                routes.post("/multipart", (request, response) -> response.sendString(
                                        request.receiveForm(builder -> builder.maxInMemorySize(256))
                                                .flatMap(data -> Mono.just('[' + data.getName() + ']')))))
                        .bindNow();

        server.onDispose()
                .block();
    }

}
