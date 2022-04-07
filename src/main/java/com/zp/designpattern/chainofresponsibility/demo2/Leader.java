package com.zp.designpattern.chainofresponsibility.demo2;

/**
 * @author zhengpeng
 * @date 2022-04-02 15:17
 **/
public class Leader extends AbstractClerk{


    public Leader() {
        super.type = "组长";
    }
    @Override
    public int getLimit() {
        return 20000;
    }
}
