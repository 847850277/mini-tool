package com.zp.leetcode.package2022.september.september27;

import java.util.Arrays;

/**
 * @author zhengpeng
 * @date 2022/9/27 9:23 上午
 * 判断是否为字符串重新排列
 **/
public class CheckPermutation {

    public static void main(String[] args) {

        CheckPermutation checkPermutation = new CheckPermutation();
        String s1 = "abc";
        String s2 = "bca";
        System.out.println(checkPermutation.checkPermutation(s1,s2));
    }


    public boolean checkPermutation(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        s1 = String.valueOf(chars1);
        s2 = String.valueOf(chars2);
        return s1.equals(s2);
    }

}
