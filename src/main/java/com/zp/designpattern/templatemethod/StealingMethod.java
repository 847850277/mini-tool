package com.zp.designpattern.templatemethod;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhengpeng
 * @date 2022/12/23 4:39 下午
 **/
public abstract class StealingMethod {

    private static final Logger LOGGER = LoggerFactory.getLogger(StealingMethod.class);

    protected abstract String pickTarget();

    protected abstract void consfuseTarget(String target);

    protected abstract void stealTheItem(String target);

    public void steal(){
        String target = pickTarget();
        LOGGER.info("the target has bean chose as {}.",target);
        consfuseTarget(target);
        stealTheItem(target);
    }

}
