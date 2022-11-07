package com.zp.leetcode.package2022.november.november07;

/**
 * @author zhengpeng
 * @date 2022/11/7 4:06 下午
 * 子串能表示从 1 到 N 的二进制串
 **/
public class QueryString {

    public static void main(String[] args) {
        QueryString q = new QueryString();
        String s = "0110";
        //int n = 3;
        int n = 4;
        System.out.println(q.queryString(s,n));
    }

    public boolean queryString(String s, int n) {

        for (int i = 1; i <= n; i++) {
            String substring = i2Binary(i);
            if(s.indexOf(substring) < 0){
                return false;
            }
        }
        return true;

    }

    /**
     * 将整型数字转换为二进制字符串，一共32位，不舍弃前面的0
     * @param number 整型数字
     * @return 二进制字符串
     */
    private  String i2Binary1(int number) {
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < 32; i++){
            sBuilder.append(number & 1);
            number = number >>> 1;
        }
        return sBuilder.reverse().toString();
    }


    /***
     * 转成二进制字符串 ，不保留0
     * @param number
     * @return
     */
    private String i2Binary(int number) {
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < 32; i++){
            sBuilder.append(number & 1);
            number = number >>> 1;
        }
        int index = sBuilder.reverse().indexOf("1");
        return sBuilder.substring(index);
    }

}
