package com.zp.designpattern.templatemethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhengpeng
 * @date 2022/12/23 4:47 下午
 **/
public class SubtleMethod extends StealingMethod{

    private static final Logger LOG = LoggerFactory.getLogger(SubtleMethod.class);

    @Override
    protected String pickTarget() {
        return "shop keeper";
    }

    @Override
    protected void consfuseTarget(String target) {
        LOG.info("approach the {} with tears running and hug him.",target);
    }

    @Override
    protected void stealTheItem(String target) {
        LOG.info("while in close contact grab the {}'s wallet.",target);
    }
}
