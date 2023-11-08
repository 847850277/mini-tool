package com.zp.leetcode.package2023.november.november07;

import java.util.HashMap;
import java.util.Map;

public class VowelStrings {

    public static void main(String[] args) {
        String[] words = new String[]{"are","amy","u"};
        int left = 0,right = 2;
        VowelStrings vowelStrings = new VowelStrings();
        System.out.println(vowelStrings.vowelStrings(words,left,right));
    }

    public int vowelStrings(String[] words, int left, int right) {
        int ans = 0;
        Map<Character,Character> map = new HashMap();
        map.put('a','a');
        map.put('e','a');
        map.put('i','a');
        map.put('o','a');
        map.put('u','a');
        for (int i = left; i <= right; i++) {
            String word = words[i];
            if(isReg(word,map)){
                ans ++;
            }
        }
        return ans;
    }

    private boolean isReg(String word,Map<Character,Character> map) {
        if(map.containsKey(word.charAt(0)) && map.containsKey(word.charAt(word.length() - 1))){
            return true;
        }
        return false;
    }
}
