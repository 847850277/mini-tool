package com.zp.nettygateway.demo04.filter;

import io.netty.handler.codec.http.HttpRequest;

/**
 */
public interface RequestFilter {

    /**
     * 对请求进行处理
     * @param request 请求
     */
    void filter(HttpRequest request);
}
