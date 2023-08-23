package com.zp.reactor.netty.demo01.tcp;
import reactor.core.publisher.Mono;
import reactor.netty.DisposableServer;
import reactor.netty.tcp.TcpServer;
public class HelloWorld3 {

    public static void main(String[] args) {
        DisposableServer server =
                TcpServer.create()
                        .port(8080)
                        .host("localhost")
                        .handle((inbound, outbound) -> outbound.sendString(Mono.just("hello server")))
                        .bindNow();

        server.onDispose()
                .block();
    }

}
