package com.zp.leetcode.package2023.may.may11;

/**
 * @author zhengpeng
 * @date 2023/5/11 9:06 上午
 * 子串能表示从1到N数字的二进制串
 **/
public class QueryString {

    public static void main(String[] args) {
        QueryString queryString = new QueryString();
        String str = "0110";
        //int n = 3;
        int n = 4;
        System.out.println(queryString.queryString(str,n));

    }


    public boolean queryString(String s, int n) {
        for (int i = 1; i <= n; i++) {
            String childBinaryStr = toBinaryString(i);
            if(!s.contains(childBinaryStr)){
                return false;
            }
        }
        return true;
    }

    private String toBinaryString(int i) {
        return Integer.toBinaryString(i);
    }

}
