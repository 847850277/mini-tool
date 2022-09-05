package com.zp.leetcode.package2022.may.may07;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2022-05-07 09:08
 * 是同构字符串
 **/
public class Isomorphic {

    public boolean isIsomorphic2(String s, String t) {

        return (isIsomorphic(s,t) && isIsomorphic(t,s));
    }



    /**
     * 是同构字符串
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int length = s.length();
        StringBuilder sb = new StringBuilder();
        Map<Character,Character> dict = new HashMap<Character, Character>((int) (length * 1.75));
        for (int i = 0; i < length; i++) {
            final char c = s.charAt(i);
            final char c1 = t.charAt(i);
            if(!dict.containsKey(c)){
               dict.put(c,c1);
            }
            sb.append(dict.get(c));
        }
        return t.equals(sb.toString());
    }

    public static void main(String[] args) {

        Isomorphic isomorphic = new Isomorphic();

        //System.out.println(isomorphic.isIsomorphic("egg","add"));
        //System.out.println(isomorphic.isIsomorphic("paper","title"));
        System.out.println(isomorphic.isIsomorphic2("badc","baba"));

    }


}
