package com.zp.designpattern.chainofresponsibility.demo2;

/**
 * @author zhengpeng
 * @date 2022-04-02 15:11
 **/
public class BorrowRequest {

    private int requestMoney;

    public BorrowRequest(int requestMoney) {
        System.out.println("有新请求，需要借款" + requestMoney + "元");
        this.requestMoney = requestMoney;
    }

    public int getRequestMoney() {
        return requestMoney;
    }
}
