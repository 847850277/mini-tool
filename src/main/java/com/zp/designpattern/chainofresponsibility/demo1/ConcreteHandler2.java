package com.zp.designpattern.chainofresponsibility.demo1;

/**
 * @author zhengpeng
 * @date 2022-04-02 15:06
 **/
public class ConcreteHandler2 extends Handler{

    @Override
    protected Level getHandlerLevel() {
        return new Level(2);
    }

    @Override
    public Response response(Request request) {
        System.out.println("该请求由 ConcreteHandler2 处理");
        return new Response("响应结果 2");
    }
}
