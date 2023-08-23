package com.zp.reactor.netty.demo01.tcp.client;
import reactor.core.publisher.Mono;
import reactor.netty.Connection;
import reactor.netty.tcp.TcpClient;
public class HelloWorld4 {

    public static void main(String[] args) {
        Connection connection =
                TcpClient.create()
                        .host("localhost")
                        .port(8080)
                        .connectNow();

        connection.outbound()
                .sendString(Mono.just("hello 1"))
                .then()
                .subscribe();

        connection.outbound()
                .sendString(Mono.just("hello 2"))
                .then()
                .subscribe(null, null, connection::dispose);

        connection.onDispose()
                .block();
    }

}
