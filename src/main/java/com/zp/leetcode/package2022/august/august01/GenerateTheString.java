package com.zp.leetcode.package2022.august.august01;

/**
 * @author zhengpeng
 * @date 2022/8/1 9:18 上午
 * 生成每种字符串都是奇数个的字符串
 **/
public class GenerateTheString {


    public static void main(String[] args) {

    }
    public String generateTheString(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        //偶数个
        if(n % 2 == 0){
            int length =  n - 1;
            for(int i = 0; i < length; i++) {
                stringBuilder.append("s");
            }
            stringBuilder.append("a");
        //奇数个
        }else {
            for(int i = 0; i < n; i++) {
                stringBuilder.append("s");
            }
        }
        return stringBuilder.toString();
    }
}
