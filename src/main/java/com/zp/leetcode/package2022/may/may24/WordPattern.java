package com.zp.leetcode.package2022.may.may24;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2022/5/24 9:32 上午
 * 单词规律
 **/
public class WordPattern {

    public boolean wordPattern(String pattern, String s) {
        Map<Character,String> dict = new HashMap<Character,String>();
        Map<String,Character> dict1 = new HashMap<String,Character>();
        final String[] s1 = s.split(" ");
        if(s1.length != pattern.length()){
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            final char c = pattern.charAt(i);
            final String s2 = s1[i];
            if(!dict.containsKey(c)){
                dict.put(c,s2);
            }
            if(!dict1.containsKey(s2)){
                dict1.put(s2,c);
            }
            if(dict.containsKey(c)){
                if(!s2.equals(dict.get(c))){
                   return false;
                }
            }
            if(dict1.containsKey(s2)){
                if(c != dict1.get(s2)){
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        WordPattern wp = new WordPattern();

        System.out.println(wp.wordPattern("abba","dog cat cat dog"));
    }



}
