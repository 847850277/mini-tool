package com.zp.designpattern.chainofresponsibility.demo1;

/**
 * @author zhengpeng
 * @date 2022-04-02 14:59
 **/
public class Request {
    private Level level;

    public Request(Level level) {
        System.out.println("开始请求");
        this.level = level;
    }

    public Level getLevel(){
        return level;
    }
}
