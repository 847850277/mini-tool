package com.zp.nettygateway.demo04.client;

import com.zp.nettygateway.demo04.common.Constant;
import com.zp.nettygateway.demo04.common.CreatResponse;
import com.zp.nettygateway.demo04.filter.Filter;
import com.zp.nettygateway.demo04.route.RouteTable;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;

import java.net.URI;
import java.net.URISyntaxException;

public class ClientInstance {

    private enum EnumSingleton {
        /**
         * 懒汉枚举单例
         */
        INSTANCE;
        private ClientInstance instance;

        EnumSingleton(){
            instance = new ClientInstance();
        }
        public ClientInstance getSingleton(){
            return instance;
        }
    }

    public static ClientInstance getInstance(){
        return EnumSingleton.INSTANCE.getSingleton();
    }

    private Client client;

    private String name;

    public void init(String clientType, EventLoopGroup clientGroup) {
        System.out.println("test name::" + name);
        if (Constant.THIRD_CLIENT_ASYNC.equals(clientType)) {
            client = new ThirdClient();
        } else {
            client = new CustomerClient(clientGroup);
        }
        System.out.println("Select client type: " + clientType);
    }

    public void execute(FullHttpRequest request, Channel serverOutbound){
        // 路由转发处理,负载均衡
        String source = request.uri();
        String target = RouteTable.getTargetUrl(source);
        if (target == null) {
            System.out.println("url: " + source + " can't find in route");
            try {
                serverOutbound.writeAndFlush(CreatResponse.creat404(request)).sync();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("return 404 failed");
            }
            return;
        }

        URI uri = null;
        try {
            uri = new URI(target);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return;
        }

        String address = uri.getHost();
        int port = uri.getPort();
        request.setUri(uri.getPath());

        // 请求过滤处理
//        Filter.requestProcess(request);

        FullHttpResponse response = client.execute(request, address, port, serverOutbound);
        if (response == null) {
            System.out.println("backend server return null");
        }

        // 相应过滤处理
        Filter.responseProcess(response);

        // 返回Response数据给用户
        try {
            serverOutbound.writeAndFlush(response).sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
