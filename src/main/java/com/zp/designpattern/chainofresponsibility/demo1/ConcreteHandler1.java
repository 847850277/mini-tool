package com.zp.designpattern.chainofresponsibility.demo1;

/**
 * @author zhengpeng
 * @date 2022-04-02 15:05
 **/
public class ConcreteHandler1 extends Handler {

    @Override
    protected Level getHandlerLevel() {
        return new Level(1);
    }

    @Override
    public Response response(Request request) {
        System.out.println("该请求由 ConcreteHandler1 处理");
        return new Response("响应结果 1");
    }
}
