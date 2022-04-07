package com.zp.designpattern.chainofresponsibility.demo2;

/**
 * @author zhengpeng
 * @date 2022-04-02 15:21
 **/
public class Boss extends AbstractClerk {
    public Boss() {
        super.type = "老版";
    }
    @Override
    public int getLimit() {
        return 1000000;
    }
}
