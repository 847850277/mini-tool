package com.zp.leetcode.package2023.may.may10;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhengpeng
 * @date 2023/5/10 9:28 上午
 **/
public class SmallestRepunitDivByK {

    public static void main(String[] args) {
        SmallestRepunitDivByK smallestRepunitDivByK = new SmallestRepunitDivByK();
        //System.out.println(smallestRepunitDivByK.smallestRepunitDivByK(2));
        System.out.println(smallestRepunitDivByK.smallestRepunitDivByK(7));



    }
    public int smallestRepunitDivByK(int k) {
        // resid为余数，len为数字长度，初始值为1
        int resid = 1 % k, len = 1;
        // 创建一个无序集合，用于存储余数
        Set<Integer> set = new HashSet<Integer>();
        // 插入余数1
        set.add(resid);
        // 当余数为0时退出循环
        while (resid != 0) {
            // 计算下一个余数
            resid = (resid * 10 + 1) % k;
            // 数字长度+1
            len++;
            // 如果余数重复出现，则无解
            if (set.contains(resid)) {
                return -1;
            }
            // 将余数插入集合
            set.add(resid);
        }
        // 返回数字长度
        return len;
    }
}
