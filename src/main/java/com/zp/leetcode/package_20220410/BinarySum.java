package com.zp.leetcode.package_20220410;

/**
 * @author zhengpeng
 * @date 2022-04-10 17:42
 * 二进制求和
 **/
public class BinarySum {

    /**
     * 二进制求和
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        //TODO 以长的size，格式化短的size，使两个字符串一样长
        StringBuilder result = new StringBuilder();
        int size = a.length();
        //需要进位的变量
        boolean needCarray = false;
        for (int i = size-1; i >=0 ; i--) {
            //判断是否需要进位
            if(needCarray){
                if(a.charAt(i) == '1' && b.charAt(i) == '1'){
                    needCarray = true;
                    result.append('1');
                }else if(a.charAt(i) == '1' || b.charAt(i) == '1'){
                    needCarray = true;
                    result.append('0');
                }
                //不满足进位的条件判断
                 if(a.charAt(i) == '0' && b.charAt(i) == '0'){
                    needCarray = false;
                }
            }else {
                //
                if(a.charAt(i) == '1' && b.charAt(i) == '1'){
                    needCarray = true;
                    result.append("0");
                }
            }
        }
        if(needCarray){
            result.insert(0,'1');
        }

        return result.toString();
    }


    public static void main(String[] args) {
        BinarySum binarySum = new BinarySum();

        //System.out.println(binarySum.addBinary("11","01"));
        System.out.println(binarySum.addBinary("1010","1011"));
    }



}
