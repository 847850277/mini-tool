package com.zp.reactor.netty.demo01.tcp;

import io.netty.channel.ChannelOption;
import reactor.netty.DisposableServer;
import reactor.netty.tcp.TcpServer;
public class HelloWorld6 {

    public static void main(String[] args) {
        DisposableServer server =
                TcpServer.create()
                        .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 10000)
                        .bindNow();

        server.onDispose()
                .block();
    }

}
