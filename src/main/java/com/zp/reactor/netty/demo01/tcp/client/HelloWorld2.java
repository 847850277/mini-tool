package com.zp.reactor.netty.demo01.tcp.client;
import reactor.core.publisher.Mono;
import reactor.netty.Connection;
import reactor.netty.tcp.TcpClient;

public class HelloWorld2 {

    public static void main(String[] args) {
        TcpClient tcpClient =
                TcpClient.create()
                        .host("localhost")
                        .port(8080)
                        .handle((inbound, outbound) -> outbound.sendString(Mono.just("hello client")));

        tcpClient.warmup()
                .block();

        Connection connection = tcpClient.connectNow();

        connection.onDispose()
                .block();
    }

}
