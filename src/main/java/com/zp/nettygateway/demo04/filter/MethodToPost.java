package com.zp.nettygateway.demo04.filter;

import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpRequest;

/**
 * 将请求的method置为POST
 */
public class MethodToPost implements RequestFilter {

    /**
     * 设置Request的Method为POST
     * @param request 请求
     */
    @Override
    public void filter(HttpRequest request) {
        request.setMethod(HttpMethod.POST);
    }
}
