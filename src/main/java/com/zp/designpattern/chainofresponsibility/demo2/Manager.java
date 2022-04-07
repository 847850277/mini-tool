package com.zp.designpattern.chainofresponsibility.demo2;

/**
 * @author zhengpeng
 * @date 2022-04-02 15:18
 **/
public class Manager extends AbstractClerk {

    public Manager() {
        super.type = "经理";
    }

    @Override
    public int getLimit() {
        return 100000;
    }
}
