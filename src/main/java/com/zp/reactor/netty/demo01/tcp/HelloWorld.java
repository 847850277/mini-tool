package com.zp.reactor.netty.demo01.tcp;

import reactor.core.publisher.Mono;
import reactor.netty.DisposableServer;
import reactor.netty.tcp.TcpServer;
public class HelloWorld {

    public static void main(String[] args) {

        /*
        DisposableServer server =
                TcpServer.create()
                        .host("localhost")
                        .port(8080)
                        .bindNow();

        server.onDispose()
                .block();


         */

        TcpServer tcpServer = TcpServer.create();
        DisposableServer server1 = tcpServer
                .host("localhost")
                .port(8080)
                .bindNow();

        DisposableServer server2 = tcpServer
                .host("0.0.0.0")
                .port(8081)
                .bindNow();

        Mono.when(server1.onDispose(), server2.onDispose())
                .block();

    }

}
