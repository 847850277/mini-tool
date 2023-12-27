package com.zp.leetcode.package2023.december.december26;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;

import java.util.Date;

public class Test {

    public static void main(String[] args) {


        //两数之和
        String a = "test";
        String b = "11";
        System.out.println(a.equals(b));


        Date date = new Date();
        System.out.println(DateUtil.beginOfDay(DateUtil.yesterday()));


    }

}
