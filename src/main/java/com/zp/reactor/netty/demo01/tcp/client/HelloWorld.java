package com.zp.reactor.netty.demo01.tcp.client;
import reactor.netty.Connection;
import reactor.netty.tcp.TcpClient;

public class HelloWorld {

    public static void main(String[] args) {

        /**  默认端口为12012

        Connection connection =
                TcpClient.create()
                        .connectNow();

        connection.onDispose()
                .block();
         */

        Connection connection =
                TcpClient.create()
                        .port(8080)
                        .host("localhost")
                        .connectNow();

        connection.onDispose()
                .block();
    }

}
