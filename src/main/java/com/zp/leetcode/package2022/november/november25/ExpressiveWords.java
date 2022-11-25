package com.zp.leetcode.package2022.november.november25;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2022/11/25 9:18 上午
 * 情感丰富的文字
 **/
public class ExpressiveWords {


    public static void main(String[] args) {

        // 快慢指针只能匹配到一个删除，不能组合
//        String str = "heeellooo";
//        int left = 0, right = 0,count = 0;
//        char leftChar = str.charAt(left);
//        char rightChar = str.charAt(right);
//        for (int i = 1; i < str.length(); i++) {
//            char c = str.charAt(i);
//            if(c != leftChar){
//                left = i;
//                leftChar = c;
//            }else {
//
//            }
//
//        }

        String str = "heeellooo";
        String[] array = new String[]{"hello", "hi", "helo"};
        ExpressiveWords expressiveWords = new ExpressiveWords();
        System.out.println(expressiveWords.expressiveWords(str, array));

    }



    public int expressiveWords(String s, String[] words) {
        int ans = 0;
        for (String word : words) {
            if(expand(s,word)){
                ans++;
            }
        }
        return ans;
    }

    private boolean expand(String s, String t) {
        int i = 0,j = 0;
        //双指针
        while (i < s.length() && j < t.length()){
            if(s.charAt(i) != t.charAt(j)){
                return false;
            }
            char c = s.charAt(i);
            int iiCount = 0;
            while (i < s.length() && s.charAt(i) == c){
                ++iiCount;
                ++i;
            }
            int jjCount = 0;
            while (j < t.length() && t.charAt(j) == c){
                ++j;
                ++jjCount;
            }
            if(iiCount < jjCount){
                return false;
            }
            if(iiCount != jjCount && iiCount < 3){
                return false;
            }
        }
        return i == s.length() && j == t.length();
    }
}
