package com.zp.leetcode.package2022.june.june21;

/**
 * @author zhengpeng
 * @date 2022/6/21 9:54 上午
 * IP地址无效化
 **/
public class DefangIPaddr {


    public String defangIPaddr(String address) {
        return address.replaceAll("\\.","[\\.]");
    }

    public static void main(String[] args) {
        DefangIPaddr date = new DefangIPaddr();

        System.out.println(date.defangIPaddr("1.1.1.1"));
    }


}
