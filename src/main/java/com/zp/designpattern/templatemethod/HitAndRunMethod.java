package com.zp.designpattern.templatemethod;

import com.oracle.tools.packager.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhengpeng
 * @date 2022/12/23 4:50 下午
 **/
public class HitAndRunMethod extends StealingMethod{

    private static final Logger LOG = LoggerFactory.getLogger(HitAndRunMethod.class);


    @Override
    protected String pickTarget() {
        return "old goblin woman";
    }

    @Override
    protected void consfuseTarget(String target) {
        LOG.info("approach ths {} from behind.",target);
    }

    @Override
    protected void stealTheItem(String target) {
        LOG.info("Grab the handbag and run away fast!");
    }
}
