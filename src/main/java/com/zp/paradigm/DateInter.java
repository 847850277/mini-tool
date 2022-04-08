package com.zp.paradigm;

import java.util.Date;

/**
 * @author zhengpeng
 * @date 2022-04-07 15:26
 **/
public class DateInter extends Pair<Date> {

    /**
     * 重写方法
     * @return
     */
    @Override
    public Date getValue() {
        return super.getValue();
    }

    /**
     * 重写方法
     * @param value
     */
    @Override
    public void setValue(Date value) {
        super.setValue(value);
    }

//    /**
//     * 重载方法
//     * @param value
//     */
//    public void setValue(Object value) {
//        setValue(value);
//    }

    public static void main(String[] args) {
        DateInter dateInter = new DateInter();
        dateInter.setValue(new Date());
        //编译错误
        //dateInter.setValue(new Object());
    }

}
