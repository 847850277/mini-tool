package com.zp.designpattern.chainofresponsibility.demo1;

/**
 * @author zhengpeng
 * @date 2022-04-02 15:01
 **/
public class Response {
    private String message;
    public Response(String message) {
        System.out.println("处理完请求");
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}
