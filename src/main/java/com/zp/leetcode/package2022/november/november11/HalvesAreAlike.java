package com.zp.leetcode.package2022.november.november11;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2022/11/11 9:30 上午
 * 判断字符串的两半是否相似
 **/
public class HalvesAreAlike {

    public static void main(String[] args) {
        HalvesAreAlike has = new HalvesAreAlike();
        //String s = "book";
        String s = "textbook";
        System.out.println(has.halvesAreAlike(s));
    }

    public boolean halvesAreAlike(String s) {
        int len = s.length();
        Map<Character, Character> map = new HashMap<Character, Character>() {{
            put('a', ' ');
            put('e', ' ');
            put('i', ' ');
            put('o', ' ');
            put('u', ' ');
            put('A', ' ');
            put('E', ' ');
            put('I', ' ');
            put('O', ' ');
            put('U', ' ');
        }};
        String left = s.substring(0, len / 2);
        String right = s.substring(len / 2, len);
        int l = 0, r = 0;
        for (int i = 0; i < left.length(); i++) {
            if (map.containsKey(left.charAt(i))) {
                l++;
            }
        }
        for (int i = 0; i < right.length(); i++) {
            if (map.containsKey(right.charAt(i))) {
                r++;
            }
        }
        return l == r;
    }


}
