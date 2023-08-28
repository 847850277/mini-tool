package com.zp.reactor.netty.demo02.http.server;
import reactor.netty.DisposableServer;
import reactor.netty.http.server.HttpServer;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
public class HelloWorld9 {

    public static void main(String[] args) throws URISyntaxException {
        Path file = Paths.get(HelloWorld9.class.getResource("/logback.xml").toURI());
        DisposableServer server =
                HttpServer.create()
                        .compress(true)
                        .route(routes -> routes.file("/index.html", file))
                        .bindNow();

        server.onDispose()
                .block();
    }

}
