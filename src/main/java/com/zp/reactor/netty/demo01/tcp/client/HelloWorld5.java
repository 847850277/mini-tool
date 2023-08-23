package com.zp.reactor.netty.demo01.tcp.client;
import reactor.netty.Connection;
import reactor.netty.tcp.TcpClient;
public class HelloWorld5 {

    public static void main(String[] args) {
        Connection connection =
                TcpClient.create()
                        .host("localhost")
                        .port(8080)
                        .handle((inbound, outbound) -> inbound.receive().then())
                        .connectNow();

        connection.onDispose()
                .block();


    }

}
