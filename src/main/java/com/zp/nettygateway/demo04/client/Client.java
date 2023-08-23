package com.zp.nettygateway.demo04.client;

import io.netty.channel.Channel;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;

public interface Client {

    /**
     * 将请求转发到后端服务，然后获取响应
     * @param request
     * @param address
     * @param port
     * @param serverOutBound
     * @return
     */
    FullHttpResponse execute(FullHttpRequest request, String address, int port, Channel serverOutBound);

}
