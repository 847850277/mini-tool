package com.zp.designpattern.strategy.demo1;

/**
 * @author zhengpeng
 * @date 2022-04-02 15:46
 **/
public class OperationAdd implements Strategy {

    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}
