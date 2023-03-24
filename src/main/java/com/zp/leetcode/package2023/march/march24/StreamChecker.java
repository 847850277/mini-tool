package com.zp.leetcode.package2023.march.march24;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2023/3/24 9:11 上午
 * 字符流
 **/
public class StreamChecker {

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append('a')
                .append('a')
                .append('a')
                .append('a')
                .append('a')
                .append('b')
                .append('a');

        //String[] words = new String[]{"cd","f","kl"};
        //String[] words = new String[]{"ab", "ba", "aaab", "abab", "baa"};
        String[] words = new String[]{"abaa","abaab","aabbb","bab","ab"};
        StreamChecker streamChecker = new StreamChecker(words);
/*
        System.out.println(streamChecker.query('a'));
        System.out.println(streamChecker.query('b'));
        System.out.println(streamChecker.query('c'));
        System.out.println(streamChecker.query('d'));
        System.out.println(streamChecker.query('e'));
        System.out.println(streamChecker.query('f'));
        System.out.println(streamChecker.query('g'));
        System.out.println(streamChecker.query('h'));
        System.out.println(streamChecker.query('i'));
        System.out.println(streamChecker.query('j'));
        System.out.println(streamChecker.query('k'));
        System.out.println(streamChecker.query('l'));

         */
//        ["a"],["a"],["a"],["a"],["a"],["b"]
//        ,["a"],["b"],["a"],["b"],["b"],["b"]
//        ,["a"],["b"],["a"],["b"],["b"],["b"]
//        ,["b"],["a"],["b"],["a"],["b"],["a"]
//        ,["a"],["a"],["b"],["a"],["a"],["a"]

         /*
        System.out.println(streamChecker.query('a'));
        System.out.println(streamChecker.query('a'));
        System.out.println(streamChecker.query('a'));
        System.out.println(streamChecker.query('a'));
        System.out.println(streamChecker.query('a'));
        System.out.println(streamChecker.query('b'));

        System.out.println(streamChecker.query('a'));
        System.out.println(streamChecker.query('b'));
        System.out.println(streamChecker.query('a'));
        System.out.println(streamChecker.query('b'));
        System.out.println(streamChecker.query('b'));
        System.out.println(streamChecker.query('b'));


        System.out.println(streamChecker.query('a'));
        System.out.println(streamChecker.query('b'));
        System.out.println(streamChecker.query('a'));
        System.out.println(streamChecker.query('b'));
        System.out.println(streamChecker.query('b'));
        System.out.println(streamChecker.query('b'));

        System.out.println(streamChecker.query('b'));
        System.out.println(streamChecker.query('a'));
        System.out.println(streamChecker.query('b'));
        System.out.println(streamChecker.query('a'));
        System.out.println(streamChecker.query('b'));
        System.out.println(streamChecker.query('a'));

        System.out.println(streamChecker.query('a'));
        System.out.println(streamChecker.query('a'));
        System.out.println(streamChecker.query('b'));
        System.out.println(streamChecker.query('a'));
        System.out.println(streamChecker.query('a'));
        System.out.println(streamChecker.query('a'));
        */

        System.out.println(streamChecker.query('a'));
        System.out.println(streamChecker.query('a'));
        System.out.println(streamChecker.query('b'));
        System.out.println(streamChecker.query('b'));
        System.out.println(streamChecker.query('b'));
        System.out.println(streamChecker.query('a'));
    }



    private Map<Character, Map<String, String>> map = new HashMap<>();
    StringBuilder sb = new StringBuilder();

    public  StreamChecker(String[] words) {
        for (String word : words) {
            char c = reverse2(word).charAt(0);
            Map<String, String> orDefault = map.getOrDefault(c, new HashMap<>());
            orDefault.put(word,word);
            map.put(c, orDefault);
        }
    }

    public boolean query(char letter) {
        sb.append(letter);
//        if (!map.containsKey(letter)) {
//            return false;
//        }
        Map<String, String> stringStringMap = map.get(letter);
        String s = reverse2(sb.toString());
        for (int i = 1; i < s.length(); i++) {
            String substring = reverse2(s.substring(0,i));
            if (stringStringMap.containsKey(substring)) {
                return true;
            }
        }
        return false;
    }

    // toCharArray
    public static String reverse2(String str) {
        char[] chars = str.toCharArray();
        String reverse = "";
        for (int i = chars.length - 1; i >= 0; i--) {
            reverse += chars[i];
        }
        return reverse;
    }
}
