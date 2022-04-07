package com.zp.designpattern.strategy.demo1;

/**
 * @author zhengpeng
 * @date 2022-04-02 15:47
 **/
public class OperationSubtract implements Strategy {

    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}
