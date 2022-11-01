package com.zp.leetcode.package2022.november.november01;

/**
 * @author zhengpeng
 * @date 2022/11/1 8:56 上午
 * 检查两个字符串数组是否相等
 **/
public class ArrayStringsAreEqual {

    public static void main(String[] args) {
        String[] array0 = new String[]{"a","bc","d"};
        String[] array1 = new String[]{"ab","c","d"};

        ArrayStringsAreEqual a = new ArrayStringsAreEqual();
        System.out.println(a.arrayStringsAreEqual(array0, array1));

    }


    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (String s : word1) {
            sb1.append(s);
        }
        for (String s : word2) {
            sb2.append(s);
        }
        return sb1.toString().equals(sb2.toString());
    }
}
