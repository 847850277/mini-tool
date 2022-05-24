package com.zp.leetcode.package_2022.may.may24;

/**
 * @author zhengpeng
 * @date 2022/5/23 5:46 下午
 * 仅含1的子串数
 **/
public class NumSub {

    public int numSub(String s) {
        int length = s.length();
        char c = '1';
        int sum = 0;
        int start = 0;
        for (int i = 0; i < length; i++) {
            final char c1 = s.charAt(i);
            if(c != c1){
                sum += getCombination(start,i);
                start = i + 1;
            }
            //最后一条处理
            if(i == length -1 && c == c1){
                //若开始下标等于0
                sum += getCombination(start,i + 1);
                return sum;
            }
        }
        return sum;
    }

    private int getCombination(int start, int end) {
        int diff = end - start;
        int sum = 0;
        for (int i = 1; i <= diff; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        //String str = "11101";
        String str = "111101";
        //String str = "0110111";
        //String str = "1111";
        NumSub numSub = new NumSub();
        System.out.println(numSub.numSub(str));
    }
}
