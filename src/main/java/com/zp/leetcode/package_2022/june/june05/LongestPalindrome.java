package com.zp.leetcode.package_2022.june.june05;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2022/6/5 9:04 下午
 **/
public class LongestPalindrome {

    public int longestPalindrome(String s) {
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer count = map.getOrDefault(c,0);
            map.put(c,count + 1);
        }
        int result = 0;
        boolean start = false;
        if(map.keySet().size() == 1){
            return s.length();
        }
        for (Character character : map.keySet()) {
            Integer count = map.get(character);
            if(count % 2 == 0){
                result += count;
            }else{
                if(!start){
                    result  += count;
                    start = true;
                }else {
                    result += count - 1;
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        //String s = "a";
        //String s = "bb";
        //String s = "cbb";
        //String s = "abccccdd";
        //String s = "ccc";
        String s = "ababababa";
        System.out.println(longestPalindrome.longestPalindrome(s));

    }
}
