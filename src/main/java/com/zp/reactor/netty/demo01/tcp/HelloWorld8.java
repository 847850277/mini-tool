package com.zp.reactor.netty.demo01.tcp;

import reactor.netty.DisposableServer;
import reactor.netty.resources.LoopResources;
import reactor.netty.tcp.TcpServer;
public class HelloWorld8 {

    public static void main(String[] args) {
        LoopResources loop = LoopResources.create("event-loop", 1, 4, true);

        DisposableServer server =
                TcpServer.create()
                        .runOn(loop)
                        .bindNow();

        server.onDispose()
                .block();
    }
}
