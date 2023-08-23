package com.zp.reactor.netty.demo01.tcp.client;

import reactor.core.publisher.Mono;
import reactor.netty.Connection;
import reactor.netty.tcp.TcpClient;
public class HelloWorld3 {

    public static void main(String[] args) {
        Connection connection =
                TcpClient.create()
                        .host("localhost")
                        .port(8080)
                        .handle((inbound, outbound) -> outbound.sendString(Mono.just("hello client")))
                        .connectNow();

        connection.onDispose()
                .block();
    }

}
