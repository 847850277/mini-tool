package com.zp.leetcode.package2023.june.june30;

/**
 * @author zhengpeng
 * @date 2023/6/30 10:41
 **/
public class IsCircularSentence {


    public static void main(String[] args) {
        //String sentence = "leetcode exercises sound delightful";
        //String sentence = "eetcode";
        String sentence = "Leetcode is cool";
        IsCircularSentence isCircularSentence = new IsCircularSentence();
        System.out.println(isCircularSentence.isCircularSentence(sentence));
    }


    public boolean isCircularSentence(String sentence) {
        String[] s = sentence.split(" ");
        for (int i = 0; i < s.length; i++) {
            //是最后一个，与第一个比较，
            String str = s[i];
            if(i == s.length - 1){
                return str.charAt(str.length() - 1) == s[0].charAt(0);
            }
            //其他情况
            String nextStr = s[i + 1];
            boolean b = str.charAt(str.length() - 1) == nextStr.charAt(0);
            if(!b){
                return false;
            }
        }
        return false;
    }
}
