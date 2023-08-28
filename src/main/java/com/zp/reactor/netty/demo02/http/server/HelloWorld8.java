package com.zp.reactor.netty.demo02.http.server;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpResponseStatus;
import reactor.core.publisher.Mono;
import reactor.netty.DisposableServer;
import reactor.netty.http.server.HttpServer;
public class HelloWorld8 {

    public static void main(String[] args) {
        DisposableServer server =
                HttpServer.create()
                        .route(routes ->
                                routes.get("/hello",
                                        (request, response) ->
                                                response.status(HttpResponseStatus.OK)
                                                        .header(HttpHeaderNames.CONTENT_LENGTH, "12")
                                                        .sendString(Mono.just("Hello World!"))))
                        .bindNow();

        server.onDispose()
                .block();
    }

}
