package com.zp.reactor.netty.demo01.tcp.client;
import reactor.netty.Connection;
import reactor.netty.tcp.TcpClient;
public class HelloWorld6 {

    public static void main(String[] args) {
        Connection connection =
                TcpClient.create()
                        .host("localhost")
                        .port(8080)
                        .connectNow();

        connection.inbound()
                .receive()
                .then()
                .subscribe();

        connection.onDispose()
                .block();
    }

}
