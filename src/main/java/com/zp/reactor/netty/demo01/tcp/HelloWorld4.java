package com.zp.reactor.netty.demo01.tcp;

import reactor.netty.DisposableServer;
import reactor.netty.tcp.TcpServer;

public class HelloWorld4 {

    public static void main(String[] args) {
        DisposableServer server =
                TcpServer.create()
                        .handle((inbound, outbound) -> inbound.receive().then())
                        .bindNow();

        server.onDispose()
                .block();

    }

}
