package com.zp.renewal.calculator.strategychain0;

/**
 * @author zhengpeng
 * @date 2022-04-02 16:06
 * 链条处理器
 **/
public abstract class ChainHandler<T,R> {

    private ChainHandler nextHandler = null;

    /**
     * 当前策略
     */
    private CalculatorStrategy strategy = null;

    /**
     * 设置下一级处理
     * @param handler
     */
    public void setNextHandler(ChainHandler handler){
        nextHandler = handler;
    }

    public ChainHandler(CalculatorStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 判断，并且处理
     * @param context
     * @return
     */
    public final R handlerRequest(CalculatorConText context){
        R r = null;
        if (matchStrategy(strategy)) {
            r = (R) strategy.apply(context);
        } else {
            if (nextHandler != null) {
                r = (R) this.nextHandler.handlerRequest(context);
            } else {
                System.out.println("没有找到合适的处理器处理该请求");
            }
        }
        // 不满足，交给下一个策略处理
        return r;
    }

    /**
     * 匹配策略
     * @param byContext
     * @return
     */
    protected abstract boolean matchStrategy(CalculatorStrategy byContext);

}
