package com.zp.leetcode.package2022.june.june14;

/**
 * @author zhengpeng
 * @date 2022/6/14 9:33 上午
 * 统计同构字符串数目
 **/
public class CountHomogenous {

    public int countHomogenous(String s) {
        int length = s.length();
        Long sum = 0L;
        char last = s.charAt(0);
        int lastCount = 1;
        for (int i = 1; i < length; i++) {
            final char charAt = s.charAt(i);
            if(charAt == last){
                lastCount++;
            }else{
                sum += getSum(lastCount);
                last = charAt;
                lastCount = 1;
            }

        }
        if(lastCount != 0){
            sum += getSum(lastCount);
            lastCount = 0;
        }
        return (int) (sum % 1000000007);
    }

    private Long getSum(int lastCount) {
        Long sum = 0L;
        for(int i = 1; i <= lastCount; i++){
            sum+= i;
        }
        return sum;
    }

    public static void main(String[] args) {
        CountHomogenous countHomogenous = new CountHomogenous();
        //String s = "zzzzz";
        //String s = "xy";
        String s = "abbcccaa";
        System.out.println(countHomogenous.countHomogenous(s));
    }
}
