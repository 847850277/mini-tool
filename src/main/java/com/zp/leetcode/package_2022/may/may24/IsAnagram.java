package com.zp.leetcode.package_2022.may.may24;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author zhengpeng
 * @date 2022/5/24 4:04 下午
 **/
public class IsAnagram {

    public boolean isAnagram(String s, String t) {
        if(s.equals(t)){
            return false;
        }
        if(s.length() != t.length()){
            return false;
        }

        int length = s.length();

        Map<Character,Integer> a = new HashMap<Character,Integer>();
        Map<Character,Integer> b = new HashMap<Character,Integer>();
        for (int i = 0; i < length; i++) {
            final char c = s.charAt(i);
            final char c1 = t.charAt(i);
            a.put(c, (a.getOrDefault(c,0) + 1));
            b.put(c1,(b.getOrDefault(c1,0) + 1));
        }
        for (Character character : a.keySet()) {
            if(Objects.isNull(a.get(character))){
                return false;
            }
            if(Objects.isNull(b.get(character))){
                return false;
            }
            if(a.get(character).compareTo(b.get(character)) != 0){
                return false;
            }
        }
        return  true;

    }

    public static void main(String[] args) {
        String s = "another";
        String t = "Integer";
        IsAnagram isAnagram = new IsAnagram();
        System.out.println(isAnagram.isAnagram(s,t));
    }
}
