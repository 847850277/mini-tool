package com.zp.leetcode.package2022.may.may29;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2022/5/29 9:00 下午
 * 字符串中的第一个唯一字符串
 **/
public class FirstUniqChar {

    public int firstUniqChar(String s) {
        Map<Character,Boolean> keyMap = new HashMap<Character,Boolean>();
        Map<Character,Integer> keyIndexMap = new HashMap<Character,Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(keyMap.containsKey(c)){
                keyMap.put(c,true);
            }else{
                keyMap.put(c,false);
                keyIndexMap.put(c,i);
            }
        }
        Integer result = Integer.MAX_VALUE;
        for (Character character : keyMap.keySet()) {
            if(!keyMap.get(character)){
                result = Math.min(keyIndexMap.get(character),result);
            }
        }
        return result == Integer.MAX_VALUE ? - 1 : result;
    }


    public static void main(String[] args) {
        String s = "leetcode";
        FirstUniqChar firstUniqChar = new FirstUniqChar();
        System.out.println(firstUniqChar.firstUniqChar(s));
    }
}
