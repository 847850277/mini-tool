package com.zp.renewal.calculator.strategychain0;

/**
 * @author zhengpeng
 * @date 2022-04-02 16:32
 **/
public class App {

    public static void main(String[] args) {


        ChainHandler c1 = new Chain1(new CalculatorStrategy1());
        ChainHandler c2 = new Chain2(new CalculatorStrategy2());
        //c1.setNextHandler(c2);
        c1.handlerRequest(new CalculatorConText());
        c2.handlerRequest(new CalculatorConText());


    }
}
