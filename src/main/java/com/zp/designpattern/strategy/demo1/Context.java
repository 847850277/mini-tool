package com.zp.designpattern.strategy.demo1;

/**
 * @author zhengpeng
 * @date 2022-04-02 15:47
 **/
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public int executeStrategy(int num1,int num2){
        return strategy.doOperation(num1,num2);
    }

}
