package com.zp.leetcode.package2022.september.september29;

import java.util.Arrays;

/**
 * @author zhengpeng
 * @date 2022/9/29 9:05 上午
 * 字符串轮转
 **/
public class FlipedString {

    public static void main(String[] args) {
        FlipedString f = new FlipedString();
        String s1 = "abcd";
        String s2 = "acdb";
        System.out.println(f.isFlipedString(s1, s2));

    }


    /**
     * 两个字符串相加，一定有一个在其中
     * @param s1
     * @param s2
     * @return
     */
    public boolean isFlipedString2(String s1, String s2) {
        // 长度不相等，肯定不符合要求
        if (s1.length() != s2.length()) {
            return false;
        }

        // 长度相等时，若s2是s1旋转而成的，那么把s2和自身拼接一次，s1就会出现在其中
        // "erbottlewat" + "erbottlewat" = erbottle waterbottle wat
        // 如果s2不是s1旋转而成的，那么那么把s2和自身拼接一次，s1就肯定不会出现在其中
        return (s2 + s2).indexOf(s1) != -1;
    }


    public boolean isFlipedString(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        if(s1.equals(s2)){
            return true;
        }
        int len1 = s1.length();
        for (int i = 1; i < len1; i++) {
            String s = flipedStringBySize(i,s1);
            if(s.equals(s2)){
                return true;
            }
        }
        return false;
    }

    /**
     * 反转字符串
     * @param size
     * @param s1
     * @return
     */
    private String flipedStringBySize(int size, String s1) {
        StringBuilder sb = new StringBuilder();
        int len = s1.length();
        sb.append(s1.substring(size,len));
        sb.append(s1.substring(0,size));
        return sb.toString();
    }


}
