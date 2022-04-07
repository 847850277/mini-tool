package com.zp.renewal.calculator.strategychain0;

/**
 * @author zhengpeng
 * @date 2022-04-02 16:31
 **/
public class CalculatorStrategy1 implements CalculatorStrategy {

    /**
     * 计算课时
     * @param param
     * @return
     */
    @Override
    public Object apply(Object param) {
        System.out.println("开始处理计算课时的逻辑");
        return 10;
    }
}
