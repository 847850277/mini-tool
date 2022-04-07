package com.zp.designpattern.strategy.demo2;

/**
 * @author zhengpeng
 * @date 2022-04-02 15:51
 **/
public class PaypalStrategy implements PaymentStrategy {

    private String emailId;
    private String password;

    public PaypalStrategy(String email, String pwd){
        this.emailId=email;
        this.password=pwd;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid using Paypal.");
    }
}
