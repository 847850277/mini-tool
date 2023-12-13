package com.zp.leetcode.package2023.december.december07;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;

import java.util.Date;

public class Test {

    public static void main(String[] args) {
        String s = Convert.numberToChinese(100, false);
        System.out.println(s);
        DateTime data1 = DateUtil.parse("2023-12-10 12:00:00", DatePattern.NORM_DATETIME_PATTERN);
        DateTime data2 = DateUtil.parse("2023-12-07 00:00:00", DatePattern.NORM_DATETIME_PATTERN);
        DateTime data3 = DateUtil.parse("2023-12-08 00:00:00", DatePattern.NORM_DATETIME_PATTERN);
        DateTime data4 = DateUtil.parse("2023-12-11 00:00:00", DatePattern.NORM_DATETIME_PATTERN);
        DateTime data5 = DateUtil.parse("2023-12-20 00:03:00", DatePattern.NORM_DATETIME_PATTERN);
        Date now = new Date();

        long between1 = DateUtil.between(data1, now, DateUnit.DAY,false);
        long between2 = DateUtil.between(data2, now, DateUnit.DAY,false);
        long between3 = DateUtil.between(data3, now, DateUnit.DAY,false);
        long between4 = DateUtil.between(data4, now, DateUnit.DAY,false);
        long between5 = DateUtil.between(data5, now, DateUnit.DAY,false);
        System.out.println(between1);
        System.out.println(between2);
        System.out.println(between3);
        System.out.println(between4);
        System.out.println(between5);

    }

}
