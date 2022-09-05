package com.zp.leetcode.package2022.june.june13;

/**
 * @author zhengpeng
 * @date 2022/6/10 10:57 上午
 * 字符串中单词个数
 **/
public class CountSegments {


    public int countSegments1(String s) {
        int n = s.length(), ans = 0;
        char last = ' ';
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if(c == ' ' && last != ' '){
                ans++;
            }
            last = c;
        }
        return last != ' '? ans+1 : ans;
    }


    public int countSegments(String s) {
        int count = 0;
        boolean isLink = false;
        boolean otherFlag = false;
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            if(!isBlankAndSplit(charAt)){
                isLink = true;
                otherFlag = true;
                if(i == s.length() - 1){
                    count++;
                }
            }else{
                if(otherFlag && isLink){
                    isLink = false;
                    otherFlag = false;
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isBlankAndSplit(char charAt) {
        if(',' == charAt || ' ' == charAt){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        CountSegments countSegments = new CountSegments();
        //System.out.println(countSegments.countSegments("Hello, my name is John"));
        //System.out.println(countSegments.countSegments("Hello, my name is John"));
        //System.out.println(countSegments.countSegments("love live! mu'sic forever"));
        //System.out.println(countSegments.countSegments("Hello"));
        //System.out.println(countSegments.countSegments(", , , ,        a, eaefa"));
        System.out.println(countSegments.countSegments1(", , , ,        a, eaefa"));
    }
}
