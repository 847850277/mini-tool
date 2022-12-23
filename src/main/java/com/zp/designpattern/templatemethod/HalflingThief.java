package com.zp.designpattern.templatemethod;

/**
 * @author zhengpeng
 * @date 2022/12/23 4:52 下午
 **/
public class HalflingThief {

    public static void main(String[] args) {
        HalflingThief thief = new HalflingThief(new SubtleMethod());
        thief.steal();
        thief.changeMethod(new HitAndRunMethod());
        thief.steal();
    }


    private StealingMethod stealingMethod;

    public HalflingThief(StealingMethod stealingMethod) {
        this.stealingMethod = stealingMethod;
    }

    public void steal(){
        stealingMethod.steal();
    }

    public void changeMethod(StealingMethod method){
        this.stealingMethod = method;
    }
}
