package com.zp.leetcode.package_2022.june.june01;

import java.util.HashMap;
import java.util.Map;


/**
 * @author zhengpeng
 * @date 2022/6/1 1:58 下午
 * 找不同
 **/
public class FindTheDifference {

    public char findTheDifference(String s, String t) {
        Map<Character,Integer> diff = new HashMap<Character,Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            diff.put(c,diff.getOrDefault(c,0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if(diff.containsKey(c)){
                int count = diff.get(c);
                count--;
                if(count < 0){
                    return c;
                }
                diff.put(c,count);
            }else{
                return c;
            }

        }
        return ' ';
    }

    public static void main(String[] args) {
        String s = "";
        String t = "y";
        FindTheDifference findTheDifference = new FindTheDifference();
        System.out.println(findTheDifference.findTheDifference(s,t));
    }
}
