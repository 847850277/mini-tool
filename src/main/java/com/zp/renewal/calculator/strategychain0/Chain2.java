package com.zp.renewal.calculator.strategychain0;

/**
 * @author zhengpeng
 * @date 2022-04-02 16:34
 **/
public class Chain2 extends ChainHandler {


    public Chain2(CalculatorStrategy strategy) {
        super(strategy);
    }

    @Override
    protected boolean matchStrategy(CalculatorStrategy byContext) {
        return true;
    }


}
