package com.zp.renewal.calculator.pattern;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * @author zhengpeng
 * @date 2022-04-01 17:08
 **/
public abstract class AbstractStrategyRouter<T,R> {

    /**
     * 策略映射器，根据指定的如餐路由到对应的策略处理者
     * @param <T>
     * @param <R>
     */
    public interface StrategyMapper<T,R>{
        /**
         * 根据如餐获取到对应的策略处理者，可通过if-else实现，也可以通过Map实现
         * @param param
         * @return
         */
        StrategyHandler<T,R> get(T param);
    }

    private StrategyMapper<T,R> strategyMapper;

    /**
     * 类初始化时注册分发策略 Mapper
     */
    private void abstractInit() {
        strategyMapper = registerStrategyMapper();
        Objects.requireNonNull(strategyMapper, "strategyMapper cannot be null");
    }

    @Getter
    @Setter
    @SuppressWarnings("unchecked")
    private StrategyHandler<T, R> defaultStrategyHandler = StrategyHandler.DEFAULT;

    /**
     * 执行策略，框架会自动根据策略分发至下游的 Handler 进行处理
     *
     * @param param 入参
     * @return 下游执行者给出的返回值
     */
    public R applyStrategy(T param) {
        final StrategyHandler<T, R> strategyHandler = strategyMapper.get(param);
        if (strategyHandler != null) {
            return strategyHandler.apply(param);
        }

        return defaultStrategyHandler.apply(param);
    }


    /**
     * 抽象方法，需要子类实现策略的分发逻辑
     * @return
     */
    protected abstract StrategyMapper<T,R> registerStrategyMapper();


}
