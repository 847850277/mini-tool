package com.zp.designpattern.chainofresponsibility.demo2;

/**
 * @author zhengpeng
 * @date 2022-04-02 15:18
 **/
public class App {


    public static void main(String[] args) {
        AbstractClerk clerk = new Clerk();
        AbstractClerk leader = new Leader();
        AbstractClerk manager = new Manager();

        clerk.setSuperior(leader);
        leader.setSuperior(manager);

        //有人借款 10000 元
        clerk.approveRequest(new BorrowRequest(10000));

        //有人借款 111000 元
        clerk.approveRequest(new BorrowRequest(111000));

        //================================//
        // 添加老板这种角色，并且额度设置得更高
        System.out.println("=======================================");
        AbstractClerk boss = new Boss();
        manager.setSuperior(boss);
        clerk.approveRequest(new BorrowRequest(111000));


    }

}
