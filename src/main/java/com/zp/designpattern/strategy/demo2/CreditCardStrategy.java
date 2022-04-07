package com.zp.designpattern.strategy.demo2;

/**
 * @author zhengpeng
 * @date 2022-04-02 15:50
 **/
public class CreditCardStrategy implements PaymentStrategy {

    private String name;
    private String cardNumber;
    private String cvv;
    private String dateOfExpiry;

    public CreditCardStrategy(String nm, String ccNum, String cvv, String expiryDate){
        this.name=nm;
        this.cardNumber=ccNum;
        this.cvv=cvv;
        this.dateOfExpiry=expiryDate;
    }


    @Override
    public void pay(int amount) {
        System.out.println(amount +" paid with credit/debit card");
    }
}
