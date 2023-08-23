package com.zp.reactor.netty.demo01.tcp;

import reactor.netty.DisposableServer;
import reactor.netty.tcp.TcpServer;
public class HelloWorld7 {

    public static void main(String[] args) {
        DisposableServer server =
                TcpServer.create()
                        .wiretap(true)
                        .bindNow();

        server.onDispose()
                .block();
    }
}
