package com.zp.renewal.calculator.strategychain0;

/**
 * @author zhengpeng
 * @date 2022-04-02 16:04
 * 策略
 **/
public interface CalculatorStrategy<T,R>  {



    /**
     * 执行策略
     * @param param
     * @return
     */
    R apply(T param);

}
