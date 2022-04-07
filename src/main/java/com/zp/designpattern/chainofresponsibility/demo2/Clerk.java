package com.zp.designpattern.chainofresponsibility.demo2;

/**
 * @author zhengpeng
 * @date 2022-04-02 15:17
 **/
public class Clerk extends AbstractClerk {

    public Clerk() {
        super.type = "职员";
    }

    @Override
    public int getLimit() {
        return 5000;
    }
}
