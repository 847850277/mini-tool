package com.zp.leetcode.package2023.january.january11;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2023/1/11 2:28 下午
 * 判断一个数道德数字计数是否等于数位的值
 **/
public class DigitCount {

    public static void main(String[] args) {
        DigitCount digitCount = new DigitCount();
        //String num = "1210";
        String num = "030";
        System.out.println(digitCount.digitCount(num));


    }

    public boolean digitCount(String num) {
        Map<Character,Integer> cMap = new HashMap<>();
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            cMap.put(c, cMap.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            int i1 = Integer.parseInt(String.valueOf(c));
            char value_char  = (char) (i + '0');
            if(cMap.getOrDefault(value_char,0) != i1){
                return false;
            }
        }
        return true;
    }

}
