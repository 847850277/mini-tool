package com.zp.leetcode.package2022.december.december13;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2022/12/13 8:55 上午
 * 判断句子是否全字母句
 **/
public class CheckIfPangram {

    public static void main(String[] args) {

        CheckIfPangram checkIfPangram = new CheckIfPangram();
        //String s = "leetcode";
        String s = "thequickbrownfoxjumpsoverthelazydog";
        System.out.println(checkIfPangram.checkIfPangram(s));

    }


    public boolean checkIfPangram(String sentence) {
        Map<Character,Integer> map = new HashMap<Character,Integer>(){{
           put('a',0);
           put('b',0);
           put('c',0);
           put('d',0);
           put('e',0);
           put('f',0);
           put('g',0);
           put('h',0);
           put('i',0);
           put('j',0);
           put('k',0);
           put('l',0);
           put('m',0);
           put('n',0);
           put('o',0);
           put('p',0);
           put('q',0);
           put('r',0);
           put('s',0);
           put('t',0);
           put('u',0);
           put('v',0);
           put('w',0);
           put('x',0);
           put('y',0);
           put('z',0);
        }};
        int len = sentence.length();
        for (int i = 0; i < len; i++) {
            char c = sentence.charAt(i);
            map.put(c,map.get(c) + 1);
        }
        for (Integer value : map.values()) {
            if(value == 0){
                return false;
            }
        }
        return true;
    }

}
