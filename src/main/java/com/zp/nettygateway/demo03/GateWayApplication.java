package com.zp.nettygateway.demo03;

import com.zp.nettygateway.demo03.server.Server;
import com.zp.nettygateway.demo03.util.Config;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;

public class GateWayApplication {

    public static void main(String[] args) throws Exception{

        System.out.println("init properties file");
        Config.init();

        int port = 8080;
        if (Config.getProperty("port") != null) {
            port = Integer.parseInt(Config.getProperty("port"));
        }

        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup serverGroup = new NioEventLoopGroup();
        EventLoopGroup clientGroup = new NioEventLoopGroup();

        try {
            Server.run(bossGroup, serverGroup, port);
        } finally {
            bossGroup.shutdownGracefully();
            serverGroup.shutdownGracefully();
            clientGroup.shutdownGracefully();
        }

    }

}
