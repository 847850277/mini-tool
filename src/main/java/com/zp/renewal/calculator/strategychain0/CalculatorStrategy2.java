package com.zp.renewal.calculator.strategychain0;

import java.math.BigDecimal;

/**
 * @author zhengpeng
 * @date 2022-04-02 16:31
 **/
public class CalculatorStrategy2 implements CalculatorStrategy {

    /**
     * 计算单价
     * @param param
     * @return
     */
    @Override
    public Object apply(Object param) {

        System.out.println("开始处理计算单价的逻辑");

        return new BigDecimal("20");
    }
}
