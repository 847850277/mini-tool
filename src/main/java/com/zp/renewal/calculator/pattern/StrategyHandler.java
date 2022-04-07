package com.zp.renewal.calculator.pattern;

/**
 * @author zhengpeng
 * @date 2022-04-01 17:10
 **/
public interface StrategyHandler<T,R> {

    @SuppressWarnings("rawtypes")
    StrategyHandler DEFAULT = t -> null;

    /**
     * apply strategy
     *
     * @param param
     * @return
     */
    R apply(T param);
}
