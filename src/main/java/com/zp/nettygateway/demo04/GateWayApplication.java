package com.zp.nettygateway.demo04;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.zp.nettygateway.demo04.server.Server;
import com.zp.nettygateway.demo04.client.ClientInstance;
import com.zp.nettygateway.demo04.common.Constant;
import com.zp.nettygateway.demo04.common.ThreadInfo;
import com.zp.nettygateway.demo04.filter.Filter;
import com.zp.nettygateway.demo04.route.RouteTable;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;

import java.util.concurrent.ThreadFactory;

public class GateWayApplication {


    public static void main(String[] args) throws InterruptedException {
//        ThreadInfo threadInfo = new ThreadInfo();
//        threadInfo.start();

        // init listen port
        int port = 8080;

        // init route table config
        RouteTable.initTable();

        // 初始化请求和返回的过滤器
        Filter.initRequestFilter();
        Filter.initResponseFilter();

        // 初始化Server,Client 这里对线程池进行统一关闭
        ThreadFactory serverBoos = new ThreadFactoryBuilder().setNameFormat("server boos-%d").build();
        ThreadFactory serverWork = new ThreadFactoryBuilder().setNameFormat("server work-%d").build();
        ThreadFactory clientWork = new ThreadFactoryBuilder().setNameFormat("client work-%d").build();

        EventLoopGroup bossGroup = new NioEventLoopGroup(1, serverBoos);
        EventLoopGroup serverGroup = new NioEventLoopGroup(serverWork);
        EventLoopGroup clientGroup = new NioEventLoopGroup(clientWork);

        try {
            // 使用自定义第三方客户端
            ClientInstance.getInstance().init(Constant.CUSTOM_CLIENT_ASYNC, clientGroup);
            //ClientInstance.getInstance().init(Constant.THIRD_CLIENT_ASYNC, clientGroup);

            // 使用第三方客户端
//            ClientCenter.getInstance().init(THIRD_CLIENT_ASYNC, clientGroup);

            Server.run(bossGroup, serverGroup, port);
        } finally {
            bossGroup.shutdownGracefully();
            serverGroup.shutdownGracefully();
            clientGroup.shutdownGracefully();
        }
    }

}
