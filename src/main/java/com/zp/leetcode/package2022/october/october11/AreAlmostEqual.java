package com.zp.leetcode.package2022.october.october11;

/**
 * @author zhengpeng
 * @date 2022/10/11 9:08 上午
 * 仅执行一次字符串交换能否使两个字符串相等
 **/
public class AreAlmostEqual {


    public static void main(String[] args) {

        AreAlmostEqual areAlmostEqual = new AreAlmostEqual();
        //String s1 = "bank";
        //String s2 = "kanb";

        String s1 = "attack";
        String s2 = "defend";

        System.out.println(areAlmostEqual.areAlmostEqual(s1, s2));

    }


    /**
     * 挨个遍历替换，如果发现有满足，返回true，否则返回false
     * @param s1
     * @param s2
     * @return
     */
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.equals(s2)){
            return true;
        }
        int len = s1.length();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                char ci = s1.charAt(i);
                char cj = s1.charAt(j);
                char[] temp = s1.toCharArray();
                temp[i] = cj;
                temp[j] = ci;
                String s = String.valueOf(temp);
                if(s.equals(s2)){
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * 遍历一次
     * @param s1
     * @param s2
     * @return
     */
    public boolean areAlmostEqual1(String s1, String s2) {
        if(s1.equals(s2))
            return true;
        //记录第一个不相等字符下标，和最后一个不相等字符下标
        int first = 0,second = 0;
        //记录s1、s2不相等的字符数
        int diff = 0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i) != s2.charAt(i)){
                if(diff==0)
                    first = i;
                else
                    second = i;
                diff++;
            }
        }
        //不相等字符数不等于2 直接返回false
        if(diff != 2)
            return false;
        //把s1的两个不相等字符交换位置得s，若s和s2相等，返回true，否则返回false
        char[] s = s1.toCharArray();
        s[first] = s1.charAt(second);
        s[second] = s1.charAt(first);
        if(s2.equals(new String(s)))
            return true;
        return false;
    }

}
