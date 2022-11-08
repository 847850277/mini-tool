package com.zp.leetcode.package2022.november.november08;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2022/11/8 9:12 上午
 * 统计一致字符串的数目
 **/
public class CountConsistentStrings {

    public static void main(String[] args) {
        String s = "abc";
        //String[] array = new String[]{"ad","bd","aaab","baa","badab"};
        String[] array = new String[]{"a","b","c","ab","ac","bc","abc"};
        CountConsistentStrings c = new CountConsistentStrings();
        System.out.println(c.countConsistentStrings(s, array));
    }

    public int countConsistentStrings(String allowed, String[] words) {
        int count = 0;
        for (String word : words) {
            Map<Character, Character> map = new HashMap<>();
            for (int i = 0; i < allowed.length(); i++) {
                map.put(allowed.charAt(i), allowed.charAt(i));
            }
//            boolean allContain = true;
//            for (Map.Entry<Character, Character> characterCharacterEntry : map.entrySet()) {
//                final Character key = characterCharacterEntry.getKey();
//                if (word.indexOf(key) < 0) {
//                    allContain = false;
//                    break;
//                }
//            }
//            if (!allContain) {
//                continue;
//            }
            int len = 0;
            for (int i = 0; i < word.length(); i++) {
                final char c = word.charAt(i);
                if (map.containsKey(c)) {
                    len++;
                }
            }
            if (len == word.length()) {
                count++;
            }
        }
        return count;
    }

}
