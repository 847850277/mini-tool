package com.zp.leetcode.package2022.june.june28;

/**
 * @author zhengpeng
 * @date 2022/6/28 10:44 上午
 * 重复的子字符串
 **/
public class RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {
        int length = s.length();
        if(length % 2 != 0){
            return false;
        }
        //循环除以2
        int divide = length / 2;
        while(divide > 1){
            String substring = s.substring(0,divide);
            String another = s.substring(divide,length);
            if(substring.equals(another)){
                return true;
            }
            length = divide;
            divide = length / 2;
        }

        String substring = s.substring(0,divide);
        String another = s.substring(divide,length);
        if(substring.equals(another)){
            return true;
        }

        return false;
    }


    public boolean repeatedSubstringPattern1(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }


    public static void main(String[] args) {

        RepeatedSubstringPattern repeatedSubstringPattern = new RepeatedSubstringPattern();
        //String s = "abab";
        //String s = "bb";
        String s = "ababab";
        System.out.println(repeatedSubstringPattern.repeatedSubstringPattern(s));
        System.out.println(repeatedSubstringPattern.repeatedSubstringPattern1(s));

    }


}
