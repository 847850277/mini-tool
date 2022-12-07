package com.zp.leetcode.package2022.december.december06;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2022/12/6 9:10 上午
 * 字符串中不同整数的数目
 **/
public class NumDifferentIntegers {

    public static void main(String[] args) {

        //String s = "001";
        //System.out.println(Integer.valueOf(s));

        NumDifferentIntegers n = new NumDifferentIntegers();
        //String s = "a123bc34d8ef34";
        //String s = "leet1234code234";
        //String s = "a1b01c001";
        String s = "2393706880236110407059624696967828762752651982730115221690437821508229419410771541532394006597463715513741725852432559057224478815116557380260390432211227579663571046845842281704281749571110076974264971989893607137140456254346955633455446057823738757323149856858154529105301197388177242583658641529908583934918768953462557716";
        System.out.println(n.numDifferentIntegers(s));

    }

    Map<Character,Character> cMap = new HashMap(){{
       put('a',' ');
       put('b',' ');
       put('c',' ');
       put('d',' ');
       put('e',' ');
       put('f',' ');
       put('g',' ');
       put('h',' ');
       put('i',' ');
       put('j',' ');
       put('k',' ');
       put('l',' ');
       put('m',' ');
       put('n',' ');
       put('o',' ');
       put('p',' ');
       put('q',' ');
       put('r',' ');
       put('s',' ');
       put('t',' ');
       put('u',' ');
       put('v',' ');
       put('w',' ');
       put('x',' ');
       put('y',' ');
       put('z',' ');
       put('A',' ');
       put('B',' ');
       put('C',' ');
       put('D',' ');
       put('E',' ');
       put('F',' ');
       put('G',' ');
       put('H',' ');
       put('I',' ');
       put('J',' ');
       put('K',' ');
       put('L',' ');
       put('M',' ');
       put('N',' ');
       put('O',' ');
       put('P',' ');
       put('Q',' ');
       put('R',' ');
       put('S',' ');
       put('T',' ');
       put('U',' ');
       put('V',' ');
       put('W',' ');
       put('X',' ');
       put('Y',' ');
       put('Z',' ');
    }};

    public int numDifferentIntegers(String word) {
        Map<BigInteger,BigInteger> map = new HashMap<>();
        int len = word.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char c = word.charAt(i);
            if(cMap.containsKey(c)){
                sb.append(",");
            }else {
                sb.append(c);
            }
        }
        String[] split = sb.toString().split(",");
        for (String s : split) {
            if(!"".equals(s)){
                BigInteger b = new BigInteger(s);
                map.put(b,b);
            }
        }
        return map.keySet().size();
    }
}
