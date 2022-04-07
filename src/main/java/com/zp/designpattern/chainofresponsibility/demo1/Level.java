package com.zp.designpattern.chainofresponsibility.demo1;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author zhengpeng
 * @date 2022-04-02 14:58
 **/
@Data
@AllArgsConstructor
public class Level {
    private Integer level = 0;

    /**
     * 比较等级
     * @param level
     * @return
     */
    public boolean above(Level level){
        return this.level >= level.getLevel();
    }
}
