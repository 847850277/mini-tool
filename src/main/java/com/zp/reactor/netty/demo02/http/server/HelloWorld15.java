package com.zp.reactor.netty.demo02.http.server;
import java.net.InetSocketAddress;

import reactor.core.publisher.Mono;
import reactor.netty.DisposableServer;
import reactor.netty.http.server.HttpServer;
import reactor.netty.transport.AddressUtils;
public class HelloWorld15 {

    public static void main(String[] args) {
        DisposableServer server =
                HttpServer.create()
                        .forwarded((connectionInfo, request) -> {
                            String hostHeader = request.headers().get("X-Forwarded-Host");
                            if (hostHeader != null) {
                                String[] hosts = hostHeader.split(",", 2);
                                InetSocketAddress hostAddress = AddressUtils.createUnresolved(
                                        hosts[hosts.length - 1].trim(),
                                        connectionInfo.getHostAddress().getPort());
                                connectionInfo = connectionInfo.withHostAddress(hostAddress);
                            }
                            System.out.println(connectionInfo);
                            return connectionInfo;
                        })
                        .route(routes ->
                                routes.get("/clientip",
                                        (request, response) ->
                                                response.sendString(Mono.just(request.remoteAddress()
                                                        .getHostString()))))
                        .bindNow();

        server.onDispose()
                .block();
    }

}
