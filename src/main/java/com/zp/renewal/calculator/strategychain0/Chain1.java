package com.zp.renewal.calculator.strategychain0;

/**
 * @author zhengpeng
 * @date 2022-04-02 16:33
 **/
public class Chain1 extends ChainHandler {


    public Chain1(CalculatorStrategy strategy) {
        super(strategy);
    }

    @Override
    protected boolean matchStrategy(CalculatorStrategy byContext) {
        return true;
    }

}
